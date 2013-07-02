package com.mostka.cl3d.shared.werecars.message;

public interface Box extends Type, Position{
	public void setSize(int size);
	public int getSize();

	public int getBoxType();
	public void setBoxType(int boxType);
}
