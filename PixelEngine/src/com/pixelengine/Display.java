package com.pixelengine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Display extends Canvas
{
	private final int width;
	private final int height;

	private final JFrame frame;
	private final Bitmap frameBuffer;
	private final BufferedImage displayImage;
	private final int[] displayComponents;
	private final BufferStrategy bufferStrategy;
	private final Graphics graphics;

	public Display(int width, int height)
	{
		this.width = width;
		this.height = height;

		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		frameBuffer = new Bitmap(width, height);
		displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		displayComponents = ((DataBufferInt) displayImage.getRaster().getDataBuffer()).getData();

		frame = new JFrame();
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("PixelEngine");
		frame.setSize(width, height);
		frame.pack();
		frame.setVisible(true);

		createBufferStrategy(2);
		bufferStrategy = getBufferStrategy();
		graphics = bufferStrategy.getDrawGraphics();
	}

	public void SwapBuffers()
	{
		frameBuffer.copyToArray(displayComponents);
		graphics.drawImage(displayImage, 0, 0, frameBuffer.getWidth(), frameBuffer.getHeight(), this);
		bufferStrategy.show();
	}

	public Bitmap getFrameBuffer()
	{
		return frameBuffer;
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
