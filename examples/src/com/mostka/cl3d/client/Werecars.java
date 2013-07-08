package com.mostka.cl3d.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.mostka.cl3d.client.werecars.Fps;
import com.mostka.cl3d.client.werecars.Messages;
import com.mostka.cl3d.client.werecars.ScoreBoard;
import com.mostka.cl3d.shared.werecars.MessagesFactory;
import com.mostka.cl3d.shared.werecars.message.Box;
import com.mostka.cl3d.shared.werecars.message.Boxes;
import com.mostka.cl3d.shared.werecars.message.Type;
import com.mostka.cl3d.shared.werecars.message.UserId;
import com.mostka.cl3d.shared.werecars.message.UserName;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.animator.AnimatorCameraFPS;
import com.mostka.cl3d.wraper.scene.CameraSceneNode;
import com.mostka.cl3d.wraper.scene.CubeSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.scene.SceneNode;
import com.mostka.cl3d.wraper.scene.SceneNodeAbs;
import com.mostka.cl3d.wraper.scene.SkyBoxSceneNode;
import com.mostka.cl3d.wraper.util.Vect3d; 

public class Werecars implements EntryPoint {
	
	private static CopperLicht engine;
	private static Scene scene;
	private SceneNodeAbs rootSceneNode;
	
	private boolean showDebug = true;
	private boolean showFps = true;
	private static RootPanel debugPanel;
	private static RootPanel fpsDataPanel;
	private static int debugLineNumb = 0;
	private static boolean key_space;
	private static boolean key_left;
	private static boolean key_up;
	private static boolean key_right;
	private static boolean key_down;
	private int dateTimeSent;
	private int countSent;
	private Fps fpsManager;
	private ScoreBoard scoreBoars;

	private Messages messages;
	private MessagesFactory messageFactory = GWT.create(MessagesFactory.class);
	
	private ArrayList<String> carsList = new ArrayList<String>();
	private HashMap<String, SceneNode> cars = new HashMap<String, SceneNode>();
	private String userId;
	
	public static void log(String str){
		debugPanel.insert(new HTML(debugLineNumb+": "+str), 0);
	}
	
	public void onModuleLoad() {
		
		/*if (Websocket.isSupported()==false){
			Window.alert("Websocked is not suported");
			return;
		}*/
		
		debugPanel = RootPanel.get("debug");
		fpsDataPanel = RootPanel.get("fps-data");
		countSent = 0;
		dateTimeSent = 0;
		
		engine = CopperLicht.startCopperLichtFromFile("3darea", "werecars/copperlichtdata/nova_scena.ccbjs");
		
		engine.setOnLoadingComplete(new JsFunction() {

			public JavaScriptObject execute(JavaScriptObject args) {

				scene = engine.getScene();
				scene.setName("main");
				if (scene == null){
					Window.alert("some wrong with scene");
					return null;
				}
				


				HTML fpsPanel = new HTML();
				RootPanel.get("fps").add(fpsPanel);
				fpsManager = new Fps(engine, fpsPanel);
				HTML scoreLabel = new HTML();
				RootPanel.get("scores").add(scoreLabel);
				scoreBoars = new ScoreBoard(scoreLabel);
				
				// ================================
				// = Settings =
				// ================================
				rootSceneNode = scene.getRootSceneNode();
				
				// Plot the sky (sky box)
				SkyBoxSceneNode skybox = SkyBoxSceneNode.create();
				rootSceneNode.addChild(skybox);
				
				// Set the texture for the background sky
				for (int i = 0; i<6;i++){
					if (i>0 && i<3){
						skybox.getMaterial(i).setTex1(
								engine.getTextureManager().getTexture( "werecars/texture/stars"+i+".jpg",true)
						);
					}else{
						skybox.getMaterial(i).setTex1(
								engine.getTextureManager().getTexture( "werecars/texture/stars.jpg",true)
						);
					}
				}
				
				SceneNode car1SceneNode = (SceneNode) scene.getSceneNodeFromName("car1");
				SceneNode car2SceneNode = (SceneNode) scene.getSceneNodeFromName("car2");
				SceneNode car3SceneNode = (SceneNode) scene.getSceneNodeFromName("car3");
				
				car1SceneNode.setVisible(false);
				car2SceneNode.setVisible(false);
				car3SceneNode.setVisible(false);
				
				scene.setRedrawMode(Scene.REDRAW_EVERY_FRAME);
				
				// camera
				CameraSceneNode cam = CameraSceneNode.create();
				
				// put cam to scene
				cam.setPos(30, 10, 30);
				
				// cam.setFov(40); // Sets the field of view of the camera
				cam.setAspectRatio(4/3);
				cam.setFarValue(200);
				
				AnimatorCameraFPS animator = AnimatorCameraFPS.create(cam, engine);
				animator.setMoveSpeed(0.005);
				animator.setRotateSpeed(250);
				animator.setLookByMouseDown(false);
				animator.setMayMove(true);
				
				cam.addAnimator(animator);
				
				rootSceneNode.addChild(cam);
				scene.setActiveCamera(cam);
				
				/*channel = new Channel("defaultChannel");
				channel.addChannelListener(channelListener);
				messages = new Messages(channel);
				channel.join();*/
				
				//createCar("dsad", car3SceneNode);
				
				return null;
			}
		});
		

		
		
		addKeyHandler();
	}
	
	private void ChanelTest(String message){
		/*
        AutoBean<MyMessage> bean = AutoBeanCodex.decode(myFactory, MyMessage.class, message);
        return bean.as();*/
	}
	private String myId;
	private String myName;
	/*private ChannelListener channelListener = new ChannelListener() {
		public void onOpen() {
			CL3DTut3.log("opened");
			sendKeyState.scheduleRepeating(100);
			
			/*AutoBean<UserName> order = messageFactory.getUserName();
			
			order.as().setType(Type.tUserName);
			order.as().setId(myId);
			order.as().setName(myName);
			
			channel.send(AutoBeanCodex.encode(order).getPayload());
			
		}
		
		public void onMessage(String message) {
			CL3DTut3.log("received");
			log("> "+message);
			Type type = AutoBeanCodex.decode(messageFactory, Type.class, message).as();
			switch (type.getType()){
			case Type.mBadChannel: Window.alert("bad chanel");break;
			case Type.mServerCrash: Window.alert("Server crash");break;
			case Type.tUserId: 
				UserId myUserId = AutoBeanCodex.decode(messageFactory, UserId.class, message).as();
				userId = myUserId.getId();break;
			/*case Type.userId:
				UserId userId = AutoBeanCodex.decode(messageFactory, UserId.class, message).as();
				myId = userId.getId();
				
				AutoBean<UserName> order = messageFactory.getUserName();
				
				order.as().setType(Type.userName);
				order.as().setId(myId);
				order.as().setName(myName);
				
				channel.send(AutoBeanCodex.encode(order).getPayload());
				
				break;
			case Type.tBoxes:
				
				break;
			}
			
		}
		public void onError(int code, String description) {
			CL3DTut3.log("error");
			CL3DTut3.log(description);
			
		}
		public void onClose() {
			CL3DTut3.log("close");
			messages.sendType(Type.mOnClose);
			sendKeyState.cancel();
		}
	};*/
	
	private void onMessageStaticBoxes(Boxes boxesMess){
		log("loading level");
		Box[] boxes = boxesMess.getBoxes();
		for(Box box : boxes){
			CubeSceneNode cubeNode = CubeSceneNode.create(box.getSize());
			cubeNode.setPos(box.getX(), box.getY(), box.getZ());
			rootSceneNode.addChild(cubeNode);
			cubeNode.getMaterial(0).setTex1(
				engine.getTextureManager()
				.getTexture(
						"/werecars/levels/cube/"+box.getType()+".jpg", true)
			);
		}
	}
	
	private void createCar(String id, SceneNode car){
		log("createCar");
		SceneNode carNode = (SceneNode) scene.getSceneNodeFromName(
				"car" + ( Math.floor( (Math.random() * 3) + 1.5 ) )
		);
		carNode.createClone(scene.getRootSceneNode());
		
		carNode.setPos(
				car.getPos().getX(),
				car.getPos().getY(),
				car.getPos().getZ()
		);
		carNode.setVisible(true);
		
		int carScale = 1;
		carNode.setScale( Vect3d.create(carScale, carScale, carScale) );
		
		// Id add a new car to the list of already drawn cars
		carsList.add(id);
		
		// Save the information about the car in the list of cars
		cars.put(id, carNode);
	}
	
	private void deleteCar(String id){
		log("deleteCar");
		
		//  car removed from the list of cartoon cars
		carsList.remove(id);
		
		// delete car from scene
		scene.getRootSceneNode().removeChild( cars.get(id) );
		
		// delete car from lis
		cars.remove(id);
	}
	
	Timer sendKeyState = new Timer() {
		public void run() {
			if (key_space || key_up || key_down || key_left || key_right){
				messages.setKeyState(userId,key_space, key_up, key_down, key_left, key_right);
			}
		}
	};
	
	public final native String concatObject(Object obj) /*-{
		var str = '';
		for (prop in obj) {
			str += prop + " value :" + obj[prop] + "\n";
		}
		return (str);
	}-*/;
	public static void onKeyDown(int keyCode, Object event){
		switch (keyCode) {
		case 32:
			key_space = true;
			log("key_space keydown");
			break;
		case 39:
			key_left = true;
			log("key_left keydown");
			break;
		case 38:
			key_up = true;
			log("key_up keydown");
			break;
		case 37:
			key_right = true;
			log("key_right keydown");
			break;
		case 40:
			key_down = true;
			log("key_down keydown");
			break;
		}
	}
	public static void onKeyUp(int keyCode, Object event){
		switch (keyCode) {
		case 32:
			key_space = false;
			log("key_space keyup");
			break;
		case 39:
			key_left = false;
			log("key_left keyup");
			break;
		case 38:
			key_up = false;
			log("key_up keyup");
			break;
		case 37:
			key_right = false;
			log("key_right keyup");
			break;
		case 40:
			key_down = false;
			log("key_down keyup");
			break;
		}
		
		
		// we need to call the key handler of the 3d engine as well, so that the user is
        // able to move the camera using the keys
        //engine.handleKeyUp(event);
			
	}
	
	public final native void addKeyHandler() /*-{
		var docOnKeyUp = $wnd.document.onkeyup;
		$wnd.document.onkeyup = function(event){
			docOnKeyUp(event);
			@com.mostka.cl3d.client.Werecars::onKeyUp(ILjava/lang/Object;)(event.keyCode,event);
		}
		var docOnKeyDown = $wnd.document.onkeydown;
		$wnd.document.onkeydown = function(event){
			docOnKeyDown(event);
			@com.mostka.cl3d.client.Werecars::onKeyDown(ILjava/lang/Object;)(event.keyCode,event);
		}
	}-*/;
}
