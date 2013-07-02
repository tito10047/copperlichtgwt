package com.mostka.cl3d.client.werecars;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	//String greetServer(String name) throws IllegalArgumentException;
	String getChanelId(String userId);
}
