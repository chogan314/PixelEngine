package com.pixelengine;

public class Bitmap
{
	private final int width;
	private final int height;

	private final int[] components;
	private final int[] clearComponents;

	private int brushColor;

	/**
	 * Create new bitmap.
	 * 
	 * @param width
	 * @param height
	 */
	public Bitmap(int width, int height)
	{
		this.width = width;
		this.height = height;

		components = new int[width * height];
		clearComponents = new int[width * height];
	}

	/**
	 * Set color to fill with when clear() is called.
	 * Very high overhead, avoid calling in main loop.
	 * 
	 * @param r		red component (0 - 255)
	 * @param g		green component(0 - 255)
	 * @param b		blue component(0 - 255)
	 */
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

	/**
	 * Fill with color provided by setClearColor().
	 */
	public void clear()
	{
		System.arraycopy(clearComponents, 0, components, 0, components.length);
	}

	/**
	 * Set brush color to (r, g, b).
	 * 
	 * @param r		red component (0 - 255)
	 * @param g		green component(0 - 255)
	 * @param b		blue component(0 - 255)
	 */
	public void setBrushColor(int r, int g, int b)
	{
		brushColor = -16777216;
		brushColor += (b & 0xff);
		brushColor += ((g & 0xff) << 8);
		brushColor += ((r & 0xff) << 16);
	}

	/**
	 * Draw a single pixel of set brush color at (x, y).
	 * Top left corner is (0, 0).
	 * 
	 * @param x
	 * @param y
	 */
	public void drawPixel(int x, int y)
	{		
		int index = x + y * width;

		components[index] = brushColor;
	}

	/**
	 * Copy components to int array.
	 * 
	 * @param dest
	 */
	public void copyToArray(int[] dest)
	{
		System.arraycopy(components, 0, dest, 0, dest.length);
	}

	/**
	 * @return width of bitmap in pixels
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * @return height of bitmap in pixels
	 */
	public int getHeight()
	{
		return height;
	}
}
