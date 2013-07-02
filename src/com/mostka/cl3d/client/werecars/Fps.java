package com.mostka.cl3d.client.werecars;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.HTML;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;

public class Fps {

	private long startTime;
	private int framesTimes;
	private int count;
	private static HTML fpsPanel;

	public Fps(CopperLicht engine, HTML fpsPanel) {
		startTime = new Date().getTime();
		count = 0;
		framesTimes = 0;
		engine.setOnAfterDrawAll(onAfterDrawAll);
	}
	
	JsFunction onAfterDrawAll = new JsFunction() {
		public JavaScriptObject execute(JavaScriptObject args) {
			//show FPS
			long startTimeNow = new Date().getTime();
			long diff = startTimeNow - startTime;
			framesTimes += diff;
			count++;
			if (count == 10){
				fpsPanel.setHTML("FPS: " + ( framesTimes / 10 ));
				framesTimes = 0;
				count = 0;
			}
			startTime = startTimeNow;
			return null;
		}
	};
	
	public int getFps(){
		return framesTimes / count;
	}
	
}
