package com.mostka.cl3d.client;

import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.mostka.cl3d.wraper.CL3D;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.scene.MeshSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.util.Mesh;
import com.mostka.cl3d.wraper.util.MeshBuffer;
import com.mostka.cl3d.wraper.util.Vect3d;
import com.mostka.cl3d.wraper.util.Vertex3D;

public class CL3DFloor implements EntryPoint {
	
	private static CopperLicht engine;
	private Scene scene;
	private static MeshSceneNode cubeSceneNode=null;

	private Mesh myMesh;
	private MeshBuffer buf;
	private static JsArray<Vertex3D> vertices=null;
	private static int actualVertice = 0;
	private static HashMap<String, Boolean> verticesCoorects = new HashMap<String, Boolean>();

	private static MeshBuffer meshBuff;

	private Button button;
	
	public void onModuleLoad() {
		// create the 3d engine
		engine = CopperLicht.startCopperLichtFromFile("3darea","images/floor.ccbjs");
		engine.setOnLoadingComplete(new JsFunction() {

			public JavaScriptObject execute(JavaScriptObject args) {
				Scene scene = engine.getScene();
				if (scene!=null){
					// find the cube scene node
					cubeSceneNode = (MeshSceneNode) scene.getSceneNodeFromName("floor");

					//engine.getRenderer().updateRendererNativeArray(buff);
					meshBuff = cubeSceneNode.getMesh().GetMeshBuffers().get(1);
					vertices = meshBuff.getVertices();
					int len = meshBuff.getVerticesLength();
					boolean first = true;
					for(int i=0;i<len;i++){
						String vect = vertices.get(i).getPos().toString();
						if (verticesCoorects.containsKey(vect)==false){
							verticesCoorects.put(vect, first);
							first=false;
						}
					}
					
					scene.setRedrawMode(Scene.REDRAW_EVERY_FRAME);
					
				}
				button = new Button("çalculate accessible terrain");
				button.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calculate();
					}
				});
				RootPanel.get().add(button);
				return null;
			}
		});
		addKeyHandler() ;

	}
	
	public void calculate(){
		button.removeFromParent();
		Timer timer = new Timer() {
			public void run() {

				int color1 = CL3D.createColor(1, 0, 128, 0);
				int color2 = CL3D.createColor(1, 255, 0, 0);
				if (vertices!=null){
					if (actualVertice<vertices.length()){
						Vect3d vec1 = vertices.get(actualVertice).getPos();
						double vec1Z = vec1.getY();
						boolean vec1is = verticesCoorects.get(vec1.toString());
						Vect3d vec2 = vertices.get(actualVertice+1).getPos();
						double vec2Z = vec2.getY();
						boolean vec2is = verticesCoorects.get(vec2.toString());
						Vect3d vec3 = vertices.get(actualVertice+2).getPos();
						double vec3Z = vec3.getY();
						boolean vec3is = verticesCoorects.get(vec3.toString());
						int maxH = 20;
						if (vec1is){
							if (!vec2is && vec2Z < vec1Z+maxH && vec2Z > vec1Z-maxH){
								verticesCoorects.put(vec2.toString(), true);
								vertices.get(actualVertice+1).setColor(color1);
								vec2is=true;
							}
							if (!vec3is && vec3Z < vec1Z+maxH && vec3Z > vec1Z-maxH){
								verticesCoorects.put(vec3.toString(), true);
								vertices.get(actualVertice+2).setColor(color1);
								vec3is=true;
							}
							vertices.get(actualVertice).setColor(color1);
						}else{
							vertices.get(actualVertice).setColor(color2);
						}
						if (vec2is){
							if (!vec1is && vec1Z < vec2Z+maxH && vec1Z > vec2Z-maxH){
								verticesCoorects.put(vec1.toString(), true);
								vertices.get(actualVertice).setColor(color1);
								vec1is=true;
							}
							if (!vec3is && vec3Z < vec2Z+maxH && vec3Z > vec2Z-maxH){
								verticesCoorects.put(vec3.toString(), true);
								vertices.get(actualVertice+2).setColor(color1);
								vec3is=true;
							}
							vertices.get(actualVertice+1).setColor(color1);
						}else{
							vertices.get(actualVertice+1).setColor(color2);
						}
						if (vec3is){
							if (!vec2is && vec2Z < vec3Z+maxH && vec2Z > vec3Z-maxH){
								verticesCoorects.put(vec2.toString(), true);
								vertices.get(actualVertice+1).setColor(color1);
								vec2is=true;
							}
							if (!vec1is && vec1Z < vec3Z+maxH && vec1Z > vec3Z-maxH){
								verticesCoorects.put(vec1.toString(), true);
								vertices.get(actualVertice).setColor(color1);
								vec1is=true;
							}
							vertices.get(actualVertice+2).setColor(color1);
						}else{
							vertices.get(actualVertice+2).setColor(color2);
						}
						if (vec1is){
							if (!vec2is && vec2Z < vec1Z+maxH && vec2Z > vec1Z-maxH){
								verticesCoorects.put(vec2.toString(), true);
								vertices.get(actualVertice+1).setColor(color1);
								vec2is=true;
							}
							if (!vec3is && vec3Z < vec1Z+maxH && vec3Z > vec1Z-maxH){
								verticesCoorects.put(vec3.toString(), true);
								vertices.get(actualVertice+2).setColor(color1);
								vec3is=true;
							}
							vertices.get(actualVertice).setColor(color1);
						}else{
							vertices.get(actualVertice).setColor(color2);
						}
						
						
						actualVertice+=3;
						engine.getRenderer().updateRendererNativeArray(meshBuff);
					}else{
						this.cancel();
					}
				}
			}
		};
		timer.scheduleRepeating(20);
	}

	public static void keyPress(String key, Object event){
		
		// we need to call the key handler of the 3d engine as well, so that the user is
		// able to move the camera using the keys
		engine.handleKeyDown(event);
	}
	
	public final native void addKeyHandler() /*-{
		$wnd.document.onkeydown = function(event){
			@com.mostka.cl3d.client.CL3DFloor::keyPress(Ljava/lang/String;Ljava/lang/Object;)(String.fromCharCode(event.keyCode),event);
		}
	}-*/;
}
