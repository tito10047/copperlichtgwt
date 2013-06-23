package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.Texture;

public class Material extends JavaScriptObject {

	/**
	 * Solid material, constant for using in Material.Type, specifying the type
	 * of the material. Simply a single texture shown as diffuse material.
	 */
	public final static int EMT_SOLID = 0;

	/**
	 * Lightmapped material, constant for using in Material.Type, specifying the
	 * type of the material. There should be 2 textures: The first texture layer
	 * is a diffuse map, the second is a light map. This is the standard
	 * lightmap technique: The lightmap is multiplied onto the first texture.
	 */
	public final static int EMT_LIGHTMAP = 2;
	/**
	 * Reflective material for creating metallic looking survaces, constant for
	 * using in Material.Type, specifying the type of the material. There should
	 * be 2 textures: The first texture layer is a diffuse map, the second is
	 * the refleced surface.
	 */
	public final static int EMT_REFLECTION_2_LAYER = 11;

	/**
	 * Transparent additive material, constant for using in Material.Type,
	 * specifying the type of the material. Only the first texture is used. The
	 * new color is calculated by simply adding the source color and the
	 * destination color. This means if for example a billboard using a texture
	 * with black background and a red circle on it is drawn with this material,
	 * the result is that only the red circle will be drawn a little bit
	 * transparent, and everything which was black is 100% transparent and not
	 * visible.
	 */
	public final static int EMT_TRANSPARENT_ADD_COLOR = 12;
	/**
	 * Transparent material based on the texture alpha channel, constant for
	 * using in Material.Type, specifying the type of the material. The final
	 * color is blended together from the destination color and the texture
	 * color, using the alpha channel value as blend factor. Only first texture
	 * is used
	 */
	public final static int EMT_TRANSPARENT_ALPHA_CHANNEL = 13;

	/**
	 * Transparent reflective material for creating metallic looking survaces,
	 * constant for using in Material.Type, specifying the type of the material.
	 * There should be 2 textures: The first texture layer is a diffuse map
	 * including an alpha channel for transparency, the second is the refleced
	 * surface.
	 */
	public final static int EMT_TRANSPARENT_REFLECTION_2_LAYER = 16;
	
	protected Material() {
	}

	/**
	 * Material description, usually for a MeshBuffer.
	 */

	public static native Material create() /*-{
		return new $wnd.CL3D.Material();
	}-*/;

	/**
	 * Specifies if backface culling is enabled for the material. Default is
	 * true.
	 */
	public final native Boolean getBackfaceCulling() /*-{
		return this.BackfaceCulling;
	}-*/;

	/**
	 * Specifies if backface culling is enabled for the material. Default is
	 * true.
	 */
	public final native void setBackfaceCulling(Boolean BackfaceCulling) /*-{
		this.BackfaceCulling = BackfaceCulling;
	}-*/;

	/**
	 * Specifies if the texture wrapping is enabled or not for Texture 1. In
	 * OpenGL terms, this simply sets TEXTURE_WRAP to REPEAT or CLAMP_TO_EDGE
	 */
	public final native Boolean getClampTexture1() /*-{
		return this.ClampTexture1;
	}-*/;

	/**
	 * Specifies if the texture wrapping is enabled or not for Texture 1. In
	 * OpenGL terms, this simply sets TEXTURE_WRAP to REPEAT or CLAMP_TO_EDGE
	 */
	public final native void setClampTexture1(Boolean ClampTexture1) /*-{
		this.ClampTexture1 = ClampTexture1;
	}-*/;
	
	/**
	 * Specifies if lighting is enabled for the material. Default is false.
	 */
	public final native Boolean getLighting() /*-{
		return this.Lighting;
	}-*/;

	/**
	 * Specifies if lighting is enabled for the material. Default is false.
	 */
	public final native void setLighting(Boolean Lighting) /*-{
		this.Lighting = Lighting;
	}-*/;

	/**
	 * Texture 1 of this material of type Texture.
	 */
	public final native Texture getTex1() /*-{
		return this.Tex1;
	}-*/;

	/**
	 * Texture 1 of this material of type Texture.
	 */
	public final native void setTex1(Texture Tex1) /*-{
		this.Tex1 = Tex1;
	}-*/;

	/**
	 * Texture 2 of this material of type Texture.
	 */
	public final native Texture getTex2() /*-{
		return this.Tex2;
	}-*/;

	/**
	 * Texture 2 of this material of type Texture.
	 */
	public final native void setTex2(Texture Tex2) /*-{
		this.Tex2 = Tex2;
	}-*/;

	/**
	 * Type of the material. Default value is Material.EMT_SOLID. You can set
	 * any value of the predefined materials to this type, or even create your
	 * own material types using Renderer.createMaterialType.
	 */
	public final native int getType() /*-{
		return this.Type;
	}-*/;

	/**
	 * Type of the material. Default value is Material.EMT_SOLID. You can set
	 * any value of the predefined materials to this type, or even create your
	 * own material types using Renderer.createMaterialType.
	 */
	public final native void setType(int Type) /*-{
		this.Type = Type;
	}-*/;

	/**
	 * Specifies if the material is allowed to read from the ZBuffer (DepthTest)
	 */
	public final native Boolean getZReadEnabled() /*-{
		return this.ZReadEnabled;
	}-*/;

	/**
	 * Specifies if the material is allowed to read from the ZBuffer (DepthTest)
	 */
	public final native void setZReadEnabled(Boolean ZReadEnabled) /*-{
		this.ZReadEnabled = ZReadEnabled;
	}-*/;

	/**
	 * Specifies if the material is allowed to write into the ZBuffer
	 */
	public final native Boolean getZWriteEnabled() /*-{
		return this.ZWriteEnabled;
	}-*/;

	/**
	 * Specifies if the material is allowed to write into the ZBuffer
	 */
	public final native void setZWriteEnabled(Boolean ZWriteEnabled) /*-{
		this.ZWriteEnabled = ZWriteEnabled;
	}-*/;

	/**
	 */
	public final native JavaScriptObject clone() /*-{
		return this.clone();
	}-*/;

	/**
	 * Returns true if the described material is transparent, used by SceneNodes
	 * to check if they need to register for rendering in transparent or solid
	 * mode.
	 */
	public final native JavaScriptObject isTransparent() /*-{
		return this.isTransparent();
	}-*/;

	/**
	 * @param mat
	 */
	public final native JavaScriptObject setFrom(JavaScriptObject mat) /*-{
		return this.setFrom(mat);
	}-*/;

}
