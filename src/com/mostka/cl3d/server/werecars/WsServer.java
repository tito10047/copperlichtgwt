package com.mostka.cl3d.server.werecars;

import java.util.Arrays;
import java.util.HashMap;

import sun.misc.Lock;

import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;
import com.mostka.cl3d.shared.werecars.MessagesFactory;
import com.mostka.cl3d.shared.werecars.message.Type;

import no.eirikb.gwtchannelapi.server.ChannelServer;

public class WsServer extends ChannelServer  {

	private static HashMap<String, Server> servers = new HashMap<String, Server>();
	private static String[] chanels = new String[]{"default"};
	
	public void onMessage(String token, final String channel, String message) {
		if (Arrays.asList(chanels).contains(channel)==false || servers.containsKey(channel)==false){
			Type type = Messages.createType(Type.badChannel);
			send(token, type);
			return;
		}
		Server server = servers.get(channel);
		
		
		final MessagesFactory messageFactory = AutoBeanFactorySource.create(MessagesFactory.class);
        System.out.println("Message: " + token + " - " + channel + " - " + message);
        Type type = AutoBeanCodex.decode(messageFactory, Type.class, message).as();
        
		if (type.getType()==Type.onClose){
			this.onClose(token, channel, message);
			return;
		}
		server.addEvent(type.getType(),message);
	}
	
	protected void onClose(String token, final String channel, String message){
		Server server = servers.get(channel);
		server.removeClient(token);
	}

	protected void onJoin(String token, String channelName) {
		System.out.println("Join: " + token + " - " + channelName);
		
		if (Arrays.asList(chanels).contains(channelName)==false){
			Type type = Messages.createType(Type.badChannel);
			send(token, type);
			return;
		}
		
		if (servers.containsKey(channelName)==false){
			Server server = new Server(this);
			servers.put(channelName, server);
		}
		Server server = servers.get(channelName);
		server.addClient(token);
	}

	public void sendPublic(String channel, Object o) {
		send(channel, o);
	}
	
}
