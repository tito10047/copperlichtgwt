package com.mostka.cl3d.server.werecars;

import java.util.HashMap;

import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;
import com.mostka.cl3d.shared.werecars.MessagesFactory;
import com.mostka.cl3d.shared.werecars.message.Boxes;
import com.mostka.cl3d.shared.werecars.message.Cars;
import com.mostka.cl3d.shared.werecars.message.KeyState;
import com.mostka.cl3d.shared.werecars.message.Position;
import com.mostka.cl3d.shared.werecars.message.Score;
import com.mostka.cl3d.shared.werecars.message.Scores;
import com.mostka.cl3d.shared.werecars.message.Type;
import com.mostka.cl3d.shared.werecars.message.UserId;
import com.mostka.cl3d.shared.werecars.message.UserName;
import com.mostka.cl3d.shared.werecars.message.Box;
import com.mostka.cl3d.shared.werecars.message.Car;

public class Messages {
	static final MessagesFactory messageFactory = AutoBeanFactorySource.create(MessagesFactory.class);
	
	public static KeyState getKeyState(String message){
		return AutoBeanCodex.decode(messageFactory, KeyState.class, message).as();
	}
	public static UserName getUserName(String message){
		return AutoBeanCodex.decode(messageFactory, UserName.class, message).as();
	}
	
	public static UserId createId(int id){
		UserId obj = messageFactory.getId().as();
		obj.setType(Type.tUserId);
		obj.setId(id);
		return obj;
	}
	public static Boxes createBoxes(Box[] boxes){
		Boxes obj = messageFactory.getBoxes().as();
		obj.setType(Type.tBoxes);
		obj.setBoxes(boxes);
		return obj;
	}
	public static Position createPosition(int x, int y, int z){
		Position obj = messageFactory.getPosition().as();
		obj.setType(Type.tPossition);
		obj.setX(x);
		obj.setY(y);
		obj.setZ(z);
		return obj;
	}
	public static Position createStartStartPosition(com.mostka.cl3d.server.werecars.Position pos){
		Position obj = messageFactory.getPosition().as();
		obj.setType(Type.tStartPossition);
		obj.setX(pos.x);
		obj.setY(pos.y);
		obj.setZ(pos.z);
		return obj;
	}
	public static Scores createScores(Score[] scores){
		Scores obj = messageFactory.getScores().as();
		obj.setType(Type.tScores);
		obj.setScores(scores);
		return obj;
	}
	public static Cars createCars(HashMap<String, Car> cars){
		Cars obj = messageFactory.getCars().as();
		obj.setType(Type.tCars);
		obj.setCars(cars);
		return obj;
	}
	public static UserName createUserName(int id, String name){
		UserName obj = messageFactory.getUserName().as();
		obj.setType(Type.tUserName);
		obj.setId(id);
		obj.setName(name);
		return obj;
	}
	public static Box createBox(int x, int y, int z, int size, int type){
		Box obj = messageFactory.getBox().as();
		obj.setType(Type.tBox);
		obj.setX(x);
		obj.setY(y);
		obj.setZ(z);
		obj.setBoxType(type);
		obj.setSize(size);
		return obj;
	}
	public static Type createType(int type){
		Type obj = messageFactory.getType().as();
		obj.setType(type);
		return obj;
	}
	
}
