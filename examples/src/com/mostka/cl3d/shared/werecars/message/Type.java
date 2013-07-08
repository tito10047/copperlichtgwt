package com.mostka.cl3d.shared.werecars.message;

public interface Type {
	public static final int tBox = 			0;
	public static final int tBoxes = 		1;
	public static final int tCar = 			2;
	public static final int tCars = 		3;
	public static final int tPossition = 	4;
	public static final int tScore = 		5;
	public static final int tScores = 		6;
	public static final int tUserId = 		7;
	public static final int tUserName = 	8;
	public static final int tStartPossition = 9;
	public static final int mOnClose =		10;
	public static final int mBadChannel =	11;
	public static final int mNewClient = 	12;
	public static final int mDeadClient =	13;
	public static final int mKeyState =		14;
	public static final int mServerCrash =	15;
	public static final int mTimeout =		16;
	public static final int mKicked =		17;
	
	public int getType();
	public void setType(int type);
	public String getClientId();
	public void setClientId(String jump);
}
