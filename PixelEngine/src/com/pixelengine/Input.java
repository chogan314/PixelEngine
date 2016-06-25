package com.pixelengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Input implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener
{
	public static final int KEY_0 = KeyEvent.VK_0;
	public static final int KEY_1 = KeyEvent.VK_1;
	public static final int KEY_2 = KeyEvent.VK_2;
	public static final int KEY_3 = KeyEvent.VK_3;
	public static final int KEY_4 = KeyEvent.VK_4;
	public static final int KEY_5 = KeyEvent.VK_5;
	public static final int KEY_6 = KeyEvent.VK_6;
	public static final int KEY_7 = KeyEvent.VK_7;
	public static final int KEY_8 = KeyEvent.VK_8;
	public static final int KEY_9 = KeyEvent.VK_9;
	
	public static final int KEY_A = KeyEvent.VK_A;
	public static final int KEY_B = KeyEvent.VK_B;
	public static final int KEY_C = KeyEvent.VK_C;
	public static final int KEY_D = KeyEvent.VK_D;
	public static final int KEY_E = KeyEvent.VK_E;
	public static final int KEY_F = KeyEvent.VK_F;
	public static final int KEY_G = KeyEvent.VK_G;
	public static final int KEY_H = KeyEvent.VK_H;
	public static final int KEY_I = KeyEvent.VK_I;
	public static final int KEY_J = KeyEvent.VK_J;
	public static final int KEY_K = KeyEvent.VK_K;
	public static final int KEY_L = KeyEvent.VK_L;
	public static final int KEY_M = KeyEvent.VK_M;
	public static final int KEY_N = KeyEvent.VK_N;
	public static final int KEY_O = KeyEvent.VK_O;
	public static final int KEY_P = KeyEvent.VK_P;
	public static final int KEY_Q = KeyEvent.VK_Q;
	public static final int KEY_R = KeyEvent.VK_R;
	public static final int KEY_S = KeyEvent.VK_S;
	public static final int KEY_T = KeyEvent.VK_T;
	public static final int KEY_U = KeyEvent.VK_U;
	public static final int KEY_V = KeyEvent.VK_V;
	public static final int KEY_W = KeyEvent.VK_W;
	public static final int KEY_X = KeyEvent.VK_X;
	public static final int KEY_Y = KeyEvent.VK_Y;
	public static final int KEY_Z = KeyEvent.VK_Z;
	
	public static final int KEY_F1 = KeyEvent.VK_F1;
	public static final int KEY_F2 = KeyEvent.VK_F2;
	public static final int KEY_F3 = KeyEvent.VK_F3;
	public static final int KEY_F4 = KeyEvent.VK_F4;
	public static final int KEY_F5 = KeyEvent.VK_F5;
	public static final int KEY_F6 = KeyEvent.VK_F6;
	public static final int KEY_F7 = KeyEvent.VK_F7;
	public static final int KEY_F8 = KeyEvent.VK_F8;
	public static final int KEY_F9 = KeyEvent.VK_F9;
	public static final int KEY_F10 = KeyEvent.VK_F10;
	public static final int KEY_F11 = KeyEvent.VK_F11;
	public static final int KEY_F12 = KeyEvent.VK_F12;
	
	public static final int KEY_ESC = KeyEvent.VK_ESCAPE;
	public static final int KEY_BACKQUOTE = KeyEvent.VK_BACK_QUOTE;
	public static final int KEY_MINUS = KeyEvent.VK_MINUS;
	public static final int KEY_PLUS = KeyEvent.VK_PLUS;
	public static final int KEY_TAB = KeyEvent.VK_TAB;
	public static final int KEY_LBRACKET = KeyEvent.VK_OPEN_BRACKET;
	public static final int KEY_RBRACKET = KeyEvent.VK_CLOSE_BRACKET;
	public static final int KEY_BACKSLASH = KeyEvent.VK_BACK_SLASH;
	public static final int KEY_CAPSLOCK = KeyEvent.VK_CAPS_LOCK;
	public static final int KEY_SEMICOLON = KeyEvent.VK_SEMICOLON;
	public static final int KEY_SINGLEQUOTE = KeyEvent.VK_QUOTE;
	public static final int KEY_COMMA = KeyEvent.VK_COMMA;
	public static final int KEY_PERIOD = KeyEvent.VK_PERIOD;
	public static final int KEY_FSLASH = KeyEvent.VK_SLASH;
	public static final int KEY_WINDOWS = KeyEvent.VK_WINDOWS;
	
	public static final int KEY_UP = KeyEvent.VK_UP;
	public static final int KEY_DOWN = KeyEvent.VK_DOWN;
	public static final int KEY_LEFT = KeyEvent.VK_LEFT;
	public static final int KEY_RIGHT = KeyEvent.VK_RIGHT;
	
	public static final int KEY_LSHIFT = 50001;
	public static final int KEY_RSHIFT = 50002;
	public static final int KEY_LCTRL = 50003;
	public static final int KEY_RCTRL = 50004;
	public static final int KEY_LALT = 50005;
	public static final int KEY_RALT = 50006;
	
	// input events base class
	private abstract class PInputEvent
	{
		protected InputHandler handler;
		
		public PInputEvent(InputHandler handler)
		{
			this.handler = handler;
		}
		
		public abstract void process();
	}
	
	// key events
	private class PKeyEvent extends PInputEvent
	{
		private boolean keyDown;
		private int keyCode;
		private Set<Integer> keys;
		
		public PKeyEvent(InputHandler handler, boolean keyDown, int keyCode, Set<Integer> keys)
		{
			super(handler);
			this.keyDown = keyDown;
			this.keyCode = keyCode;
			this.keys = keys;
		}

		@Override
		public void process()
		{
			if (handler != null)
			{
				if (keyDown)
				{
					if (keys.contains(keyCode))
					{
						return;
					}
					
					keys.add(keyCode);
					
					handler.onKeyDown(keyCode);
				}
				else
				{
					keys.remove(keyCode);
					handler.onKeyUp(keyCode);
				}
			}
		}
	}
	
	// mouse button events
	private class PMouseButtonEvent extends PInputEvent
	{
		private boolean mbDown;
		private int mbCode;
		private Set<Integer> mouseButtons;
		
		public PMouseButtonEvent(InputHandler handler, boolean mbDown, int mbCode, Set<Integer> mouseButtons)
		{
			super(handler);
			this.mbDown = mbDown;
			this.mbCode = mbCode;
			this.mouseButtons = mouseButtons;
		}

		@Override
		public void process()
		{
			if (handler != null)
			{
				if (mbDown)
				{
					if (mouseButtons.contains(mbCode))
					{
						return;
					}
					
					mouseButtons.add(mbCode);
					
					handler.onMouseButtonDown(mbCode);
				}
				else
				{
					mouseButtons.remove(mbCode);
					
					handler.onMouseButtonUp(mbCode);
				}
			}
		}
	}
	
	// mouse scroll events
	private class PMouseScrollEvent extends PInputEvent
	{
		private int rotation;
		
		public PMouseScrollEvent(InputHandler handler, int rotation)
		{
			super(handler);
			this.rotation = rotation;
		}

		@Override
		public void process()
		{
			if (handler != null)
			{
				handler.onMouseScroll(rotation);
			}
		}
	}
	
	// mouse moved events
	private class PMouseMovedEvent extends PInputEvent
	{
		private int x;
		private int y;
		
		public PMouseMovedEvent(InputHandler handler, int x, int y)
		{
			super(handler);
			this.x = x;
			this.y = y;
		}

		@Override
		public void process()
		{
			if (handler != null)
			{
				handler.onMouseMoved(x, y);
			}
		}
	}
	
	private Queue<PInputEvent> inputEvents;
	private Queue<PInputEvent> inputEventsOut;
	private InputHandler handler;

	private Set<Integer> keys;
	private Set<Integer> mouseButtons;
	
	/**
	 * 
	 */
	public Input()
	{
		inputEvents = new LinkedList<PInputEvent>();
		inputEventsOut = new LinkedList<PInputEvent>();
		keys = new HashSet<Integer>();
		mouseButtons = new HashSet<Integer>();
	}

	/**
	 * @param handler
	 */
	public void registerInputHandler(InputHandler handler)
	{
		this.handler = handler;
	}

	@Override
	public void mouseDragged(MouseEvent event)
	{
		synchronized (inputEvents)
		{
			inputEvents.add(new PMouseMovedEvent(handler, event.getX(), event.getY()));
		}
	}

	@Override
	public void mouseMoved(MouseEvent event)
	{
		synchronized (inputEvents)
		{
			inputEvents.add(new PMouseMovedEvent(handler, event.getX(), event.getY()));
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event)
	{
		synchronized (inputEvents)
		{
			inputEvents.add(new PMouseScrollEvent(handler, event.getWheelRotation()));
		}
	}

	@Override
	public void mouseClicked(MouseEvent event)
	{
		// do nothing
	}

	@Override
	public void mouseEntered(MouseEvent event)
	{
		// do nothing
	}

	@Override
	public void mouseExited(MouseEvent event)
	{
		// do nothing
	}

	@Override
	public void mousePressed(MouseEvent event)
	{
		synchronized (inputEvents)
		{
			inputEvents.add(new PMouseButtonEvent(handler, true, event.getButton(), mouseButtons));
		}
	}

	@Override
	public void mouseReleased(MouseEvent event)
	{
		synchronized (inputEvents)
		{
			inputEvents.add(new PMouseButtonEvent(handler, false, event.getButton(), mouseButtons));
		}
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		synchronized (inputEvents)
		{
			inputEvents.add(new PKeyEvent(handler, true, transformKeyEvent(event), keys));
		}
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		synchronized (inputEvents)
		{
			inputEvents.add(new PKeyEvent(handler, false, transformKeyEvent(event), keys));
		}
	}

	@Override
	public void keyTyped(KeyEvent event)
	{
		// do nothing
	}
	
	/**
	 * 
	 */
	public void flushInputEvents()
	{
		inputEventsOut.clear();
		
		synchronized (inputEvents)
		{
			inputEventsOut.addAll(inputEvents);
			inputEvents.clear();
		}
		
		while (!inputEventsOut.isEmpty())
		{
			inputEventsOut.remove().process();
		}
	}
	
	private int transformKeyEvent(KeyEvent event)
	{
		int keyCode = event.getKeyCode();

		switch (keyCode)
		{
		case KeyEvent.VK_SHIFT:
			keyCode = event.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT ? KEY_RSHIFT : KEY_LSHIFT;
			break;
		case KeyEvent.VK_CONTROL:
			keyCode = event.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT ? KEY_RCTRL : KEY_LCTRL;
			break;
		case KeyEvent.VK_ALT:
			keyCode = event.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT ? KEY_RALT : KEY_LALT;
			break;
		default:
			break;
		}
		
		return keyCode;
	}
}












