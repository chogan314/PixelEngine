package com.pixelengine;

public class Engine
{
	private float updateRate = 1.0f / 60.0f;
	private boolean showFPS = true;
	private Display display;
	private Input input;
	private Context context;
	
	/**
	 * @param width
	 * @param height
	 */
	public Engine(int width, int height)
	{
		display = new Display(width, height);
		input = new Input();
		display.addKeyListener(input);
		display.addMouseListener(input);
		display.addMouseWheelListener(input);
		display.addMouseMotionListener(input);
		display.requestFocus();
	}
	
	/**
	 * 
	 */
	public void run()
	{
		float updateTime = 0;
		float frameTime = 0;
		int frames = 0;
		long previousTime = System.nanoTime();
		
		while(true)
		{
			long currentTime = System.nanoTime();
			float delta = (float)((currentTime - previousTime) / 1000000000.0);
			previousTime = currentTime;

			frameTime += delta;
			while (frameTime >= 1)
			{
				if (showFPS)
				{
					System.out.println(frames);
				}
				frameTime -= 1;
				frames = 0;
			}
			
			updateTime += delta;
			while (updateTime >= updateRate)
			{
				input.flushInputEvents();
				context.update(updateRate);
				updateTime -= updateRate;
			}
			
			context.render();
			
			display.SwapBuffers();
			frames++;
		}
	}
	
	/**
	 * @param context
	 */
	public void registerContext(Context context)
	{
		this.context = context;
	}
	
	/**
	 * @param handler
	 */
	public void registerInputHandler(InputHandler handler)
	{
		input.registerInputHandler(handler);
	}
	
	/**
	 * @return
	 */
	public Display getDisplay()
	{
		return display;
	}
	
	/**
	 * @param show
	 */
	public void showFPS(boolean show)
	{
		showFPS = show;
	}
}








