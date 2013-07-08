package com.mostka.cl3d.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.user.client.Window;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.Renderer;
import com.mostka.cl3d.wraper.scene.MeshSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.scene.SceneNode;
import com.mostka.cl3d.wraper.scene.SceneNodeAbs;
import com.mostka.cl3d.wraper.util.Mesh;
import com.mostka.cl3d.wraper.util.MeshBuffer;
import com.mostka.cl3d.wraper.util.Triangle3d;
import com.mostka.cl3d.wraper.util.Vertex3D;

public class MyFloorNode {

	public Mesh myMesh;
	public SceneNode sceneNode;
	private static MeshBuffer buf;
	public MyFloorNode(CopperLicht engine,MeshSceneNode cubeSceneNode) {
		sceneNode = SceneNode.create();
		sceneNode.setOnRegisterSceneNodeAbs(onRegisterSceneNodeAbs);
		sceneNode.setRenderer(render);
		
		myMesh = Mesh.create();
		buf = cubeSceneNode.getMesh().GetMeshBuffers().get(1);
		CL3DTut3.log(buf);
		CL3DTut3.debugObject("myMesh", myMesh);
		
		myMesh.AddMeshBuffer(buf);

	}

	
	public SceneNode getSceneNode(){
		return sceneNode;
	}
	
	public JsFunction onRegisterSceneNodeAbs = new JsFunction() {
		@Override
		public JavaScriptObject execute(JavaScriptObject args) {
			Scene scene = (Scene) args;
			scene.registerNodeForRendering(sceneNode, Scene.RENDER_MODE_DEFAULT);
			//SceneNodeAbs.OnRegisterSceneNodeAbsCall(sceneNode, scene);
			return null;
		}
	};
	
	private JsFunction render = new JsFunction() {
		public JavaScriptObject execute(JavaScriptObject args) {
			Renderer renderer = (Renderer) args;
			renderer.setWorld(sceneNode.getAbsoluteTransformation());
			//renderer.drawMesh(myMesh);
			renderer.updateRendererNativeArray(buf);
			renderer.drawMeshBuffer(buf, buf.getVerticesLength());
			return null;
		}
	};
	
	public Vertex3D createVertex(int x,int  y,int  z,int  s,int  t){
		Vertex3D vtx = Vertex3D.create(true);
		vtx.setPosX(x);
		vtx.setPosY(y);
		vtx.setPosZ(z);
		vtx.setTCoordsX(s);
		vtx.setTCoordsY(t);
		return vtx;
	}
}
