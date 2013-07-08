package com.mostka.cl3d.shared.werecars.message;

public interface Position extends Type{

	int getX();
	int getY();
	int getZ();
	
	void setX(int x);
	void setY(int y);
	void setZ(int z);
}
