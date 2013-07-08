package com.mostka.cl3d.wraper;

import com.google.gwt.core.client.JavaScriptObject;

public class TextureManager extends JavaScriptObject {

	protected TextureManager() {
	}

	/**
	 * texture manager containing all Textures and able to load new ones,
	 * accessible via CopperLicht.getTextureManager().
	 */

	public static native TextureManager create() /*-{
		return new $wnd.CL3D.TextureManager();
	}-*/;

	/**
	 * Returns the amount of textures which still need to be loaded
	 */
	public final native JavaScriptObject getCountOfTexturesToLoad() /*-{
		return this.getCountOfTexturesToLoad();
	}-*/;

	/**
	 * Returns a new $wnd.CL3D.Texture object from an URL and starts loading it. If
	 * the texture has been already loaded, it doesn't load it a second time but
	 * returns the reference to the old texture.
	 * 
	 * @param url
	 *            Url of the image. Can be relative like
	 *            'path/to/image/mytexture.jpg' or absolute like
	 *            'http://www.ambiera.com/images/ambiera_logo_big.png'
	 * @param createIfNotFound
	 *            set to true to create a new $wnd.CL3D.Texture object and start
	 *            loading it if an existing once wasn't found with this url.
	 */
	public final native Texture getTexture(String url, boolean createIfNotFound) /*-{
		return this.getTexture(url, createIfNotFound);
	}-*/;

	/**
	 * Returns the amount of textures
	 */
	public final native JavaScriptObject getTextureCount() /*-{
			return this.getTextureCount();
	}-*/;

}