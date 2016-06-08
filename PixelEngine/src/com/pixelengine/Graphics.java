package com.pixelengine;

public class Graphics
{
	private Bitmap bitmap;
	
	public Graphics(Bitmap bitmap)
	{
		this.bitmap = bitmap;
	}
	
	public void setClearColor(int r, int g, int b)
	{
		bitmap.setClearColor(r, g, b);
	}
	
	public void clear()
	{
		bitmap.clear();
	}
	
	public void setBrushColor(int r, int g, int b)
	{
		bitmap.setBrushColor(r, g, b);
	}
	
	public void drawPixel(int x, int y)
	{
		if (x < 0 || x >= bitmap.getWidth() || y < 0 || y >= bitmap.getHeight())
		{
			return;
		}
		
		bitmap.drawPixel(x, y);
	}
	
	public void copyToArray(int[] dest)
	{
		bitmap.copyToArray(dest);
	}
	
	public int getWidth()
	{
		return bitmap.getWidth();
	}
	
	public int getHeight()
	{
		return bitmap.getHeight();
	}
}
