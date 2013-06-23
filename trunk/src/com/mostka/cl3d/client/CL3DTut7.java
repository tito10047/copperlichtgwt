package com.mostka.cl3d.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.scene.AnimatedMeshSceneNode;
import com.mostka.cl3d.wraper.scene.CubeSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;

public class CL3DTut7 implements EntryPoint {
	
	private static CopperLicht engine;
	private static Scene scene;
	private static CubeSceneNode cubeSceneNode=null;
	private static CubeSceneNode cubeCollisionPosition = null;
	private static ArrayList<AnimatedMeshSceneNode> soldiers = new ArrayList<AnimatedMeshSceneNode>();
	private static int lastPlayedAnimation = 0;
	private static String[] animations = new String[]{"walk", "stand", "idle_a", "aim"};
	
	public void onModuleLoad() {
		
		engine = CopperLicht.startCopperLichtFromFile("3darea", "images/copperlichtdata/animation.ccbjs");
		
		// every time the user presses space, we want to do a collision test with the wall
		// and create a cube where we hit the wall
		
		engine.setOnLoadingComplete(new JsFunction() {
			public JavaScriptObject execute(JavaScriptObject args) {

				scene = engine.getScene();
				if (scene == null){
					Window.alert("some wrong with scene");
					return null;
				}
				soldiers.add( (AnimatedMeshSceneNode) scene.getSceneNodeFromName("soldier"));
				
				return null;
			}
		});
		addKeyHandler();
	}

	public static void onKeyUp(int key, Object event){
		
		if (soldiers.get(0)!=null){
			
			if (key==32){ // space has been pressed

                // switch to next animation
                // select the next animation:
				
				++lastPlayedAnimation;
				if (lastPlayedAnimation > animations.length - 1){
                    lastPlayedAnimation = 0;
				}
				
				String nextAnimationName = animations[lastPlayedAnimation];
				
				// and set it to be played
                for (int i=0;i<soldiers.size();i++){
                    soldiers.get(i).setAnimation(nextAnimationName);
                }
				
			}else if (key == 67 || key == 99){
				
				// clone soldier
				
				AnimatedMeshSceneNode clone = (AnimatedMeshSceneNode) soldiers.get(0).createClone(scene.getRootSceneNode());
				clone.setPosAdd(
						(Math.random() * 50) - 25,
						0,
						(Math.random() * 50) - 25);
				soldiers.add(clone);
			}
			
			// we need to call the key handler of the 3d engine as well, so that the user is
            // able to move the camera using the keys
            engine.handleKeyUp(event);
			
		}
	}
	
	public final native void addKeyHandler() /*-{
		$wnd.document.onkeyup = function(event){
			@com.mostka.cl3d.client.CL3DTut7::onKeyUp(ILjava/lang/Object;)(event.keyCode,event);
		}
	}-*/;
}
