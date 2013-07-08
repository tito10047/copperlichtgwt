package com.mostka.cl3d.server.werecars;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;
import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;
import com.mostka.cl3d.shared.werecars.MessagesFactory;
import com.mostka.cl3d.shared.werecars.message.Type;
import com.mostka.ws.server.WebSocketServlet;

@SuppressWarnings("serial")
public class WsServer extends WebSocketServlet implements SendHandler  {

	private static HashMap<String, Server> servers = new HashMap<String, Server>();
	private static ArrayList<String> chanels =new ArrayList<String>(){{add("defaultChannel");}};
	final MessagesFactory messageFactory = AutoBeanFactorySource.create(MessagesFactory.class);
	
	public void onMessage(int token, final String channel, String message) {
		if (chanels.contains(channel)==false || servers.containsKey(channel)==false){
			Type type = Messages.createType(Type.mBadChannel);
			send(token, type);
			return;
		}
		Server server = servers.get(channel);
		
        System.out.println("Message: " + token + " - " + channel + " - " + message);
        Type type = AutoBeanCodex.decode(messageFactory, Type.class, message).as();

		server.addEvent(type.getType(),message);
	}

	@Override
	public void onClose(int token, String channel){
		Type type = Messages.createType(Type.mKicked);
		send(token, type);
		Server server = servers.get(channel);
		boolean serverIsEmpty = server.removeClient(token);
		if(serverIsEmpty){
			removeServer(channel);
		}
	}

	synchronized public void onJoin(int token, String channelName) {
		System.out.println("Join: " + token + " - " + channelName);
		
		if (chanels.contains(channelName)==false){
			System.out.println("badChannel");
			Type type = Messages.createType(Type.mBadChannel);
			send(token, type);
			return;
		}
		
		if (servers.containsKey(channelName)==false){
			try {
				createServer(channelName);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				Type type = Messages.createType(Type.mServerCrash);
				send(token, type);
				return;
			}
		}

		Server server = servers.get(channelName);
		server.addClient(token);
		System.out.println("Joined: " + token + " - " + channelName);
	}
	
	synchronized private void createServer(String channelName) throws Exception{
		Server server;
		server = new Server(this, channelName);
		
		HashMap<Integer, Long> players = new HashMap<>();
		servers.put(channelName, server);
	}
	
	synchronized public void removeServer(String serverName) {
		servers.remove(serverName);
	}
	
	public void send(int token, Object o) {
        AutoBean bean = AutoBeanUtils.getAutoBean(o);
        String serialized = AutoBeanCodex.encode(bean).getPayload();
        try {
			super.send(token, serialized);
		} catch (IOException | InvalidTokenException e) {
			e.printStackTrace();
		}
    }
}
