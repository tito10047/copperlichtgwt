package com.mostka.cl3d.shared.werecars;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.mostka.cl3d.shared.werecars.message.Box;
import com.mostka.cl3d.shared.werecars.message.Boxes;
import com.mostka.cl3d.shared.werecars.message.Cars;
import com.mostka.cl3d.shared.werecars.message.KeyState;
import com.mostka.cl3d.shared.werecars.message.Position;
import com.mostka.cl3d.shared.werecars.message.Scores;
import com.mostka.cl3d.shared.werecars.message.Type;
import com.mostka.cl3d.shared.werecars.message.UserId;
import com.mostka.cl3d.shared.werecars.message.UserName;

public interface MessagesFactory extends AutoBeanFactory{
	AutoBean<UserId> getId();
	AutoBean<Boxes> getBoxes();
	AutoBean<Box> getBox();
	AutoBean<Position> getPosition();
	AutoBean<Scores> getScores();
	AutoBean<Cars> getCars();
	AutoBean<UserName> getUserName();
	AutoBean<Type> getType();
	AutoBean<KeyState> getKeyState();
}
