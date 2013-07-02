package com.mostka.cl3d.server.werecars;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mostka.cl3d.client.werecars.GreetingService;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public String getChanelId(String userId) {

		ChannelService channelService = ChannelServiceFactory.getChannelService();
		
		String token = channelService.createChannel(userId);
		
		return token;
	}

}
