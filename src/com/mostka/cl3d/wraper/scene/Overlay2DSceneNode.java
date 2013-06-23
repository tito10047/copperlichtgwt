package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.Texture;

public class Overlay2DSceneNode extends SceneNodeAbs {

	protected Overlay2DSceneNode() {
	}

	/**
	 * Scene Node which draws a 2d overlay with color, image and/or text
	 * 
	 * @param engine
	 */

	public static native Overlay2DSceneNode create(JavaScriptObject engine) /*-{
		return new $wnd.CL3D.Overlay2DSceneNode(engine);
	}-*/;

	/**
	 * Font string to be used when drawing text. It uses the following format:
	 * PointSize
	 * ;Family(Default|Decorative|Roman|Script|Swiss|Modern);FaceName(Arial
	 * etc);
	 * Style(Normal|Slant|Italic);Weight(Normal|Light|Bold);Underlined(True|
	 * false) Example: "12;default;arial;normal;bold;true"
	 */
	public final native String getFontName() /*-{
		return this.FontName;
	}-*/;

	/**
	 * Font string to be used when drawing text. It uses the following format:
	 * PointSize
	 * ;Family(Default|Decorative|Roman|Script|Swiss|Modern);FaceName(Arial
	 * etc);
	 * Style(Normal|Slant|Italic);Weight(Normal|Light|Bold);Underlined(True|
	 * false) Example: "12;default;arial;normal;bold;true"
	 */
	public final native void setFontName(String FontName) /*-{
		this.FontName = FontName;
	}-*/;

	/**
	 * Text alignment to be used. Use 0 for left align, 1 for center and 2 for
	 * multiline with word wrap.
	 */
	public final native int getTextAlignment() /*-{
		return this.TextAlignment;
	}-*/;

	/**
	 * Text alignment to be used. Use 0 for left align, 1 for center and 2 for
	 * multiline with word wrap.
	 */
	public final native void setTextAlignment(int TextAlignment) /*-{
		this.TextAlignment = TextAlignment;
	}-*/;

	/**
	 * Text color to be used. Use for example CL3D.createColor(255, 150, 232,
	 * 249); to create a nice color.
	 */
	public final native int getTextColor() /*-{
		return this.TextColor;
	}-*/;

	/**
	 * Text color to be used. Use for example CL3D.createColor(255, 150, 232,
	 * 249); to create a nice color.
	 */
	public final native void setTextColor(int TextColor) /*-{
		this.TextColor = TextColor;
	}-*/;

	/**
	 * Get the axis aligned, not transformed bounding box of this node. This
	 * means that if this node is an animated 3d character, moving in a room,
	 * the bounding box will always be around the origin. To get the box in real
	 * world coordinates, just transform it with the matrix you receive with
	 * getAbsoluteTransformation() or simply use getTransformedBoundingBox(),
	 * which does the same.
	 */
	public final native JavaScriptObject getBoundingBox() /*-{
		return this.getBoundingBox();
	}-*/;

	/**
	 * Returns the type string of the scene node. Returns '2doverlay' for the
	 * scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

	/**
	 * Sets the position of the overlay in pixels
	 * 
	 * @param x
	 *            x position of the overlay in pixels
	 * @param y
	 *            y position of the overlay in pixels
	 * @param width
	 *            width of the overlay in pixels
	 * @param height
	 *            height of the overlay in pixels
	 */
	public final native JavaScriptObject set2DPosition(int x, int y, int width, int height) /*-{
		return this.set2DPosition(x, y, width, height);
	}-*/;

	/**
	 * Sets if the overlay scene node should show a colored background
	 * 
	 * @param showBackground
	 *            true to show the backgroundcolor, false if not
	 * @param color
	 *            a color created with CL3D.createColor defining the color to
	 *            show
	 */
	public final native JavaScriptObject setShowBackgroundColor(Boolean showBackground, int color) /*-{
		return this.setShowBackgroundColor(showBackground, color);
	}-*/;

	/**
	 * Sets if the overlay scene node should show a image
	 * 
	 * @param tex
	 *            a Texture to show as image on the 2d overlay
	 */
	public final native JavaScriptObject setShowImage(Texture tex) /*-{
		return this.setShowImage(tex);
	}-*/;

	/**
	 * Sets the text which should be shown on the overlay 2D node. Note that you
	 * can also set a text color using the .TextColor property and a font using
	 * the FontName property.
	 * 
	 * @param text
	 */
	public final native JavaScriptObject setText(String text) /*-{
			return this.setText(text);
	}-*/;

}