package com.mostka.cl3d.wraper.util;

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
	
}
