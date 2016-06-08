package com.pixelengine;

public class Bitmap
{
	private final int width;
	private final int height;

	private final int[] components;
	private final int[] clearComponents;

	private int brushColor;

	public Bitmap(int width, int height)
	{
		this.width = width;
		this.height = height;

		components = new int[width * height];
		clearComponents = new int[width * height];
	}

	public void setClearColor(int r, int g, int b)
	{
		for (int i = 0; i < clearComponents.length; i++)
		{
			int argb = -16777216;
			argb += (b & 0xff);
			argb += ((g & 0xff) << 8);
			argb += ((r & 0xff) << 16);
			clearComponents[i] = argb;
		}
	}

	public void clear()
	{
		System.arraycopy(clearComponents, 0, components, 0, components.length);
	}

	public void setBrushColor(int r, int g, int b)
	{
		brushColor = -16777216;
		brushColor += (b & 0xff);
		brushColor += ((g & 0xff) << 8);
		brushColor += ((r & 0xff) << 16);
	}

	public void drawPixel(int x, int y)
	{		
		int index = x + y * width;

		components[index] = brushColor;
	}

	public void copyToArray(int[] dest)
	{
		System.arraycopy(components, 0, dest, 0, dest.length);
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
