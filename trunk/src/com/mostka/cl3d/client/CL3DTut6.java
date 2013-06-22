package com.mostka.cl3d.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.animator.AnimatorCameraFPS;
import com.mostka.cl3d.wraper.animator.AnimatorCollisionResponse;
import com.mostka.cl3d.wraper.scene.CameraSceneNode;
import com.mostka.cl3d.wraper.scene.CubeSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.util.Vect3d;

public class CL3DTut6 implements EntryPoint {
	
	private static CopperLicht engine;
	private Scene scene;
	private static CubeSceneNode cubeSceneNode=null;
	private static CubeSceneNode cubeCollisionPosition = null;
	
	public void onModuleLoad() {
		// create the 3d engine
		engine = CopperLicht.startCopperLichtFromFile("3darea","images/copperlichtdata/room.ccbjs");
		engine.setOnLoadingComplete(new JsFunction() {

			public JavaScriptObject execute(JavaScriptObject... args) {
				Scene scene = engine.getScene();
				if (scene==null){
					Window.alert("some problem");
				}
				// in the CopperCube 3d editor, we already created a camera which collides against the wall in this scene.
				// But to demonstrate how this would work manually, we create a new camera here which does this as well:
				
				// add a user controlled camera
				
				CameraSceneNode cam = CameraSceneNode.create();
				
				// ensure to place the camera inside the room, or it will fall out, into the endless void
				
				cam.setPos(-50, 180, 20);
				CL3DWraper.log(cam);
				// add an animator which makes the camera move by keyboard and mouse input
				
				AnimatorCameraFPS animator = AnimatorCameraFPS.create(cam, engine);	
				animator.setMoveSpeed(0.2);
				animator.setRotateSpeed(700);
				animator.setLookByMouseDown(false);
				cam.addAnimator(animator);
				animator.lookAt(Vect3d.create(-200, 90, 200));
				
				scene.getRootSceneNode().addChild(cam);
				scene.setActiveCamera(cam);		

				// add the collision response animator to collide against walls
				
				AnimatorCollisionResponse colanimator = AnimatorCollisionResponse.create(
						Vect3d.create(20,40,20), // size of the player ellipsoid
						Vect3d.create(0,-10,0), // gravity direction
						Vect3d.create(0,30,0), // position of the eye in the ellipsoid
						scene.getCollisionGeometry()
				);
				cam.addAnimator(colanimator);
				return null;
			}
		});

		// every time the user presses space, we want to do a collision test with the wall
		// and create a cube where we hit the wall
		addKeyHandler() ;

	}

	public static void keyPress(int key, Object event){

	    Scene scene = engine.getScene();
		if (scene==null){
			return;
		}
		if (key == 32){ // space has been pressed
			
			CameraSceneNode cam = scene.getActiveCamera();
			
			// calculate the start and end 3d point of the line, the beinning being
			// the camera position and the end about 2000 units away in the direction of the
			// camera target
			
			Vect3d startLine = cam.getAbsolutePosition();
			Vect3d endLine = startLine.add(cam.getTarget().substract(startLine).multiplyWithScal(2000));
			
			// test our line for a collision with the world
			
			Vect3d collisionPoint = scene.getCollisionGeometry().getCollisionPointWithLine(startLine, endLine, true, null,true);
			
			if (collisionPoint!=null){
				
				// a collision has been found.
				// create a cube at the point where the collision happened
				
				if (cubeCollisionPosition!=null)
				{
					cubeCollisionPosition = CubeSceneNode.create();
					scene.getRootSceneNode().addChild(cubeCollisionPosition);
					cubeCollisionPosition.getMaterial(0).setTex1(engine.getTextureManager().getTexture("images/ground_stone.jpg", true));
				}
				
				cubeCollisionPosition.setPos(collisionPoint);
				
			}
			
		}
		
		// we need to call the key handler of the 3d engine as well, so that the user is
		// able to move the camera using the keys
		engine.handleKeyDown(event);
	}
	
	public final native void addKeyHandler() /*-{
		$wnd.document.onkeydown = function(event){
			@com.mostka.cl3d.client.CL3DTut6::keyPress(ILjava/lang/Object;)(event.keyCode,event);
		}
	}-*/;
}
