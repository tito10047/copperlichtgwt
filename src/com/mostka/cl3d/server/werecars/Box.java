package com.mostka.cl3d.server.werecars;

public class Box {

	public Position pos = new Position();
	public int type=0;
	public int topmost = -1;
	
	public Box() {}
	
	public Box(int x, int y, int z) {
		this.pos.x = x;
		this.pos.y = y;
		this.pos.z = z;
	}
	
	public Box(int type){
		this.type=type;
	}
	
}
