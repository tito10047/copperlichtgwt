package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.selector.MetaTriangleSelector;

public class Scene extends JavaScriptObject {

	/**
	 * Constant for using in Scene.setRedrawMode, specifying the scene should be
	 * redrawn only when the camera changed
	 */
	public final static int REDRAW_WHEN_CAM_MOVED = 2;
	/**
	 * Constant for using in Scene.setRedrawMode, specifying the scene should be
	 * redrawn only when the scene has changed
	 */
	public final static int REDRAW_WHEN_SCENE_CHANGED = 1;
	/**
	 * Constant for using in Scene.setRedrawMode, specifying the scene should be
	 * redrawn every frame.
	 */
	public final static int REDRAW_EVERY_FRAME = 2;
	/**
	 * Constant for using in Scene.registerNodeForRendering, specifying the
	 * render mode of a scene node.
	 */
	public final static int RENDER_MODE_SKYBOX = 1;
	/**
	 * Constant for using in Scene.registerNodeForRendering, specifying the
	 * render mode of a scene node.
	 */
	public final static int RENDER_MODE_DEFAULT = 0;

	/**
	 * Constant for using in Scene.registerNodeForRendering, specifying the
	 * render mode of a scene node.
	 */
	public final static int RENDER_MODE_LIGHTS = 2;

	/**
	 * Constant for using in Scene.registerNodeForRendering, specifying the
	 * render mode of a scene node.
	 */
	public final static int RENDER_MODE_CAMERA = 3;
	/**
	 * Constant for using in Scene.registerNodeForRendering, specifying the
	 * render mode of a scene node.
	 */
	public final static int RENDER_MODE_TRANSPARENT = 4;
	/**
	 * Constant for using in Scene.registerNodeForRendering, specifying the
	 * render mode of a scene node.
	 */
	public final static int RENDER_MODE_2DOVERLAY = 5;
	
	protected Scene() {
	}

	/**
	 * A 3d scene, containing all SceneNodes. The scene holds all SceneNodes and
	 * is able to draw and animate them.
	 */

	public static native Scene create() /*-{
		return new $wnd.CL3D.Scene();
	}-*/;

	/**
	 * Draws and animates the whole 3D scene. Not necessary to call usually,
	 * CopperLicht is doing this itself by default.
	 * 
	 * @param renderer
	 *            Renderer used for drawing.
	 */
	public final native JavaScriptObject drawAll(JavaScriptObject renderer) /*-{
		return this.drawAll(renderer);
	}-*/;

	/**
	 * Forces the renderer to redraw this scene the next frame, independent of
	 * the currently used redraw mode.
	 */
	public final native JavaScriptObject forceRedrawNextFrame() /*-{
		return this.forceRedrawNextFrame();
	}-*/;

	/**
	 * Returns the currently active {CL3D.CameraSceneNode} in the scene.
	 */
	public final native CameraSceneNode getActiveCamera() /*-{
		return this.getActiveCamera();
	}-*/;

	/**
	 * Returns all scene nodes in this scene with the specified type SceneNodes.
	 * 
	 * @param type
	 *            type name of the SceneNode. See SceneNode.getType().
	 */
	public final native JavaScriptObject getAllSceneNodesOfType(String type) /*-{
		return this.getAllSceneNodesOfType(type);
	}-*/;

	/**
	 * Gets the background color of the scene
	 */
	public final native JavaScriptObject getBackgroundColor() /*-{
		return this.getBackgroundColor();
	}-*/;

	/**
	 * Returns the automatically generated collision geometry containing all
	 * scene nodes with had the collision flag set to true in the editor.
	 */
	public final native MetaTriangleSelector getCollisionGeometry() /*-{
		return this.getCollisionGeometry();
	}-*/;

	/**
	 * Returns the current mode of rendering, can be for example
	 * Scene.RENDER_MODE_TRANSPARENT. Is useful for scene nodes which render
	 * themselves for example both solid and transparent.
	 */
	public final native JavaScriptObject getCurrentRenderMode() /*-{
		return this.getCurrentRenderMode();
	}-*/;

	/**
	 * Returns the name of the scene
	 */
	public final native JavaScriptObject getName() /*-{
		return this.getName();
	}-*/;

	/**
	 * Returns the root SceneNode, the root of the whole scene graph.
	 */
	public final native SceneNodeAbs getRootSceneNode() /*-{
		return this.getRootSceneNode();
	}-*/;

	/**
	 * Returns the first SceneNode in this scene with the specified id.
	 * 
	 * @param id
	 *            name of the SceneNode. See SceneNode.getId().
	 */
	public final native JavaScriptObject getSceneNodeFromId(int id) /*-{
		return this.getSceneNodeFromId(id);
	}-*/;

	/**
	 * Returns the first SceneNode in this scene with the specified name.
	 * 
	 * @param name
	 *            name of the SceneNode. See SceneNode.getName().
	 */
	public final native SceneNodeAbs getSceneNodeFromName(String name) /*-{
		return this.getSceneNodeFromName(name);
	}-*/;

	/**
	 * Returns the type string of the current scene.
	 */
	public final native JavaScriptObject getSceneType() /*-{
		return this.getSceneType();
	}-*/;

	/**
	 * Returns the start time in milliseconds of this scene. Useful for
	 * Animators.
	 */
	public final native JavaScriptObject getStartTime() /*-{
		return this.getStartTime();
	}-*/;

	/**
	 * @param x
	 * @param y
	 * @param onlyThoseWhoBlockCameraInput
	 */
	public final native JavaScriptObject isCoordOver2DOverlayNode(JavaScriptObject x, JavaScriptObject y, JavaScriptObject onlyThoseWhoBlockCameraInput) /*-{
		return this
				.isCoordOver2DOverlayNode(x, y, onlyThoseWhoBlockCameraInput);
	}-*/;

	/**
	 * @param n
	 * @param x
	 * @param y
	 * @param onlyThoseWhoBlockCameraInput
	 */
	public final native JavaScriptObject isCoordOver2DOverlayNodeImpl(JavaScriptObject n, JavaScriptObject x, JavaScriptObject y, JavaScriptObject onlyThoseWhoBlockCameraInput) /*-{
		return this.isCoordOver2DOverlayNodeImpl(n, x, y,
				onlyThoseWhoBlockCameraInput);
	}-*/;

	/**
	 * Used for Scene nodes to register themselves for rendering When called
	 * SceneNode.OnRegisterSceneNode, a scene node should call this method to
	 * register itself for rendering if it decides that it wants to be rendered.
	 * In this way, scene nodes can be rendered in the optimal order.
	 * 
	 * @param s
	 *            Node which registers itself for rendering
	 * @param mode
	 *            render mode the scene node wishes to register itself. Usually,
	 *            use
	 */
	public final native JavaScriptObject registerNodeForRendering(SceneNodeAbs s, int mode) /*-{
		return this.registerNodeForRendering(s, mode);
	}-*/;

	/**
	 * Sets the currently active {CL3D.CameraSceneNode} in the scene.
	 * 
	 * @param activeCamera
	 *            The new active camera
	 */
	public final native JavaScriptObject setActiveCamera(CameraSceneNode activeCamera) /*-{
		return this.setActiveCamera(activeCamera);
	}-*/;

	/**
	 * Sets the background color for the scene
	 * 
	 * @param clr
	 *            New color. See
	 */
	public final native JavaScriptObject setBackgroundColor(int clr) /*-{
		return this.setBackgroundColor(clr);
	}-*/;

	/**
	 * Sets the name of the scene
	 * 
	 * @param name
	 */
	public final native JavaScriptObject setName(JavaScriptObject name) /*-{
		return this.setName(name);
	}-*/;

	/**
	 * Specifies when the scene should be redrawn.
	 * 
	 * @param mode
	 *            Possible values are
	 */
	public final native JavaScriptObject setRedrawMode(int mode) /*-{
		return this.setRedrawMode(mode);
	}-*/;

}