package com.pixelengine.test;

import com.pixelengine.Context;
import com.pixelengine.Display;
import com.pixelengine.Input;
import com.pixelengine.InputHandler;

public class TestContext extends Context implements InputHandler
{
	int mouseX;
	int mouseY;
	int g = 0;
	
	public TestContext(Display display)
	{
		super(display);
		graphics.setClearColor(255, 0, 0);
	}

	@Override
	public void update(float delta)
	{
		
	}

	@Override
	public void render()
	{
		graphics.clear();
		graphics.setBrushColor(0, g, 255);
		for (int y = mouseY - 50; y < mouseY + 50; y++)
		{
			for (int x = mouseX - 50; x < mouseX + 50; x++)
			{
				graphics.drawPixel(x, y);
			}
		}
	}

	@Override
	public void onKeyDown(int key)
	{
		if (key == Input.KEY_LSHIFT)
		{
			System.out.println("LEFT SHIFT");
		}
		
		if (key == Input.KEY_RSHIFT)
		{
			System.out.println("RIGHT SHIFT");
		}
	}

	@Override
	public void onKeyUp(int key)
	{
		
	}

	@Override
	public void onMouseButtonDown(int mouseButton)
	{
		
	}

	@Override
	public void onMouseButtonUp(int mouseButton)
	{
		
	}

	@Override
	public void onMouseScroll(int rotation)
	{
		g += rotation  * -6;
	}

	@Override
	public void onMouseMoved(int x, int y)
	{
		mouseX = x;
		mouseY = y;
	}

}
