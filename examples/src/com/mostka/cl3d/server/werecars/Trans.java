package com.mostka.cl3d.server.werecars;

public interface Trans {
	/**
	 * trans
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public Position toBox(int x, int y, int z);
	/**
	 * itrans
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public Position fromBox(int x, int y, int z);
}
