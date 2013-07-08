package com.mostka.cl3d.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.mostka.cl3d.wraper.CL3D;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.animator.AnimatorCameraFPS;
import com.mostka.cl3d.wraper.scene.CameraSceneNode;
import com.mostka.cl3d.wraper.scene.CubeSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.scene.SkyBoxSceneNode;
import com.mostka.cl3d.wraper.util.Vect3d;

public class CL3DTut5 implements EntryPoint {
	
	private static CopperLicht engine;
	private Scene scene;
	
	public void onModuleLoad() {
		// create the 3d engine
		engine = CopperLicht.create("3darea");
		
		if (!engine.initRenderer()){
			Window.alert("this browser doesn't support WebGL");
			return;
		}
		
		// add a new 3d scene
		
		scene = Scene.create();
		engine.addScene(scene);
		
		scene.setBackgroundColor(CL3D.createColor(1, 0, 0, 0));
		scene.setRedrawMode(Scene.REDRAW_WHEN_SCENE_CHANGED);

		// add a sky box
		SkyBoxSceneNode skybox = SkyBoxSceneNode.create();
		scene.getRootSceneNode().addChild(skybox);

		// set texture sides of the skybox
		for (int i=0; i<6; ++i){
			skybox.getMaterial(i).setTex1(engine.getTextureManager().getTexture("images/stars.jpg", true));
		}

		// add a cube to test out
		CubeSceneNode cubenode = CubeSceneNode.create();
		scene.getRootSceneNode().addChild(cubenode);
		cubenode.getMaterial(0).setTex1(engine.getTextureManager().getTexture("images/crate_wood.jpg", true));
		
		// add a user controlled camera with a first person shooter style camera controller
		CameraSceneNode cam = CameraSceneNode.create();
		cam.setPos(20, 15); 
		
		AnimatorCameraFPS animator = AnimatorCameraFPS.create(cam, engine);										
		cam.addAnimator(animator);										
		animator.lookAt(Vect3d.create(0,0,0));	
		
		scene.getRootSceneNode().addChild(cam);
		scene.setActiveCamera(cam);		
		
		// now, we want to use a custom material for our cube, lets write
				// a vertex and a fragment shader:
				
			String vertex_shader_source = ""+
				"#ifdef GL_ES								\n"+
				"precision highp float;						\n"+
				"#endif										\n"+
				"uniform mat4 worldviewproj;				"+
				"attribute vec4 vPosition;					"+
				"attribute vec4 vNormal;					"+
				"attribute vec2 vTexCoord1;					"+
				"attribute vec2 vTexCoord2;					"+
				"varying vec2 v_texCoord1;					"+
				"varying vec2 v_texCoord2;					"+
				"void main()								"+
				"{											"+
				"	gl_Position = worldviewproj * vPosition;"+
				"	v_texCoord1 = vTexCoord1.st;			"+
				"	v_texCoord2 = vTexCoord2.st;			"+
				"}";
				
			String fragment_shader_source = ""+
				"#ifdef GL_ES												\n"+
				"precision highp float;										\n"+
				"#endif														\n"+
				"uniform sampler2D texture1;								"+
				"uniform sampler2D texture2;								"+
				"															"+
				"varying vec2 v_texCoord1;									"+
				"varying vec2 v_texCoord2;									"+
				"															"+
				"void main()												"+
				"{															"+
				"	vec2 texCoord = vec2(v_texCoord1.s, v_texCoord1.t);		"+
				"	gl_FragColor = texture2D(texture1, texCoord) * 2.0;		"+
				"}";
				
			// create a solid material using the shaders. For transparent materials, take a look
			// at the other parameters of createMaterialType
			
			int newMaterialType = engine.getRenderer().createMaterialType(vertex_shader_source, fragment_shader_source);
			if (newMaterialType != -1){
				cubenode.getMaterial(0).setType(newMaterialType);
			}else{
				Window.alert("could not create shader"); //copperLicht will write the exact error line in the html
			}
	}
}
