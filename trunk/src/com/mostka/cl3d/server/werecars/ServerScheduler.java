package com.mostka.cl3d.server.werecars;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.appengine.api.taskqueue.DeferredTask;
import com.mostka.cl3d.shared.werecars.message.Type;

@SuppressWarnings("serial")
public class ServerScheduler implements DeferredTask, Serializable {
	private HashMap<String, Long> playerslastMessage;
	private Server server;
	private ServerEmptyHandler onServerEmpty;
	private String serverName;
	private boolean destroyed = false;

	public ServerScheduler(String serverName, HashMap<String, Long> playerslastMessage, Server server, ServerEmptyHandler onServerEmpty) {
		this.playerslastMessage = playerslastMessage;
		this.server = server;
		this.onServerEmpty = onServerEmpty;
		this.serverName = serverName;
	}

	@Override
	public void run() {
		if (destroyed) {
			System.out.println("destroyed but still exist." + serverName);
			return;
		}
		long date = new Date().getTime();
		for (Entry<String, Long> player : playerslastMessage.entrySet()) {
			if (player.getValue() < date - 1000 * 60 * 60) {
				onServerEmpty.kickPlayer(player.getKey(), Type.mTimeout);
				playerslastMessage.remove(player.getKey());
				server.removeClient(player.getKey());
			}
		}
		if (playerslastMessage.size() == 0) {
			destroyed = true;
			onServerEmpty.onServerEmpty(serverName);
			playerslastMessage = null;
			server = null;
			onServerEmpty = null;
			return;
		}
		System.out.println("executed." + serverName);
		server.calculate();
	}
	public String getName(){
		return serverName;
	}

}
