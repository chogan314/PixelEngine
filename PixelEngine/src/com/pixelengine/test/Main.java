package com.pixelengine.test;

import com.pixelengine.Engine;

public class Main
{
	public static void main(String[] args)
	{
		Engine engine = new Engine(800, 600);
		TestContext test = new TestContext(engine.getDisplay());
		engine.registerContext(test);
		engine.registerInputHandler(test);
		engine.run();
	}
}
