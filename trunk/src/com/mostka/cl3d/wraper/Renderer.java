package com.mostka.cl3d.wraper;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Material;
import com.mostka.cl3d.wraper.util.Matrix4;
import com.mostka.cl3d.wraper.util.Mesh;
import com.mostka.cl3d.wraper.util.MeshBuffer;
import com.mostka.cl3d.wraper.webgl.ContextWebGL;
import com.mostka.cl3d.wraper.webgl.WebGLBuffer;
import com.mostka.cl3d.wraper.webgl.WebGLFloatArray;
import com.mostka.cl3d.wraper.webgl.WebGLProgram;
import com.mostka.cl3d.wraper.webgl.WebGLUnsignedShortArray;

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
	public final native void postInitWebGl() /*-{
		
		var vs_shader_3ddrawing_coloronly =  ""+
			"#ifdef GL_ES								\n"+
			"precision highp float;						\n"+
			"#endif										\n"+
			"uniform mat4 worldviewproj;				"+
			"attribute vec4 vPosition;					"+
			"attribute vec4 vNormal;					"+
			"void main()								"+
			"{											"+
			"	gl_Position = worldviewproj * vPosition;"+
			"}";
		
		
		this.Program3DDrawingColorOnly = this.createMaterialTypeInternal(vs_shader_3ddrawing_coloronly, this.fs_shader_simplecolor);
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
	
	public final native JavaScriptObject updateRendererNativeArray(MeshBuffer buff) /*-{
		return this.updateRendererNativeArray(buff);
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
	public final native JavaScriptObject createTextureFrom2DCanvas(Canvas canvas, boolean nonscaling) /*-{
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
	public final native JavaScriptObject draw2DImage(int x, int y, int width, int height, Texture tex, boolean blend, JavaScriptObject shaderToUse,
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
	public final native JavaScriptObject draw2DRectangle(int x, int y, int width, int height, int color, boolean blend) /*-{
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
	public final native JavaScriptObject drawMeshBuffer(MeshBuffer buf, int indexCountToUse) /*-{
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
	public final native ContextWebGL getWebGL() /*-{
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
	protected final native WebGLProgram  getProgram2DDrawingColorOnly() /*-{
			return this.Program2DDrawingColorOnly;
	}-*/;
	protected final native WebGLProgram  getProgram3DDrawingColorOnly() /*-{
			return this.Program3DDrawingColorOnly;
	}-*/;
	protected final native WebGLProgram  setCurrentGLProgram(WebGLProgram program) /*-{
			return this.currentGLProgram = program;
	}-*/;
	
	public final void draw2DLine(double x1,double  y1,double  x2,double  y2,int  color,boolean blend){
			 
	    if (this.getWidth() == 0 || this.getHeight() == 0) {
	        return;
	    }
	    boolean m = true;
	    if ( blend == false) {
	        m = false;
	    }
	 
	    ContextWebGL gl = this.getWebGL();
	    /*gl.enableVertexAttribArray(0);
	    gl.disableVertexAttribArray(1);
	    gl.disableVertexAttribArray(2);
	    gl.disableVertexAttribArray(3);
	    gl.disableVertexAttribArray(4);*/
	    y1 = (double) this.getHeight() - y1;
	    y2 = (double) this.getHeight() - y2;
	    double n = 2 / (double) this.getWidth();
	    double l = 2 / (double) this.getHeight();
	    x1 = (x1 * n) - 1;
	    y1 = (y1 * l) - 1;
	    x2 = (x2 * n) - 1;
	    y2 = (y2 * l) - 1;
	       
	    WebGLFloatArray g = WebGLFloatArray.create( 6 );
	    WebGLUnsignedShortArray k = WebGLUnsignedShortArray.create(2);
	    int i = 2;
	   
	    g.set(0, x1);
	    g.set(1, y1);
	    g.set(2, 0);
	    g.set(3, x2);
	    g.set(4, y2);
	    g.set(5, 0);
	    k.set(0 ,0);
	    k.set(1 ,1);
	               
	    WebGLBuffer f = gl.createBuffer();
	    gl.bindBuffer(ContextWebGL.ARRAY_BUFFER, f);
	    gl.bufferData(ContextWebGL.ARRAY_BUFFER, g, ContextWebGL.STATIC_DRAW);
	    gl.vertexAttribPointer(0, 3, ContextWebGL.FLOAT, false, 0, 0);
	    WebGLBuffer c = gl.createBuffer();
	    gl.bindBuffer(ContextWebGL.ELEMENT_ARRAY_BUFFER, c);
	    gl.bufferData(ContextWebGL.ELEMENT_ARRAY_BUFFER, k, ContextWebGL.STATIC_DRAW);
	    WebGLProgram program = this.getProgram2DDrawingColorOnly();
	    this.setCurrentGLProgram( program );
	    gl.useProgram(program);
	    gl.uniform4f(gl.getUniformLocation(program, "vColor"), CL3D.getRed(color) / 255, CL3D.getGreen(color) / 255, CL3D.getBlue(color) / 255, m ? (CL3D.getAlpha(color) / 255) : 1);
	    gl.depthMask(false);
	    gl.disable(ContextWebGL.DEPTH_TEST);
	    if (!m) {
	        gl.disable(ContextWebGL.BLEND);
	    } else {
	        gl.enable(ContextWebGL.BLEND);
	        gl.blendFunc(ContextWebGL.SRC_ALPHA, ContextWebGL.ONE_MINUS_SRC_ALPHA);
	    }
	    gl.drawElements(ContextWebGL.LINES, i, ContextWebGL.UNSIGNED_SHORT, 0);
	    gl.deleteBuffer(f);
	    gl.deleteBuffer(c);
	}

	public final void draw3DLine(int x1, int y1, int z1, int x2, int y2, int z2, int color, boolean blend) {
		if (this.getWidth() == 0 || this.getHeight() == 0) {
	        return;
	    }
	    boolean m = true;
	    if ( blend == false) {
	        m = false;
	    }
	 
	    ContextWebGL gl = this.getWebGL();
	    gl.enableVertexAttribArray(0);
	    gl.disableVertexAttribArray(1);
	    gl.disableVertexAttribArray(2);
	    gl.disableVertexAttribArray(3);
	    gl.disableVertexAttribArray(4);
	    
	    WebGLFloatArray g = WebGLFloatArray.create( 6 );
	    WebGLUnsignedShortArray k = WebGLUnsignedShortArray.create(2);
	    int i = 2;
	   
	    g.set(0, x1);
	    g.set(1, y1);
	    g.set(2, z1);
	    g.set(3, x2);
	    g.set(4, y2);
	    g.set(5, z2);
	    k.set(0 ,0);
	    k.set(1 ,1);
	    
	    WebGLBuffer f = gl.createBuffer();
	    gl.bindBuffer(ContextWebGL.ARRAY_BUFFER, f);
	    gl.bufferData(ContextWebGL.ARRAY_BUFFER, g, ContextWebGL.STATIC_DRAW);
	    gl.vertexAttribPointer(0, 3, ContextWebGL.FLOAT, false, 0, 0);
	    WebGLBuffer c = gl.createBuffer();
	    gl.bindBuffer(ContextWebGL.ELEMENT_ARRAY_BUFFER, c);
	    gl.bufferData(ContextWebGL.ELEMENT_ARRAY_BUFFER, k, ContextWebGL.STATIC_DRAW);
	    gl.vertexAttribPointer(0, 3, ContextWebGL.FLOAT, false, 0, 0);
	     WebGLProgram program = this.getProgram3DDrawingColorOnly();
	    this.setCurrentGLProgram( program );
	    gl.useProgram(program);
	    gl.uniform4f(gl.getUniformLocation(program, "vColor"), CL3D.getRed(color) / 255, CL3D.getGreen(color) / 255, CL3D.getBlue(color) / 255, m ? (CL3D.getAlpha(color) / 255) : 1);
	    gl.depthMask(false);
	    gl.disable(ContextWebGL.DEPTH_TEST);
	    if (!m) {
	        gl.disable(ContextWebGL.BLEND);
	    } else {
	        gl.enable(ContextWebGL.BLEND);
	        gl.blendFunc(ContextWebGL.SRC_ALPHA, ContextWebGL.ONE_MINUS_SRC_ALPHA);
	    }
	    gl.drawElements(ContextWebGL.LINES, i, ContextWebGL.UNSIGNED_SHORT, 0);
	    gl.deleteBuffer(f);
	    gl.deleteBuffer(c);
	}
	
}