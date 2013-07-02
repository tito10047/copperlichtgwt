package com.mostka.cl3d.shared.werecars.message;

import java.util.HashMap;

public interface Cars extends Type{
	void setCars(HashMap<String, Car> cars);
	HashMap<String, Car> getCars();
}
