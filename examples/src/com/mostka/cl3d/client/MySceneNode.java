package com.mostka.cl3d.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.Renderer;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.scene.SceneNode;
import com.mostka.cl3d.wraper.scene.SceneNodeAbs;
import com.mostka.cl3d.wraper.util.Mesh;
import com.mostka.cl3d.wraper.util.MeshBuffer;
import com.mostka.cl3d.wraper.util.Vertex3D;

public class MySceneNode{

	public Mesh myMesh;
	public SceneNode sceneNode;
	private MeshBuffer buf;

	public MySceneNode(CopperLicht engine) {
		sceneNode = SceneNode.create();
		sceneNode.setOnRegisterSceneNodeAbs(onRegisterSceneNodeAbs);
		sceneNode.setRenderer(render);
		
		myMesh = Mesh.create();
		buf = MeshBuffer.create();
		myMesh.AddMeshBuffer(buf);
		
		// set indices and vertices
		JsArrayNumber arr = (JsArrayNumber) JsArrayNumber.createArray();
		int[] iarr = new int[]{0,2,3, 2,1,3, 1,0,3, 2,0,1};
		for(int i : iarr){
			arr.push(i);
		}
		
		buf.setIndices(arr);
		
		buf.getVertices().push(createVertex( 0, 0,  10,   0, 0));
		buf.getVertices().push(createVertex( 10,0, -10,   1, 0));
		buf.getVertices().push(createVertex( 0, 20, 0,    0, 1));
		buf.getVertices().push(createVertex(-10,20,-10,   1, 1));
		
		buf.getVertices().set(3, createVertex(-50,20,-10,   1, 1));
		CL3DTut3.log(buf);
		// set the texture of the material
		
		buf.getMat().setTex1( engine.getTextureManager().getTexture("images/test.jpg", true));

	}
	
	public SceneNode getSceneNode(){
		return sceneNode;
	}
	
	public JsFunction onRegisterSceneNodeAbs = new JsFunction() {
		@Override
		public JavaScriptObject execute(JavaScriptObject args) {
			Scene scene = (Scene) args;
			scene.registerNodeForRendering(sceneNode, Scene.RENDER_MODE_DEFAULT);
			SceneNodeAbs.OnRegisterSceneNodeAbsCall(sceneNode, scene);
			return null;
		}
	};
	
	private JsFunction render = new JsFunction() {
		public JavaScriptObject execute(JavaScriptObject args) {
			Renderer renderer = (Renderer) args;
			renderer.setWorld(sceneNode.getAbsoluteTransformation());
			renderer.drawMesh(myMesh);
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
