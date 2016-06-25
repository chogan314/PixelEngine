package com.pixelengine;

//non-mutable
public class Vec2
{
	private float x;
	private float y;

	/**
	 * Create a new immutable 2D vector.
	 * Initializes to (0, 0)
	 */
	public Vec2()
	{
		x = 0;
		y = 0;
	}

	/**
	 * Create a new immutable 2D vector.
	 * 
	 * @param x
	 * @param y
	 */
	public Vec2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Create a new immutable 2D vector.
	 * 
	 * @param other
	 */
	public Vec2(Vec2 other)
	{
		x = other.x;
		y = other.y;
	}

	/**
	 * @param other
	 * @return new Vec2
	 */
	public Vec2 add(Vec2 other)
	{
		return new Vec2(x + other.x, y + other.y);
	}

	/**
	 * @param other
	 * @return new Vec2
	 */
	public Vec2 sub(Vec2 other)
	{
		return new Vec2(x - +other.x, y - other.y);
	}

	/**
	 * @param other
	 * @return new Vec2
	 */
	public Vec2 mult(Vec2 other)
	{
		return new Vec2(x * other.x, y * other.y);
	}

	/**
	 * @param other
	 * @return new Vec2
	 */
	public Vec2 div(Vec2 other)
	{
		return new Vec2(x / other.x, y / other.y);
	}

	/**
	 * @param x
	 * @param y
	 * @return new Vec2
	 */
	public Vec2 add(float x, float y)
	{
		return new Vec2(this.x + x, this.y + y);
	}

	/**
	 * @param x
	 * @param y
	 * @return new Vec2
	 */
	public Vec2 sub(float x, float y)
	{
		return new Vec2(this.x - x, this.y - y);
	}

	/**
	 * @param x
	 * @param y
	 * @return new Vec2
	 */
	public Vec2 mult(float x, float y)
	{
		return new Vec2(this.x * x, this.y * y);
	}

	/**
	 * @param x
	 * @param y
	 * @return new Vec2
	 */
	public Vec2 div(float x, float y)
	{
		return new Vec2(this.x / x, this.y / y);
	}

	/**
	 * @param val
	 * @return new Vec2
	 */
	public Vec2 add(float val)
	{
		return new Vec2(x + val, y + val);
	}

	/**
	 * @param val
	 * @return new Vec2
	 */
	public Vec2 sub(float val)
	{
		return new Vec2(x - val, y - val);
	}

	/**
	 * @param val
	 * @return new Vec2
	 */
	public Vec2 div(float val)
	{
		return new Vec2(x / val, y / val);
	}

	/**
	 * @param val
	 * @return new Vec2
	 */
	public Vec2 mult(float val)
	{
		return new Vec2(x * val, y * val);
	}
	
	/**
	 * @return normalized copy of Vec2
	 */
	public Vec2 normalize()
	{
		float len = len();
		return new Vec2(x / len, y / len);
	}
	
	/**
	 * @return copy of Vec2
	 */
	public Vec2 cpy()
	{
		return new Vec2(x, y);
	}

	/**
	 * @return length of Vec2
	 */
	public float len()
	{
		return (float) Math.sqrt(x * x + y * y);
	}

	/**
	 * @return length of Vec2 squared
	 */
	public float len2()
	{
		return x * x + y * y;
	}

	/**
	 * @param other
	 * @return dot product of Vec2 and other
	 */
	public float dot(Vec2 other)
	{
		return x * other.x + y * other.y;
	}

	/**
	 * @return x component
	 */
	public float getX()
	{
		return x;
	}

	/**
	 * @return y component
	 */
	public float getY()
	{
		return y;
	}
}
