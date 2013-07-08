package com.mostka.cl3d.shared.werecars.message;

public interface KeyState extends Type{
	public boolean getJump();
	public void setJump(boolean jump);
	public boolean getUp();
	public void setUp(boolean up);
	public boolean getDown();
	public void setDown(boolean down);
	public boolean getLeft();
	public void setLeft(boolean left);
	public boolean getRight();
	public void setRight(boolean right);
	
}
