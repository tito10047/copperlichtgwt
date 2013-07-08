package com.mostka.cl3d.wraper;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.webgl.WebGlTexture;

public class Texture extends JavaScriptObject {

	protected Texture() {
	}

	/**
	 * Class representing a texture which can be loaded from an URL.
	 */

	public static native Texture create() /*-{
		return new $wnd.CL3D.Texture();
	}-*/;

	/**
	 * returns the height of this texture, or null if not loaded yet
	 */
	public final native JavaScriptObject getHeight() /*-{
		return this.getHeight();
	}-*/;

	/**
	 * returns the image of the texture
	 */
	public final native JavaScriptObject getImage() /*-{
		return this.getImage();
	}-*/;

	/**
	 * returns the URL of this texture
	 */
	public final native JavaScriptObject getURL() /*-{
		return this.getURL();
	}-*/;

	/**
	 * returns the webGL texture object of the texture, only available if the
	 * texture has been loaded already.
	 */
	public final native WebGlTexture getWebGLTexture() /*-{
		return this.getWebGLTexture();
	}-*/;

	/**
	 * returns the width of this texture, or null if not loaded yet
	 */
	public final native JavaScriptObject getWidth() /*-{
		return this.getWidth();
	}-*/;

	/**
	 * returns if the texture has been sucessfully loaded
	 */
	public final native JavaScriptObject isLoaded() /*-{
		return this.isLoaded();
	}-*/;

}