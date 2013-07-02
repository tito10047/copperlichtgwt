package com.mostka.cl3d.wraper.webgl;

import com.google.gwt.core.client.JavaScriptObject;

public class WebGLBuffer extends JavaScriptObject {

	protected WebGLBuffer(){}
	
	public static native WebGLBuffer create() /*-{
		return new WebGLBuffer();
	}-*/;
}
