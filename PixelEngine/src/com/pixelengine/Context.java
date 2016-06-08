package com.pixelengine;

public abstract class Context
{
	protected int width;
	protected int height;
	
	protected Graphics graphics;
	
	public Context(Display display)
	{
		width = display.getWidth();
		height = display.getHeight();
		graphics = new Graphics(display.getFrameBuffer());
	}
	
	public abstract void update(float delta);
	public abstract void render();
}
