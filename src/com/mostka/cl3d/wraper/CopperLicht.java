package com.mostka.cl3d.wraper;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.util.Vect3d;

public class CopperLicht extends JavaScriptObject {

	protected CopperLicht() {
	}

	/**
	 * The main class of the CopperLicht engine, representing the 3D engine
	 * itself.
	 * 
	 * @param elementIdOfCanvasid
	 *            of the canvas element embedded in the html, used to draw 3d
	 *            graphics.
	 * @param showInfoTextsif
	 *            set to true, this shows loading indicators and error texts. If
	 *            set to false no text is shown and you have to do this
	 *            yourself.
	 * @param fpsframes
	 *            per second to draw. Uses a default of 60 if set to null.
	 * @param showFPSCounterset
	 *            to true to show a frames per second counter
	 * @param loadingScreenTextoptional
	 *            parameter specifying a loadingScreen text. Setting this to a
	 *            text like "Loading" will cause a loading screen with this text
	 *            to appear while the file is being loaded.
	 */

	public static native CopperLicht create(String elementIdOfCanvas, JavaScriptObject showInfoTexts, Number fps, Boolean showFPSCounter, String loadingScreenText) /*-{
		return new $wnd.CL3D.CopperLicht(elementIdOfCanvas, showInfoTexts, fps,
				showFPSCounter, loadingScreenText);
	}-*/;

	public static native CopperLicht create(String elementIdOfCanvas) /*-{
		return new $wnd.CL3D.CopperLicht(elementIdOfCanvas);
	}-*/;

	public static native CopperLicht startCopperLichtFromFile(String elementIdOfCanvas, String path) /*-{
		return new $wnd.startCopperLichtFromFile(elementIdOfCanvas, path);
	}-*/;

	/**
	 * Event handler called after the scene has been completely drawn. You can
	 * use this to draw some additional stuff like 2d overlays or similar. Use
	 * it for example like here:
	 */
	public final native JavaScriptObject getOnAfterDrawAll() /*-{
		return this.OnAfterDrawAll;
	}-*/;

	/**
	 * Event handler called after the scene has been completely drawn. You can
	 * use this to draw some additional stuff like 2d overlays or similar. Use
	 * it for example like here:
	 */
	public final native void setOnAfterDrawAll(JavaScriptObject OnAfterDrawAll) /*-{
		this.OnAfterDrawAll = OnAfterDrawAll;
	}-*/;

	/**
	 * Event handler called before animating the scene. You can use this to
	 * manipulate the 3d scene every frame. An example how to use it looks like
	 * this:
	 */
	public final native JavaScriptObject getOnAnimate() /*-{
		return this.OnAnimate;
	}-*/;

	/**
	 * Event handler called before animating the scene. You can use this to
	 * manipulate the 3d scene every frame. An example how to use it looks like
	 * this:
	 */
	public final native void setOnAnimate(JavaScriptObject OnAnimate) /*-{
		this.OnAnimate = OnAnimate;
	}-*/;

	/**
	 * Event handler called before the scene will be completely drawn. You can
	 * use this to draw some additional stuff like weapons or similar. Use it
	 * for example like here:
	 */
	public final native JavaScriptObject getOnBeforeDrawAll() /*-{
		return this.OnBeforeDrawAll;
	}-*/;

	/**
	 * Event handler called before the scene will be completely drawn. You can
	 * use this to draw some additional stuff like weapons or similar. Use it
	 * for example like here:
	 */
	public final native void setOnBeforeDrawAll(JavaScriptObject OnBeforeDrawAll) /*-{
		this.OnBeforeDrawAll = OnBeforeDrawAll;
	}-*/;

	/**
	 * Event handler called after the scene description file has been loaded
	 * sucessfully (see CopperLicht.load(). Can be used to hide a loading screen
	 * after loading of the file has been finished. Use it for example like
	 * here:
	 */
	public final native void setOnLoadingComplete(JsFunction func) /*-{
		this.OnLoadingComplete = function(){
			func.@com.mostka.cl3d.wraper.JsFunction::execute([Lcom/google/gwt/core/client/JavaScriptObject;)(null);
		}	
	}-*/;

	/**
	 * Event handler called after the scene description file has been loaded
	 * sucessfully (see CopperLicht.load(). Can be used to hide a loading screen
	 * after loading of the file has been finished. Use it for example like
	 * here:
	 */
	public final native void setOnLoadingComplete(JavaScriptObject OnLoadingComplete) /*-{
		this.OnLoadingComplete = OnLoadingComplete;
	}-*/;

	/**
	 * Adds a new $wnd.CL3D.Scene
	 * 
	 * @param scene
	 */
	public final native JavaScriptObject addScene(JavaScriptObject scene) /*-{
		return this.addScene(scene);
	}-*/;

	/**
	 * Draws and animates the 3d scene. To be called if you are using your own
	 * rendering loop, usually this has not to be called at all. This will also
	 * call OnAnimate() before starting to draw anything, and call
	 * OnAfterDrawAll() after everything has been drawn.
	 */
	public final native JavaScriptObject draw3dScene() /*-{
		return this.draw3dScene();
	}-*/;

	/**
	 * Returns the 2D pixel position on the screen from a 3D position. Uses the
	 * current projection and view matrices stored in the renderer, so the 3d
	 * scene should have been rendered at least once before to return a correct
	 * result.
	 * 
	 * @param pos3d
	 *            3d position as Vect3d.
	 */
	public final native JavaScriptObject get2DPositionFrom3DPosition(Vect3d pos3d) /*-{
		return this.get2DPositionFrom3DPosition(pos3d);
	}-*/;

	/**
	 * Returns a 3D point from a 2D pixel coordinate on the screen. Note: A 2D
	 * position on the screen does not represent one single 3D point, but a
	 * actually a 3d line. So in order to get this line, use the 3d point
	 * returned by this function and the position of the current camera to form
	 * this line.
	 * 
	 * @param x
	 *            x coordinate on the canvas. You can use CopperLicht.getMouseX
	 *            for the current mouse cursor position.
	 * @param y
	 *            y coordinate on the canvas. You can use CopperLicht.getMouseY
	 *            for the current mouse cursor position.
	 */
	public final native JavaScriptObject get3DPositionFrom2DPosition(Number x, Number y) /*-{
		return this.get3DPositionFrom2DPosition(x, y);
	}-*/;

	/**
	 * Returns the last X coordinate where the mouse was pressed over the
	 * canvas.
	 */
	public final native JavaScriptObject getMouseDownX() /*-{
		return this.getMouseDownX();
	}-*/;

	/**
	 * Returns the last Y coordinate where the mouse was pressed over the
	 * canvas.
	 */
	public final native JavaScriptObject getMouseDownY() /*-{
		return this.getMouseDownY();
	}-*/;

	/**
	 * Returns the last X coordinate in pixels of the cursor over the canvas,
	 * relative to the canvas.
	 */
	public final native JavaScriptObject getMouseX() /*-{
		return this.getMouseX();
	}-*/;

	/**
	 * Returns the last Y coordinate in pixels of the cursor over the canvas,
	 * relative to the canvas.
	 */
	public final native JavaScriptObject getMouseY() /*-{
		return this.getMouseY();
	}-*/;

	/**
	 * return a reference to the currently used Renderer.
	 */
	public final native Renderer getRenderer() /*-{
		return this.getRenderer();
	}-*/;

	/**
	 * return a reference to the currently active Scene.
	 */
	public final native Scene getScene() /*-{
		return this.getScene();
	}-*/;

	/**
	 * Returns all available scenes. Returns an array containing all Scenes.
	 */
	public final native JavaScriptObject getScenes() /*-{
		return this.getScenes();
	}-*/;

	/**
	 * Returns the TextureManager used to load textures.
	 */
	public final native TextureManager getTextureManager() /*-{
		return this.getTextureManager();
	}-*/;

	/**
	 * Switches the current scene to a new $wnd.CL3D.Scene.
	 * 
	 * @param scene
	 *            The new $wnd.CL3D.Scene to be activated.
	 */
	public final native JavaScriptObject gotoScene(Scene scene) /*-{
		return this.gotoScene(scene);
	}-*/;

	/**
	 * Switches the current scene to a new $wnd.CL3D.Scene by scene name.
	 * 
	 * @param scene
	 *            The name of the new $wnd.CL3D.Scene to be activated.
	 * @param ignorecase
	 *            set to true to ignore the case of the name
	 */
	public final native JavaScriptObject gotoSceneByName(String scene, Boolean ignorecase) /*-{
		return this.gotoSceneByName(scene, ignorecase);
	}-*/;

	/**
	 * When CopperLicht is created, it will register the document.onkeydown
	 * event with this function. If you need to handle it yourself, you should
	 * call this function with the event parameter so that all animators still
	 * work correctly.
	 * 
	 * @param evt
	 */
	public final native boolean handleKeyDown(Object evt) /*-{
		return this.handleKeyDown(evt);
	}-*/;

	/**
	 * Causes a key event to stop propagating if it has been used inside an
	 * animator
	 * 
	 * @param evt
	 * @param usedToDoAction
	 */
	public final native JavaScriptObject handleKeyPropagation(JavaScriptObject evt, JavaScriptObject usedToDoAction) /*-{
		return this.handleKeyPropagation(evt, usedToDoAction);
	}-*/;

	/**
	 * When CopperLicht is created, it will register the document.onkeyup event
	 * with this function. If you need to handle it yourself, you should call
	 * this function with the event parameter so that all animators still work
	 * correctly.
	 * 
	 * @param evt
	 */
	public final native JavaScriptObject handleKeyUp(JavaScriptObject evt) /*-{
		return this.handleKeyUp(evt);
	}-*/;

	/**
	 * When CopperLicht is created, it will register the onmousedown event of
	 * the canvas with this function. If you need to handle it yourself, you
	 * should call this function with the event parameter so that all animators
	 * still work correctly.
	 * 
	 * @param evt
	 */
	public final native JavaScriptObject handleMouseDown(JavaScriptObject evt) /*-{
		return this.handleMouseDown(evt);
	}-*/;

	/**
	 * When CopperLicht is created, it will register the onmousemove event of
	 * the canvas with this function. If you need to handle it yourself, you
	 * should call this function with the event parameter so that all animators
	 * still work correctly.
	 * 
	 * @param evt
	 */
	public final native JavaScriptObject handleMouseMove(JavaScriptObject evt) /*-{
		return this.handleMouseMove(evt);
	}-*/;

	/**
	 * When CopperLicht is created, it will register the onmouseup event of the
	 * canvas with this function. If you need to handle it yourself, you should
	 * call this function with the event parameter so that all animators still
	 * work correctly.
	 * 
	 * @param evt
	 */
	public final native JavaScriptObject handleMouseUp(JavaScriptObject evt) /*-{
		return this.handleMouseUp(evt);
	}-*/;

	/**
	 * @param evt
	 */
	public final native JavaScriptObject handleMouseWheel(JavaScriptObject evt) /*-{
		return this.handleMouseWheel(evt);
	}-*/;

	/**
	 * Initializes the renderer, you need to call this if you create the engine
	 * yourself without using one of the startup functions like
	 * startCopperLichtFromFile.
	 */
	public final native boolean initRenderer() /*-{
		return this.initRenderer();
	}-*/;

	/**
	 * Returns true of CopperLicht is currently loading a scene file
	 * 
	 * @param filecontent
	 * @param filename
	 */
	public final native JavaScriptObject isLoading(JavaScriptObject filecontent, JavaScriptObject filename) /*-{
		return this.isLoading(filecontent, filename);
	}-*/;

	/**
	 * Returns if the mouse is currently pressed over the canvas.
	 */
	public final native JavaScriptObject isMouseDown() /*-{
		return this.isMouseDown();
	}-*/;

	/**
	 * Returns if the mouse is overt the canvas at all
	 */
	public final native JavaScriptObject isMouseOverCanvas() /*-{
		return this.isMouseOverCanvas();
	}-*/;

	/**
	 * Loads a the scene from a CopperCube file and displays it. This will also
	 * initialize the renderer if this has not been done before. You can also
	 * use the event handler CopperLicht.OnLoadingComplete to check if the
	 * loading of the file has completed.
	 * 
	 * @param filetoload
	 *            a filename such as 'test.ccbjs' which will be loaded,
	 *            displayed and animated by the 3d engine. .ccbjs files can be
	 *            created using the
	 */
	public final native JavaScriptObject load(JavaScriptObject filetoload) /*-{
		return this.load(filetoload);
	}-*/;

	/**
	 * @param scene
	 *            The new $wnd.CL3D.Scene to be reloaded.
	 */
	public final native JavaScriptObject reloadScene(Scene scene) /*-{
		return this.reloadScene(scene);
	}-*/;

}
