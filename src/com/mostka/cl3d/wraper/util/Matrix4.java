package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Matrix4 extends JavaScriptObject{

	protected Matrix4(){}

	/**
	 * A 4x4 matrix, mostly used as transformation matrix for 3d calculations.
	 * @param bMakeIdentityIf set to true, the matrix will initially have stored the identity matrix.
	 */

	public static native Matrix4 create(boolean bMakeIdentity) /*-{
			return new $wnd.CL3D.Matrix4(bMakeIdentity);
	}-*/;

	/**
	 * Returns the content of this matrix as array
	 */
	public final native JavaScriptObject asArray() /*-{
			return this.asArray();
	}-*/;

	/**
	 * Builds a left-handed look-at matrix.
	 * @param position 
	 * @param target 
	 * @param upVector 
	 */
	public final native JavaScriptObject buildCameraLookAtMatrixLH(JavaScriptObject position, JavaScriptObject target, JavaScriptObject upVector) /*-{
			return this.buildCameraLookAtMatrixLH(position, target, upVector);
	}-*/;

	/**
	 * Builds a left-handed perspective projection matrix based on a field of view.
	 * @param fieldOfViewRadians 
	 * @param aspectRatio 
	 * @param zNear 
	 * @param zFar 
	 */
	public final native JavaScriptObject buildProjectionMatrixPerspectiveFovLH(JavaScriptObject fieldOfViewRadians, JavaScriptObject aspectRatio, JavaScriptObject zNear, JavaScriptObject zFar) /*-{
			return this.buildProjectionMatrixPerspectiveFovLH(fieldOfViewRadians, aspectRatio, zNear, zFar);
	}-*/;

	/**
	 * Creates a clone of this matrix
	 */
	public final native JavaScriptObject clone() /*-{
			return this.clone();
	}-*/;

	/**
	 * Copies the content of this matrix to a target matrix
	 * @param mat 
	 */
	public final native JavaScriptObject copyTo(JavaScriptObject mat) /*-{
			return this.copyTo(mat);
	}-*/;

	/**
	 * Returns if this matrix equals another matrix, uses CL3D.equals as comparison operator.
	 * @param mat 
	 */
	public final native JavaScriptObject equals(JavaScriptObject mat) /*-{
			return this.equals(mat);
	}-*/;

	/**
	 * Copies the inverse of this matrix into the output matrix, returns true succcessful.
	 * @param out 
	 */
	public final native JavaScriptObject getInverse(JavaScriptObject out) /*-{
			return this.getInverse(out);
	}-*/;

	/**
	 * Returns a new vector, rotated from the input vector by this matrix
	 * @param v 
	 */
	public final native JavaScriptObject getRotatedVect(JavaScriptObject v) /*-{
			return this.getRotatedVect(v);
	}-*/;

	/**
	 * Returns the rotation, as set by setRotation(). 
Returns a rotation that is equivalent to that set by setRotationDegrees().
	 */
	public final native JavaScriptObject getRotationDegrees() /*-{
			return this.getRotationDegrees();
	}-*/;

	/**
	 * Returns the scle stored in the matrix as 3d vector
	 */
	public final native JavaScriptObject getScale() /*-{
			return this.getScale();
	}-*/;

	/**
	 * returns a new transformed vector from the input vector
	 * @param v 
	 */
	public final native JavaScriptObject getTransformedVect(JavaScriptObject v) /*-{
			return this.getTransformedVect(v);
	}-*/;

	/**
	 * Translates a input vector by this matrix and returns it as new vector.
	 * @param v 
	 */
	public final native JavaScriptObject getTranslatedVect(JavaScriptObject v) /*-{
			return this.getTranslatedVect(v);
	}-*/;

	/**
	 * Returns the translation stored in the matrix as 3d vector
	 */
	public final native JavaScriptObject getTranslation() /*-{
			return this.getTranslation();
	}-*/;

	/**
	 * Returns a transposed version of this matrix
	 */
	public final native JavaScriptObject getTransposed() /*-{
			return this.getTransposed();
	}-*/;

	/**
	 * Rotate a vector by the inverse of the rotation part of this matrix.
	 * @param v 
	 */
	public final native JavaScriptObject inverseRotateVect(JavaScriptObject v) /*-{
			return this.inverseRotateVect(v);
	}-*/;

	/**
	 * Returns if this matrix is the identity matrix
	 */
	public final native JavaScriptObject isIdentity() /*-{
			return this.isIdentity();
	}-*/;

	/**
	 * returns if only the translation is set in the matrix
	 */
	public final native JavaScriptObject isTranslateOnly() /*-{
			return this.isTranslateOnly();
	}-*/;

	/**
	 * Makes this matrix the identitiy matrix
	 */
	public final native JavaScriptObject makeIdentity() /*-{
			return this.makeIdentity();
	}-*/;

	/**
	 * Inverts this matrix, returns true if successful
	 */
	public final native JavaScriptObject makeInverse() /*-{
			return this.makeInverse();
	}-*/;

	/**
	 * Multiplies this matrix with another matrix, returns the result as a new matrix.
	 * @param m2 
	 */
	public final native JavaScriptObject multiply(JavaScriptObject m2) /*-{
			return this.multiply(m2);
	}-*/;

	/**
	 * Multiplies this matrix with a 4D Vector (expects components X, Y, Z and W), result is stored in the input vector
	 * @param v 
	 */
	public final native JavaScriptObject multiplyWith1x4Matrix(JavaScriptObject v) /*-{
			return this.multiplyWith1x4Matrix(v);
	}-*/;

	/**
	 * same as multiplyWith1x4Matrix, but faster and returns w as value
	 * @param v 
	 */
	public final native JavaScriptObject multiplyWith1x4Matrix2(JavaScriptObject v) /*-{
			return this.multiplyWith1x4Matrix2(v);
	}-*/;

	/**
	 * Rotates a 3d vector by this matrix.
	 * @param v 
	 */
	public final native JavaScriptObject rotateVect(JavaScriptObject v) /*-{
			return this.rotateVect(v);
	}-*/;

	/**
	 * Rotates an input vector and stores the result in the output paramter
	 * @param out 
	 * @param inp 
	 */
	public final native JavaScriptObject rotateVect2(JavaScriptObject out, JavaScriptObject inp) /*-{
			return this.rotateVect2(out, inp);
	}-*/;

	/**
	 * Sets a value of the matrix by index
	 * @param i Index in the matrix, a value between 0 and 15
	 * @param n Value to set
	 */
	public final native JavaScriptObject setByIndex(JavaScriptObject i, JavaScriptObject n) /*-{
			return this.setByIndex(i, n);
	}-*/;

	/**
	 * Make a rotation matrix from Euler angles. The 4th row and column are unmodified.
	 * @param v rotation vector
	 */
	public final native JavaScriptObject setRotationDegrees(Vect3d v) /*-{
			return this.setRotationDegrees(v);
	}-*/;

	/**
	 * Make a rotation matrix from Euler angles. The 4th row and column are unmodified.
	 * @param rotation rotation vector
	 */
	public final native JavaScriptObject setRotationRadians(Vect3d rotation) /*-{
			return this.setRotationRadians(rotation);
	}-*/;

	/**
	 * Sets the scale of the matrix
	 * @param v translation vector
	 */
	public final native JavaScriptObject setScale(Vect3d v) /*-{
			return this.setScale(v);
	}-*/;

	/**
	 * Sets the scale of the matrix
	 * @param x 
	 * @param y 
	 * @param z 
	 */
	public final native JavaScriptObject setScaleXYZ(JavaScriptObject x, JavaScriptObject y, JavaScriptObject z) /*-{
			return this.setScaleXYZ(x, y, z);
	}-*/;

	/**
	 * Set the translation of the current matrix. Will erase any previous values.
	 * @param v translation vector
	 */
	public final native JavaScriptObject setTranslation(Vect3d v) /*-{
			return this.setTranslation(v);
	}-*/;

	/**
	 * Transforms a 3d box
	 * @param box 
	 */
	public final native JavaScriptObject transformBoxEx(Box3d box) /*-{
			return this.transformBoxEx(box);
	}-*/;

	/**
	 * Transforms a 3d box with another method which is more exact than transformBoxEx
	 * @param box 
	 */
	public final native JavaScriptObject transformBoxEx2(Box3d box) /*-{
			return this.transformBoxEx2(box);
	}-*/;

	/**
	 * Transforms a 3d plane by this matrix
	 * @param plane 
	 */
	public final native JavaScriptObject transformPlane(JavaScriptObject plane) /*-{
			return this.transformPlane(plane);
	}-*/;

	/**
	 * Transforms the input vector by this matrix
	 * @param v 
	 */
	public final native JavaScriptObject transformVect(JavaScriptObject v) /*-{
			return this.transformVect(v);
	}-*/;

	/**
	 * Transforms the input vector by this matrix and stores the result in the ouput parameter
	 * @param out 
	 * @param inp 
	 */
	public final native JavaScriptObject transformVect2(JavaScriptObject out, JavaScriptObject inp) /*-{
			return this.transformVect2(out, inp);
	}-*/;

	/**
	 * Translates a vector by this matrix
	 * @param v 
	 */
	public final native JavaScriptObject translateVect(JavaScriptObject v) /*-{
			return this.translateVect(v);
	}-*/;

}