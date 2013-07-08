package com.mostka.cl3d.server.werecars;

public interface ServerEmptyHandler {
	public void onServerEmpty(String serverName);
	public void kickPlayer(String playerId, int type);
}
