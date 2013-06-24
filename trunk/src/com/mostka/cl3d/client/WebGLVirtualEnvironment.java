package com.mostka.cl3d.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.CanPlayThroughEvent;
import com.google.gwt.event.dom.client.CanPlayThroughHandler;
import com.google.gwt.event.dom.client.EndedEvent;
import com.google.gwt.event.dom.client.EndedHandler;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.animator.AnimatorFlyStraight;
import com.mostka.cl3d.wraper.animator.AnimatorFollowPath;
import com.mostka.cl3d.wraper.scene.CameraSceneNode;
import com.mostka.cl3d.wraper.scene.CubeSceneNode;
import com.mostka.cl3d.wraper.scene.MeshSceneNode;
import com.mostka.cl3d.wraper.scene.PathSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.util.ContextWebGL;
import com.mostka.cl3d.wraper.util.WebGlTexture;

public class WebGLVirtualEnvironment implements EntryPoint {
	
	private static CopperLicht engine;
	private static Scene scene;
	private static CubeSceneNode cubeSceneNode=null;
	private static int defaultTransitionSpeed = 2000;
	private static int transitionSpeed = defaultTransitionSpeed;
	private ContextWebGL gl;
	private static CameraSceneNode cam;
	private Timer videoTimer;
	private static String[] zonesInvolved = null;

	public void onModuleLoad() {
		
		Canvas canvas = Canvas.createIfSupported();
		RootPanel n3DDiv = RootPanel.get("3DDiv");
		n3DDiv.add(canvas);
		canvas.getElement().setAttribute("id", "3DArea");
		canvas.setSize("840px", "600px");
		canvas.setCoordinateSpaceWidth(840);
		canvas.setCoordinateSpaceHeight(600);
		
		gl = ContextWebGL.create(canvas);
		if (gl==null) {
			Window.alert("Unable to initialize WebGL. Your browser may not support it.");
			return;
		}
        
        //Load the scene into the <canvas> "3darea"
		engine = CopperLicht.startCopperLichtFromFile("3DArea", "WebGLVirtualEnvironmentData/copperlichtdata/CamZoneTransition.ccbjs");
		
		engine.setOnLoadingComplete(initScene);
		
	}
	

	private Video videoElement;
	private JsFunction initScene = new JsFunction() {

		public JavaScriptObject execute(JavaScriptObject args) {

	        //Get scene from engine instance.
			scene = engine.getScene();
			
			if (scene==null){
				Window.alert("Some wrong with scene");
				return null;
			}

	        //Get the camera from the scene     
			cam = (CameraSceneNode) scene.getSceneNodeFromName("Camera1");
	        //We are looking at the zone "zona2"
			cam.setTarget(scene.getSceneNodeFromName("zona2").getAbsolutePosition());
	        
	        //Create a new animator that follows the "Entrance" path defined in the scene
			AnimatorFollowPath entrancePathAnimator = AnimatorFollowPath.create(scene);
			entrancePathAnimator.setOptions(AnimatorFollowPath.EFPFEM_STOP, transitionSpeed, false);
			entrancePathAnimator.setPathToFollow( (PathSceneNode) scene.getSceneNodeFromName("Entrance"));
			
			//Attach the animator to cam
			cam.addAnimator(entrancePathAnimator);
			
			//Load interactions for the default zone (zona2)
			loadInteractions("zona2");

	        //Video Test
			
			RootPanel testVideoDiv = RootPanel.get("testVideoDiv");
			videoElement = new Video("WebGLVirtualEnvironmentData/video/Big_Buck_Bunny_small.ogv");
			testVideoDiv.add(videoElement);
			videoElement.addCanPlayThroughHandler(new CanPlayThroughHandler() {
				public void onCanPlayThrough(CanPlayThroughEvent event) {
					videoElement.play();
					videoTimer = new Timer() {
						public void run() {
							updateTexture();
						}
					};
					videoTimer.scheduleRepeating(15);
				}
			});
			
			videoElement.addEndedHandler(new EndedHandler() {
				public void onEnded(EndedEvent event) {
					videoTimer.cancel();
				}
			});
	        
	        // Start listening for the canplaythrough event, so we don't
		    // start playing the video until we can do so without stuttering
			
			
			
			
			return null;
		}
	};
	private static AnimatorFlyStraight zoneTransition;
	
	public void updateTexture(){
		MeshSceneNode videoNode = (MeshSceneNode) scene.getSceneNodeFromName("video2");
		WebGlTexture videoTexture = videoNode.getMaterial(0).getTex1().getWebGLTexture();
		
		gl.bindTexture(ContextWebGL.TEXTURE_2D, videoTexture);
		gl.texParameteri(ContextWebGL.TEXTURE_2D, ContextWebGL.TEXTURE_MAG_FILTER, ContextWebGL.LINEAR);
		gl.texImage2D(ContextWebGL.TEXTURE_2D, 0, ContextWebGL.RGBA, ContextWebGL.RGBA,ContextWebGL.UNSIGNED_BYTE, videoElement.getVideoElement());
		gl.texParameteri(ContextWebGL.TEXTURE_2D, ContextWebGL.TEXTURE_MAG_FILTER, ContextWebGL.LINEAR);
		gl.texParameteri(ContextWebGL.TEXTURE_2D, ContextWebGL.TEXTURE_MIN_FILTER, ContextWebGL.LINEAR);
		gl.texParameteri(ContextWebGL.TEXTURE_2D, ContextWebGL.TEXTURE_WRAP_S, ContextWebGL.CLAMP_TO_EDGE);
		gl.texParameteri(ContextWebGL.TEXTURE_2D, ContextWebGL.TEXTURE_WRAP_T, ContextWebGL.CLAMP_TO_EDGE);
		gl.bindTexture(ContextWebGL.TEXTURE_2D, null);
		
	}
	
	public static void goToZone(String targetId){
		
		zonesInvolved = targetId.split("-");
		
		//Create the animator for the cam "lookAt" vector (we are looking at one zone and we want to look at the following)
        zoneTransition = AnimatorFlyStraight.create( scene.getSceneNodeFromName(zonesInvolved[0]).getAbsolutePosition(), 
                                                        scene.getSceneNodeFromName(zonesInvolved[1]).getAbsolutePosition(), 
                                                        transitionSpeed, false, true, true);
        
        //Create the animator for the cam position. It will follow a path defined in the scene 
        AnimatorFollowPath zonePathAnimator = AnimatorFollowPath.create(scene);
        zonePathAnimator.setOptions(AnimatorFollowPath.EFPFEM_STOP, transitionSpeed, false);
        zonePathAnimator.setPathToFollow( (PathSceneNode) scene.getSceneNodeFromName(targetId));
        
        //Remove possible previous animators from the cam
        removeAllAnimators(cam);
        
        //Add the new animators to perform the transition
        cam.addAnimator(zonePathAnimator);
        cam.addAnimator(zoneTransition);
        
        //Load the interactions of the new zone
        loadInteractions(zonesInvolved[1]);
	}
	
	private static void removeAllAnimators(CameraSceneNode sceneNode) {
		JsArray<CameraSceneNode> animators = sceneNode.getAnimators();
        for (int i = 0; i < animators.length(); i++){
        	CameraSceneNode animator = animators.get(i);
        	sceneNode.removeAnimator(animator);
        }
	}

	private static native void bindInteractionEvents() /*-{
		//on click zoneInteraction go to some other zone
        $wnd.$('.zoneInteraction').on("click", function(event){
        	@com.mostka.cl3d.client.WebGLVirtualEnvironment::goToZone(Ljava/lang/String;)(event.target.id);
        });
        
        //mousover on actionInteraction appends and fades textInfo in 
        $wnd.$('.actionInteraction').on("mouseover", function(event){
	       	$wnd.$('#interactionsDiv').append($wnd.$('#tpl_'+ event.target.id).html());
        	$wnd.$('#textInfoInteraction').fadeIn();
        });
        
        //mouseout of actionInteraction fades out and removes texInfo
        $wnd.$('.actionInteraction').on("mouseout", function(event){
			//$("#interactionsDiv").remove("#textInfoInteraction"); not working ??       
			$wnd.$('#textInfoInteraction').remove(); 
        });
		
	}-*/;
	
	private final native static void loadInteractions(String zoneName) /*-{
		//Load the interactions of the new zone
        $wnd.$("#interactionsDiv").html( $wnd.$("#tpl_"+zoneName+"Interactions").html() );
        //Hide and disable them first, then fade them in and enable
        $wnd.$(".interaction").hide().attr("disabled", "disabled").fadeIn(@com.mostka.cl3d.client.WebGLVirtualEnvironment::transitionSpeed, function() { 
			$wnd.$(this).removeAttr("disabled");
		});
        
        //Bind events to perform concrete action per interaction
       @com.mostka.cl3d.client.WebGLVirtualEnvironment::bindInteractionEvents()();
	}-*/;
		
	public static void onKeyUp(int key, Object event){
		
	}
	
	public final native void addKeyHandler() /*-{
		$wnd.document.onkeyup = function(event){
			@com.mostka.cl3d.client.WebGLVirtualEnvironment::onKeyUp(ILjava/lang/Object;)(event.keyCode,event);
		}
	}-*/;
}
