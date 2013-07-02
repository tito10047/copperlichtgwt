package com.mostka.cl3d.shared.werecars.message;

public interface Type {
	public static final int box = 		0;
	public static final int boxes = 	1;
	public static final int car = 		2;
	public static final int cars = 		3;
	public static final int possition = 4;
	public static final int score = 	5;
	public static final int scores = 	6;
	public static final int userId = 	7;
	public static final int userName = 	8;
	public static final int startPossition = 9;
	public static final int onClose =	10;
	public static final int badChannel =11;
	public static final int newClient = 12;
	public static final int deadClient =13;
	
	public int getType();
	public void setType(int type);
}
