package com.pixelengine;

public class Engine
{
	private float updateRate = 1.0f / 60.0f;
	private boolean showFPS = true;
	private Display display;
	private Input input;
	private Context context;
	
	/**
	 * Create a new engine.
	 * 
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
	 * Start the engine.
	 * Context must be given using registerContext(Context context) before engine can be run.
	 */
	public void run()
	{
		if (context == null)
		{
			throw new NullPointerException("Engine must have a context before it can run.");
		}
		
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
	 * Register context. Must be called before run().
	 * 
	 * @param context
	 */
	public void registerContext(Context context)
	{
		this.context = context;
	}
	
	/**
	 * Register input handler. Optionally called before run().
	 * 
	 * @param handler
	 */
	public void registerInputHandler(InputHandler handler)
	{
		input.registerInputHandler(handler);
	}
	
	/**
	 * @return backing display
	 */
	public Display getDisplay()
	{
		return display;
	}
	
	/**
	 * Toggle FPS display in console. Don't call after run().
	 * 
	 * @param show
	 */
	public void showFPS(boolean show)
	{
		showFPS = show;
	}
}








