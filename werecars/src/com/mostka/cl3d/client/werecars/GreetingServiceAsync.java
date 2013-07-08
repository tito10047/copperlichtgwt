package com.mostka.cl3d.client.werecars;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync {
	//void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
	void getChanelId(String userId, AsyncCallback<String> callback);
}
