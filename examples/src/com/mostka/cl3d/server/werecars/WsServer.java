package com.mostka.cl3d.server.werecars;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;
import com.mostka.cl3d.shared.werecars.MessagesFactory;
import com.mostka.cl3d.shared.werecars.message.Type;

@SuppressWarnings("serial")
public class WsServer /*extends ChannelServer*/ implements ServerEmptyHandler  {

	private static HashMap<String, Server> servers = new HashMap<String, Server>();
	private static ArrayList<String> chanels =new ArrayList<String>(){{add("defaultChannel");}};
	private HashMap<String, HashMap<String,Long>> playerslastMessage = new HashMap<>();
	
	public void onMessage(String token, final String channel, String message) {
		if (chanels.contains(channel)==false || servers.containsKey(channel)==false){
			Type type = Messages.createType(Type.mBadChannel);
			//send(token, type);
			return;
		}
		playerslastMessage.get(channel).put(token, new Date().getTime());
		Server server = servers.get(channel);
		
		
		final MessagesFactory messageFactory = AutoBeanFactorySource.create(MessagesFactory.class);
        System.out.println("Message: " + token + " - " + channel + " - " + message);
        Type type = AutoBeanCodex.decode(messageFactory, Type.class, message).as();
        
		if (type.getType()==Type.mOnClose){
			this.onClose(token, channel, message);
			return;
		}
		server.addEvent(type.getType(),message);
	}
	
	protected void onClose(String token, final String channel, String message){
		Server server = servers.get(channel);
		server.removeClient(token);
	}

	private static boolean serverLocker = false;
	protected void onJoin(String token, String channelName) {
		int i=0;
		while(serverLocker){
			if (i++>1000){
				Type type = Messages.createType(Type.mServerCrash);
				//send(token, type);
				System.out.println("cant join server. server is locked");
				return;
			}
		}
		serverLocker=true;
		System.out.println("Join: " + token + " - " + channelName);
		
		if (chanels.contains(channelName)==false){
			System.out.println("badChannel");
			Type type = Messages.createType(Type.mBadChannel);
			//send(token, type);
			return;
		}
		
		if (servers.containsKey(channelName)==false){
			try {
				createServer(channelName);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				Type type = Messages.createType(Type.mServerCrash);
				//send(token, type);
				return;
			}
		}

		Server server = servers.get(channelName);
		server.addClient(token);
		playerslastMessage.get(channelName).put(token, new Date().getTime());
		System.out.println("Joined: " + token + " - " + channelName);
		serverLocker=false;
	}
	
	private void createServer(String channelName) throws Exception{
		Server server;
		server = new Server(this);
		
		HashMap<String, Long> players = new HashMap<>();
		ServerScheduler scheduler = new ServerScheduler(channelName, players, server, this);
		Test.addServer(scheduler);
		playerslastMessage.put(channelName, players);
		servers.put(channelName, server);
	}
	
	@Override
	public void onServerEmpty(String serverName) {
		int i=0;
		while(serverLocker){
			if (i++>1000){
				break;
			}
		}
		serverLocker=true;
		Test.removeServer(serverName);
		servers.remove(serverName);
		playerslastMessage.remove(serverName);
		serverLocker=false;
	}

	public void sendPublic(String channel, Object o) {
		//send(channel, o);
	}
	
	@Override
	public void kickPlayer(String playerId, int type) {
		Type types = Messages.createType(type);
		//send(playerId, types);
	}
}
