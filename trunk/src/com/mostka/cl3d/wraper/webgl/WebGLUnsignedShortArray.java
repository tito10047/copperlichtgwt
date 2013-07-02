package com.mostka.cl3d.wraper.webgl;

import com.google.gwt.core.client.JavaScriptObject;

public class WebGLUnsignedShortArray extends JavaScriptObject {

	protected WebGLUnsignedShortArray(){}
	
	public static native WebGLUnsignedShortArray create(int size) /*-{
		return new $wnd.WebGLUnsignedShortArray( size );
	}-*/;
	
	public final native double get(int pos) /*-{
		return this[pos];
	}-*/;
	
	public final native void set(int pos,double value) /*-{
		this[pos]=value;
	}-*/;
	
}
