package com.mostka.cl3d.client.werecars;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.mostka.cl3d.shared.werecars.MessagesFactory;
import com.mostka.cl3d.shared.werecars.message.KeyState;
import com.mostka.cl3d.shared.werecars.message.Type;
import com.mostka.cl3d.shared.werecars.message.UserName;

public class Messages {
	private MessagesFactory messageFactory = GWT.create(MessagesFactory.class);
	//private Channel channel;
	
	public Messages(/*Channel channel*/) {
		//this.channel = channel;
	}

	public void sendType(int type){
		AutoBean<Type> order = messageFactory.getType();
		order.as().setType(type);
		send(order);
	}
	
	public void setKeyState(String userId, boolean jump, boolean up, boolean down, boolean left, boolean right){
		AutoBean<KeyState> order = messageFactory.getKeyState();
		order.as().setClientId(userId);
		order.as().setJump(jump);
		order.as().setUp(up);
		order.as().setDown(down);
		order.as().setLeft(left);
		order.as().setRight(right);
		order.as().setType(Type.mKeyState);
		send(order);
	}
	
	public void sendUserName(int myId, String myName){
		AutoBean<UserName> order = messageFactory.getUserName();
		
		order.as().setType(Type.tUserName);
		order.as().setId(myId);
		order.as().setName(myName);
		
		send(order);
	}
	
	public void send(AutoBean<?> bean){
		//channel.send(AutoBeanCodex.encode(bean).getPayload());
	}

}
