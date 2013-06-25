package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.Renderer;
import com.mostka.cl3d.wraper.animator.AnimatorAbs;
import com.mostka.cl3d.wraper.selector.TriangleSelector;
import com.mostka.cl3d.wraper.selector.TriangleSelectorInt;
import com.mostka.cl3d.wraper.util.Material;
import com.mostka.cl3d.wraper.util.Matrix4;
import com.mostka.cl3d.wraper.util.Vect3d;

public abstract class SceneNodeAbs extends JavaScriptObject/* implements SceneNodeAbsInt*/{

	protected SceneNodeAbs() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Defines the id of the scene node, completely freely usable by the user.
	 */
	public final native int getId() /*-{
		return this.Id;
	}-*/;

	/**
	 * Defines the id of the scene node, completely freely usable by the user.
	 */
	public final native void setId(int Id) /*-{
		this.Id = Id;
	}-*/;

	/**
	 * Defines the name of the scene node, completely freely usable by the user.
	 */
	public final native String getName() /*-{
		return this.Name;
	}-*/;

	/**
	 * Defines the name of the scene node, completely freely usable by the user.
	 */
	public final native void setName(String Name) /*-{
		this.Name = Name;
	}-*/;

	/**
	 * Position of the scene node, relative to its parent. If you want the
	 * position in world coordinates, use getAbsolutePosition(). If you change
	 * this value, be sure to call updateAbsolutePosition() afterwards to make
	 * the change be reflected immediately.
	 */
	public final native Vect3d getPos() /*-{
		return this.Pos;
	}-*/;
	
	public final native void setPos(double x, double y) /*-{
		this.Pos.X = x;
		this.Pos.Y = y;
	}-*/;
	public final native void setPosAdd(double x, double y) /*-{
		this.Pos.X += x;
		this.Pos.Y += y;
	}-*/;
	public final native void setPos(double x, double y, double z) /*-{
		this.Pos.X = x;
		this.Pos.Y = y;
		this.Pos.Z = z;
	}-*/;
	public final native void setPosAdd(double x, double y, double z) /*-{
		this.Pos.X += x;
		this.Pos.Y += y;
		this.Pos.Z += z;
	}-*/;
	public final native void setPosY(double y) /*-{
		this.Pos.Y = y;
	}-*/;
	public final native int getPosY() /*-{
		return this.Pos.Y;
	}-*/;

	/**
	 * Position of the scene node, relative to its parent. If you want the
	 * position in world coordinates, use getAbsolutePosition(). If you change
	 * this value, be sure to call updateAbsolutePosition() afterwards to make
	 * the change be reflected immediately.
	 */
	public final native void setPos(Vect3d Pos) /*-{
		this.Pos = Pos;
	}-*/;

	/**
	 * Rotation of the scene node, relative to its parent, in degrees. Note that
	 * this is the relative rotation of the node. If you want the absolute
	 * rotation, use getAbsoluteTransformation().getRotation() If you change
	 * this value, be sure to call updateAbsolutePosition() afterwards to make
	 * the change be reflected immediately.
	 */
	public final native Vect3d getRot() /*-{
		return this.Rot;
	}-*/;

	/**
	 * Rotation of the scene node, relative to its parent, in degrees. Note that
	 * this is the relative rotation of the node. If you want the absolute
	 * rotation, use getAbsoluteTransformation().getRotation() If you change
	 * this value, be sure to call updateAbsolutePosition() afterwards to make
	 * the change be reflected immediately.
	 */
	public final native void setRot(Vect3d Rot) /*-{
		this.Rot = Rot;
	}-*/;

	/**
	 * Scale of the scene node, relative to its parent, in degrees. Default is
	 * (1,1,1) This is the scale of this node relative to its parent. If you
	 * want the absolute scale, use getAbsoluteTransformation().getScale() If
	 * you change this value, be sure to call updateAbsolutePosition()
	 * afterwards to make the change be reflected immediately.
	 */
	public final native Vect3d getScale() /*-{
		return this.Scale;
	}-*/;

	/**
	 * Scale of the scene node, relative to its parent, in degrees. Default is
	 * (1,1,1) This is the scale of this node relative to its parent. If you
	 * want the absolute scale, use getAbsoluteTransformation().getScale() If
	 * you change this value, be sure to call updateAbsolutePosition()
	 * afterwards to make the change be reflected immediately.
	 */
	public final native void setScale(Vect3d Scale) /*-{
		this.Scale = Scale;
	}-*/;

	/**
	 * An optional TriangleSelector, giving access to the collision geometry of
	 * this scene node.
	 */
	public final native TriangleSelectorInt getSelector() /*-{
		return this.Selector;
	}-*/;

	/**
	 * An optional TriangleSelector, giving access to the collision geometry of
	 * this scene node.
	 */
	public final native void setSelector(TriangleSelectorInt Selector) /*-{
		this.Selector = Selector;
	}-*/;

	/**
	 * Defines whether the node should be visible (if all of its parents are
	 * visible). This is only an option set by the user, but has nothing to do
	 * with geometry culling.
	 */
	public final native Boolean getVisible() /*-{
		return this.Visible;
	}-*/;

	/**
	 * Defines whether the node should be visible (if all of its parents are
	 * visible). This is only an option set by the user, but has nothing to do
	 * with geometry culling.
	 */
	public final native void setVisible(Boolean Visible) /*-{
		this.Visible = Visible;
	}-*/;

	/**
	 * Adds a scene node animator to the list of animators manipulating this
	 * scene node.
	 * 
	 * @param a
	 *            the new $wnd.CL3D.Animator to add.
	 */
	public final native JavaScriptObject addAnimator(AnimatorAbs a) /*-{
		return this.addAnimator(a);
	}-*/;
	public final native JavaScriptObject addAnimator(SceneNodeAbs a) /*-{
		return this.addAnimator(a);
	}-*/;


	/**
	 * Adds a child to this scene node. If the scene node already has a parent
	 * it is first removed from the other parent.
	 * 
	 * @param n
	 *            the child scene node to add.
	 */
	public final native JavaScriptObject addChild(SceneNodeAbs n) /*-{
		return this.addChild(n);
	}-*/;

	/**
	 * Creates a clone of this scene node and its children.
	 * 
	 * @param newparent
	 *            The new parent of the cloned scene node.
	 */
	public final native SceneNodeAbs createClone(SceneNodeAbs newparent) /*-{
		return this.createClone(newparent);
	}-*/;

	/**
	 * Gets the absolute position of the node in world coordinates. If you want
	 * the position of the node relative to its parent, use Pos instead, this is
	 * much faster as well. Note: If local changes to the position, scale or
	 * rotation have been made to this scene node in this frame, call
	 * updateAbsolutePosition() to ensure this position is up to date.
	 */
	public final native Vect3d getAbsolutePosition() /*-{
		return this.getAbsolutePosition();
	}-*/;

	/**
	 * Returns the absolute transformation matrix of the node, also known as
	 * world matrix. Note: If local changes to the position, scale or rotation
	 * have been made to this scene node in this frame, call
	 * updateAbsolutePosition() to ensure this transformation is up to date.
	 */
	public final native Matrix4 getAbsoluteTransformation() /*-{
		return this.getAbsoluteTransformation();
	}-*/;

	/**
	 * Returns the first Animator attached to this scene node with the specified
	 * type.
	 * 
	 * @param type
	 *            is a string with the type returned by Animator.getType(). A
	 *            possible value is for example 'camerafps'. See the concreate
	 *            animator implementations for type strings.
	 */
	public final native JavaScriptObject getAnimatorOfType(JavaScriptObject type) /*-{
		return this.getAnimatorOfType(type);
	}-*/;

	/**
	 * Returns an array of Animators which are animating this scene node.
	 */
	public final native JsArray<CameraSceneNode> getAnimators() /*-{
		return this.getAnimators();
	}-*/;

	/**
	 * Returns an array with all child scene nodes of this node
	 */
	public final native JavaScriptObject getChildren() /*-{
		return this.getChildren();
	}-*/;

	/**
	 * Returns the material based on the zero based index i. To get the amount
	 * of materials used by this scene node, use getMaterialCount(). This
	 * function is needed for inserting the node into the scene hierarchy at an
	 * optimal position for minimizing renderstate changes, but can also be used
	 * to directly modify the material of a scene node.
	 * 
	 * @param i
	 */
	public final native Material getMaterial(int i) /*-{
		return this.getMaterial(i);
	}-*/;

	/**
	 * Get amount of materials used by this scene node.
	 */
	public final native JavaScriptObject getMaterialCount() /*-{
		return this.getMaterialCount();
	}-*/;

	/**
	 * Returns the parent scene node of this scene node.
	 */
	public final native JavaScriptObject getParent() /*-{
		return this.getParent();
	}-*/;

	/**
	 * Returns the relative transformation of the scene node. The relative
	 * transformation is stored internally as 3 vectors: translation, rotation
	 * and scale. To get the relative transformation matrix, it is calculated
	 * from these values.
	 */
	public final native JavaScriptObject getRelativeTransformation() /*-{
		return this.getRelativeTransformation();
	}-*/;

	/**
	 * Returns the bounding box of this scene node, transformed with the
	 * absolute transformation of this scene node.
	 */
	public final native JavaScriptObject getTransformedBoundingBox() /*-{
		return this.getTransformedBoundingBox();
	}-*/;

	/**
	 * Initializes the scene node, can be called by scene nodes derived from
	 * this class.
	 */
	public final native JavaScriptObject init() /*-{
		return this.init();
	}-*/;

	/**
	 * OnAnimate() is called just before rendering the whole scene. Nodes may
	 * calculate or store animations here, and may do other useful things,
	 * depending on what they are. Also, OnAnimate() should be called for all
	 * child scene nodes here. This method will be called once per frame,
	 * independent of whether the scene node is visible or not.
	 * 
	 * @param {Scene} the current scene
	 * @param {int} time in milliseconds
	 */
	public final native JavaScriptObject OnAnimate(Scene scene, int current) /*-{
		return this.OnAnimate(scene, current);
	}-*/;

	/**
	 * This method is called just before the rendering process of the whole
	 * scene. Nodes may register themselves in the rendering pipeline during
	 * this call, precalculate the geometry which should be renderered, and
	 * prevent their children from being able to register themselves if they are
	 * clipped by simply not calling their OnRegisterSceneNodeAbs method. If you
	 * are implementing your own scene node, you should overwrite this method
	 * with an implementation code looking like this:
	 */
	public final native JavaScriptObject OnRegisterSceneNodeAbs() /*-{
		return this.OnRegisterSceneNodeAbs();
	}-*/;
	public static void aaa(JavaScriptObject... a){
		
	}
	public final native void setOnRegisterSceneNodeAbs(JsFunction func) /*-{
		this.OnRegisterSceneNode = function(scene){
			func.@com.mostka.cl3d.wraper.JsFunction::execute(*)(scene)
		}
	}-*/;
	public static final native void OnRegisterSceneNodeAbsCall(SceneNodeAbs sceneNode, Scene scene) /*-{
		//$wnd.CL3D.SceneNode.prototype.OnRegisterSceneNode.call(sceneNode, scene);
	}-*/;
	
	/**
	 * Removes an animator from this scene node.
	 * 
	 * @param a
	 *            the new $wnd.CL3D.Animator to remove.
	 */
	public final native JavaScriptObject removeAnimator(SceneNodeAbs a) /*-{
		return this.removeAnimator(a);
	}-*/;

	/**
	 * Removes a child from this scene node.
	 * 
	 * @param n
	 *            the child scene node to remove.
	 */
	public final native JavaScriptObject removeChild(SceneNodeAbs n) /*-{
		return this.removeChild(n);
	}-*/;

	/**
	 * Renders the node. Override to implement rendering your own scene node.
	 * 
	 * @param renderer
	 *            the currently used renderer.
	 */
	public final native JavaScriptObject render(Renderer renderer) /*-{
		return this.render(renderer);
	}-*/;
	
	public final native void setRenderer(JsFunction func) /*-{
		this.render = function(renderer){
			func.@com.mostka.cl3d.wraper.JsFunction::execute(*)(renderer);
		}
	}-*/;

	/**
	 * Updates the absolute position based on the relative and the parents
	 * position. Note: This does not recursively update the parents absolute
	 * positions, so if you have a deeper hierarchy you might want to update the
	 * parents first.
	 */
	public final native JavaScriptObject updateAbsolutePosition() /*-{
			return this.updateAbsolutePosition();
		}-*/;

}
