package com.pixelengine;

public class Graphics
{
	private Bitmap bitmap;
	
	/**
	 * @param bitmap
	 */
	public Graphics(Bitmap bitmap)
	{
		this.bitmap = bitmap;
	}
	
	/**
	 * @param r
	 * @param g
	 * @param b
	 */
	public void setClearColor(int r, int g, int b)
	{
		bitmap.setClearColor(r, g, b);
	}
	
	/**
	 * 
	 */
	public void clear()
	{
		bitmap.clear();
	}
	
	/**
	 * @param r
	 * @param g
	 * @param b
	 */
	public void setBrushColor(int r, int g, int b)
	{
		bitmap.setBrushColor(r, g, b);
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void drawPixel(int x, int y)
	{
		if (x < 0 || x >= bitmap.getWidth() || y < 0 || y >= bitmap.getHeight())
		{
			return;
		}
		
		bitmap.drawPixel(x, y);
	}
	
	/**
	 * @param dest
	 */
	public void copyToArray(int[] dest)
	{
		bitmap.copyToArray(dest);
	}
	
	/**
	 * @return
	 */
	public int getWidth()
	{
		return bitmap.getWidth();
	}
	
	/**
	 * @return
	 */
	public int getHeight()
	{
		return bitmap.getHeight();
	}
}
