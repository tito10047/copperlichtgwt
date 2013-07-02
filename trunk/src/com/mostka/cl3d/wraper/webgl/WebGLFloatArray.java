package com.mostka.cl3d.wraper.webgl;

import com.google.gwt.core.client.JavaScriptObject;

public class WebGLFloatArray extends JavaScriptObject {

	protected WebGLFloatArray(){}
	
	public static native WebGLFloatArray create(int size) /*-{
		return new $wnd.WebGLFloatArray( size );
	}-*/;
	
	public final native double get(int pos) /*-{
		return this[pos];
	}-*/;
	
	public final native void set(int pos,double value) /*-{
		this[pos]=value;
	}-*/;
	
}
