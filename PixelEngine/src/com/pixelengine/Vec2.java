package com.pixelengine;

//non-mutable
public class Vec2
{
	private float x;
	private float y;

	public Vec2()
	{
		x = 0;
		y = 0;
	}

	public Vec2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public Vec2(Vec2 other)
	{
		x = other.x;
		y = other.y;
	}

	public Vec2 add(Vec2 other)
	{
		return new Vec2(x + other.x, y + other.y);
	}

	public Vec2 sub(Vec2 other)
	{
		return new Vec2(x - +other.x, y - other.y);
	}

	public Vec2 mult(Vec2 other)
	{
		return new Vec2(x * other.x, y * other.y);
	}

	public Vec2 div(Vec2 other)
	{
		return new Vec2(x / other.x, y / other.y);
	}

	public Vec2 add(float x, float y)
	{
		return new Vec2(this.x + x, this.y + y);
	}

	public Vec2 sub(float x, float y)
	{
		return new Vec2(this.x - x, this.y - y);
	}

	public Vec2 mult(float x, float y)
	{
		return new Vec2(this.x * x, this.y * y);
	}

	public Vec2 div(float x, float y)
	{
		return new Vec2(this.x / x, this.y / y);
	}

	public Vec2 add(float val)
	{
		return new Vec2(x + val, y + val);
	}

	public Vec2 sub(float val)
	{
		return new Vec2(x - val, y - val);
	}

	public Vec2 div(float val)
	{
		return new Vec2(x / val, y / val);
	}

	public Vec2 mult(float val)
	{
		return new Vec2(x * val, y * val);
	}
	
	public Vec2 normalize()
	{
		float len = len();
		return new Vec2(x / len, y / len);
	}

	public float len()
	{
		return (float) Math.sqrt(x * x + y * y);
	}

	public float len2()
	{
		return x * x + y * y;
	}

	public float dot(Vec2 other)
	{
		return x * other.x + y * other.y;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}
}
