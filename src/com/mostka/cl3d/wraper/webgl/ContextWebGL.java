package com.mostka.cl3d.wraper.webgl;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.VideoElement;
/**
 * https://www.khronos.org/registry/webgl/specs/1.0/#2.1
 */
public class ContextWebGL extends JavaScriptObject implements Context{

	public static final String CONTEXT_ID = "webgl"; 
	public static final String CONTEXT_ID_EXPERIMNTAL = "xperimental-webgl";
	
	public static double TEXTURE_2D = 0x0DE1;
	public static double RGBA = 0x1908;
	public static double UNSIGNED_BYTE = 0x1401;
	public static double TEXTURE_MAG_FILTER = 0x2800;
	public static double TEXTURE_MIN_FILTER = 0x2801;
	public static double LINEAR = 0x2601;
	public static double TEXTURE_WRAP_S = 0x2802;
	public static double TEXTURE_WRAP_T = 0x2803;
	public static double CLAMP_TO_EDGE = 0x812F;
	public static double ARRAY_BUFFER = 0x8892;
	public static double STATIC_DRAW = 0x88E4;
	public static double FLOAT = 0x1406;
	public static double ELEMENT_ARRAY_BUFFER = 0x8893;
	public static double DEPTH_TEST = 0x0B71;
	public static double BLEND = 0x0BE2;
	public static double SRC_ALPHA = 0x0302;
	public static double ONE_MINUS_SRC_ALPHA = 0x0303;
	public static double LINES = 0x0001;
	public static double UNSIGNED_SHORT = 0x1403;
	
	protected ContextWebGL(){}
	
	public static ContextWebGL create(Canvas canvas){
		ContextWebGL gl = (ContextWebGL) canvas.getContext(ContextWebGL.CONTEXT_ID);
		if (gl==null){
			gl=(ContextWebGL) canvas.getContext(ContextWebGL.CONTEXT_ID_EXPERIMNTAL);
		}
		return gl;
	} 
	
	public final native void bindTexture(double target, WebGlTexture texture) /*-{
		this.bindTexture(target, texture);
	}-*/;
	
	public final native void texImage2D(double target, double level, double internalformat, double format, double type, VideoElement texture) /*-{
		this.texImage2D(target, level, internalformat, format, type, texture);
	}-*/;
	
	public final native void texParameteri(double target, double pname, double param) /*-{
		this.texParameteri(target, pname, param);
	}-*/;
	
	public final native void enableVertexAttribArray(double index) /*-{
		this.enableVertexAttribArray(index);
	}-*/;
	
	public final native void disableVertexAttribArray(double index) /*-{
		this.disableVertexAttribArray(index);
	}-*/;

	public final native WebGLBuffer createBuffer() /*-{
		return this.createBuffer();
	}-*/;

	public final native void bindBuffer(double target, WebGLBuffer buffer) /*-{
		this.bindBuffer(target, buffer);
	}-*/;

	public final native void bufferData(double target, WebGLFloatArray data, double usage)/*-{
		this.bufferData(target, data, usage);
	}-*/;

	public final native void bufferData(double target, WebGLUnsignedShortArray data, double usage)/*-{
		this.bufferData(target, data, usage);
	}-*/;

	public final native void vertexAttribPointer(int indx, int size, double type, boolean normalized, int stride, int offset)/*-{
		this.vertexAttribPointer(indx, size, type, normalized, stride, offset);
	}-*/;

	public final native void useProgram(WebGLProgram program)/*-{
		this.useProgram(program);
	}-*/;

	public final native  WebGLUniformLocation getUniformLocation(WebGLProgram program, String name)/*-{
		this.getUniformLocation(program, name);
	}-*/;

	public final native void uniform4f(WebGLUniformLocation location, int x, int y, int z, int w)/*-{
		this.uniform4f(location, x, y, z, w);
	}-*/;

	public final native void depthMask(boolean flag)/*-{
		this.depthMask(flag);
	}-*/;

	public final native void disable(double cap)/*-{
		this.disable(cap);
	}-*/;

	public final native void enable(double cap)/*-{
		this.enable(cap);
	}-*/;

	public final native void blendFunc(double sfactor, double dfactor)/*-{
		this.blendFunc(sfactor, dfactor);
	}-*/;

	public final native void drawElements(double mode, int count, double type, int offset)/*-{
		this.drawElements(mode, count, type, offset);
	}-*/;

	public final native void deleteBuffer(WebGLBuffer buffer)/*-{
		this.deleteBuffer(buffer)
	}-*/;
	

	
	
}
