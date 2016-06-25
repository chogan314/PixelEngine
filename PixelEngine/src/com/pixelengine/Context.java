package com.pixelengine;

public abstract class Context
{
	protected int width;
	protected int height;
	
	protected Bitmap graphics;
	
	/**
	 * Create a new context with size determined by given display.
	 * Use the display of some Engine as an argument.
	 * 
	 * @param display		display of engine
	 */
	public Context(Display display)
	{
		width = display.getDisplayWidth();
		height = display.getDisplayHeight();
		graphics = display.getFrameBuffer();
	}
	
	/**
	 * Update game logic.
	 * 
	 * @param delta	time since last update in seconds
	 */
	public abstract void update(float delta);
	
	/**
	 * Draw using graphics object.
	 */
	public abstract void render();
}
