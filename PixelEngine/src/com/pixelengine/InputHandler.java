package com.pixelengine;

public interface InputHandler
{
	public void onKeyDown(int key);
	public void onKeyUp(int key);
	public void onMouseButtonDown(int mouseButton);
	public void onMouseButtonUp(int mouseButton);
	public void onMouseScroll(int rotation);
	public void onMouseMoved(int x, int y);
}
