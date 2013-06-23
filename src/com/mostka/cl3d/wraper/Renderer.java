package com.mostka.cl3d.wraper;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Material;
import com.mostka.cl3d.wraper.util.Matrix4;
import com.mostka.cl3d.wraper.util.Mesh;
import com.mostka.cl3d.wraper.util.MeshBuffer;

public class Renderer extends JavaScriptObject {

	protected Renderer() {
	}

	/**
	 * 3D renderer, interface for drawing 3d geometry. You can access this using
	 * CopperLicht.getRenderer().
	 */

	public static native Renderer create() /*-{
		return new $wnd.CL3D.Renderer();
	}-*/;

	/**
	 * Event handler called after the renderer switches to a specific material,
	 * useful for shader programming. You can use this to set the variables and
	 * uniforms in a custom shader by using this callback. The first parameter
	 * of the function is the material type id, which gets returned for example
	 * by createMaterialType().
	 */
	public final native JavaScriptObject getOnChangeMaterial() /*-{
		return this.OnChangeMaterial;
	}-*/;

	/**
	 * Event handler called after the renderer switches to a specific material,
	 * useful for shader programming. You can use this to set the variables and
	 * uniforms in a custom shader by using this callback. The first parameter
	 * of the function is the material type id, which gets returned for example
	 * by createMaterialType().
	 */
	public final native void setOnChangeMaterial(JavaScriptObject OnChangeMaterial) /*-{
		this.OnChangeMaterial = OnChangeMaterial;
	}-*/;

	/**
	 * Adds a new dynamic light to the rendering pipeline.
	 * 
	 * @param l
	 *            light data of the light to add
	 */
	public final native JavaScriptObject addDynamicLight(Light l) /*-{
		return this.addDynamicLight(l);
	}-*/;

	/**
	 * Starts the drawing process by clearing the whole scene. Is called by
	 * CopperLicht.draw3dScene(), so it shouldn't be necessary to call this
	 * yourself.
	 * 
	 * @param clearColor
	 *            Color for the background. See
	 */
	public final native JavaScriptObject beginScene(int clearColor) /*-{
		return this.beginScene(clearColor);
	}-*/;

	/**
	 * Clears all dynamic lights in the rendering pipeline. Is called by
	 * CopperLicht.draw3dScene(), so it shouldn't be necessary to call this
	 * yourself.
	 */
	public final native JavaScriptObject clearDynamicLights() /*-{
		return this.clearDynamicLights();
	}-*/;

	/**
	 * Creates a new $wnd.CL3D.Material type with custom shaders. Returns an id which
	 * can be used in Material.Type. There is a tutorial showing how to create a
	 * new $wnd.CL3D.Material in the documentation, but also this short example may
	 * give an overview:
	 */
	public final native JavaScriptObject createMaterialType() /*-{
		return this.createMaterialType();
	}-*/;
	public final native int createMaterialType(String vertex_shader_source,String fragment_shader_source) /*-{
		return this.createMaterialType(vertex_shader_source, fragment_shader_source);
	}-*/;

	/**
	 * Creates a Texture from a 2d canvas
	 * 
	 * @param canvas
	 *            a 2d canvas to be converted into a texture
	 * @param nonscaling
	 *            optional parameter, if set to true, and the texture don't have
	 *            a power-of-two size, the texture will not be scaled up, but
	 *            copied without scaling. This is useful for font or 2D
	 *            textures, for example, to make them less blurry.
	 */
	public final native JavaScriptObject createTextureFrom2DCanvas(Canvas canvas, Boolean nonscaling) /*-{
		return this.createTextureFrom2DCanvas(canvas, nonscaling);
	}-*/;

	/**
	 * Deletes a Texture, freeing a lot of memory
	 * 
	 * @param tex
	 *            the texture to draw
	 */
	public final native JavaScriptObject deleteTexture(Texture tex) /*-{
		return this.deleteTexture(tex);
	}-*/;

	/**
	 * @param x
	 *            x coordinate in pixels
	 * @param y
	 *            y coordinate in pixels
	 * @param width
	 *            width of the rectangle in pixels
	 * @param height
	 *            height of the rectangle in pixels
	 * @param tex
	 *            texture to draw
	 * @param blend
	 *            (optional) set to true to enable alpha blending (using the
	 *            alpha component of the color) and false not to blend
	 * @param shaderToUse
	 *            (optional) shader to be used or null if the default shader
	 *            should be used. Set this to something returned by
	 *            getGLProgramFromMaterialType() for example.
	 * @param srcRightX
	 * @param srcBottomY
	 */
	public final native JavaScriptObject draw2DImage(int x, int y, int width, int height, Texture tex, Boolean blend, JavaScriptObject shaderToUse,
			JavaScriptObject srcRightX, JavaScriptObject srcBottomY) /*-{
		return this.draw2DImage(x, y, width, height, tex, blend, shaderToUse,
				srcRightX, srcBottomY);
	}-*/;

	/**
	 * @param x
	 *            x coordinate in pixels
	 * @param y
	 *            y coordinate in pixels
	 * @param width
	 *            width of the rectangle in pixels
	 * @param height
	 *            height of the rectangle in pixels
	 * @param color
	 *            color of the rectangle. See CL3D.createColor()
	 * @param blend
	 *            (optional) set to true to enable alpha blending (using the
	 *            alpha component of the color) and false not to blend
	 */
	public final native JavaScriptObject draw2DRectangle(int x, int y, int width, int height, int color, Boolean blend) /*-{
		return this.draw2DRectangle(x, y, width, height, color, blend);
	}-*/;

	/**
	 * Draws a Mesh with the current world, view and projection matrix.
	 * 
	 * @param mesh
	 *            the mesh to draw
	 */
	public final native JavaScriptObject drawMesh(Mesh mesh) /*-{
		return this.drawMesh(mesh);
	}-*/;

	/**
	 * Draws a mesh buffer. Note, you might want to set the material of the mesh
	 * buffer before drawing it, use setMaterial() to do this before calling
	 * this function.
	 * 
	 * @param buf
	 *            the mesh buffer to draw.
	 * @param indexCountToUse
	 */
	public final native JavaScriptObject drawMeshBuffer(MeshBuffer buf, JavaScriptObject indexCountToUse) /*-{
		return this.drawMeshBuffer(buf, indexCountToUse);
	}-*/;

	/**
	 * Ends the drawing process by flushing the renderin instructions. Is called
	 * by CopperLicht.draw3dScene(), so it shouldn't be necessary to call this
	 * yourself.
	 */
	public final native JavaScriptObject endScene() /*-{
		return this.endScene();
	}-*/;

	/**
	 * Returns the webgl shader program from a material type. This is useful
	 * when you are using createMaterialType to create your own shaders and need
	 * to set material constants using for example uniform1i.
	 * 
	 * @param mattype
	 *            The material type, like for example Material.EMT_SOLID, or
	 *            your own material type returned by createMaterialType.
	 */
	public final native JavaScriptObject getGLProgramFromMaterialType(int mattype) /*-{
		return this.getGLProgramFromMaterialType(mattype);
	}-*/;

	/**
	 * Returns the current height of the rendering surface in pixels.
	 */
	public final native int getHeight() /*-{
		return this.getHeight();
	}-*/;

	/**
	 * Returns the currently used projection matrix.
	 */
	public final native JavaScriptObject getProjection() /*-{
		return this.getProjection();
	}-*/;

	/**
	 * Returns the currently used view matrix.
	 */
	public final native JavaScriptObject getView() /*-{
		return this.getView();
	}-*/;

	/**
	 * Returns access to the webgl interface. This should not be needed.
	 */
	public final native JavaScriptObject getWebGL() /*-{
		return this.getWebGL();
	}-*/;

	/**
	 * Returns the current width of the rendering surface in pixels.
	 */
	public final native int getWidth() /*-{
		return this.getWidth();
	}-*/;

	/**
	 * Returns the currently used view matrix.
	 */
	public final native JavaScriptObject getWorld() /*-{
		return this.getWorld();
	}-*/;

	/**
	 * Sets a material to activate for drawing 3d graphics. All 3d drawing
	 * functions will draw geometry using this material thereafter.
	 * 
	 * @param mat
	 *            Material to set
	 */
	public final native JavaScriptObject setMaterial(Material mat) /*-{
		return this.setMaterial(mat);
	}-*/;

	/**
	 * Sets the projection transformation matrix. This is automatically called
	 * by CopperLicht.draw3dScene(), so it shouldn't be necessary to call this
	 * yourself.
	 * 
	 * @param m
	 *            matrix representing the transformation matrix.
	 */
	public final native JavaScriptObject setProjection(Matrix4 m) /*-{
		return this.setProjection(m);
	}-*/;

	/**
	 * Sets the view transformation matrix. This is automatically called by
	 * CopperLicht.draw3dScene(), so it shouldn't be necessary to call this
	 * yourself.
	 * 
	 * @param m
	 *            matrix representing the transformation matrix.
	 */
	public final native JavaScriptObject setView(Matrix4 m) /*-{
			return this.setView(m);
	}-*/;

	/**
	 * Sets the world transformation matrix. This is automatically called by
	 * CopperLicht.draw3dScene(), so it shouldn't be necessary to call this
	 * yourself.
	 * 
	 * @param m
	 *            matrix representing the transformation matrix.
	 */
	public final native JavaScriptObject setWorld(Matrix4 m) /*-{
			return this.setWorld(m);
	}-*/;

}