package com.pixelengine;

public interface InputHandler
{
	/**
	 * @param key	the keycode value: keycodes in Input class
	 */
	public void onKeyDown(int key);
	
	/**
	 * @param key	the keycode value: keycodes in Input class
	 */
	public void onKeyUp(int key);
	
	/**
	 * @param mouseButton
	 */
	public void onMouseButtonDown(int mouseButton);
	
	/**
	 * @param mouseButton
	 */
	public void onMouseButtonUp(int mouseButton);
	
	/**
	 * @param rotation
	 */
	public void onMouseScroll(int rotation);
	
	/**
	 * @param x
	 * @param y
	 */
	public void onMouseMoved(int x, int y);
}
