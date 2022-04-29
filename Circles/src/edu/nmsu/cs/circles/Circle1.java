package edu.nmsu.cs.circles;

public class Circle1 extends Circle
{

	public Circle1(double x, double y, double radius)
	{
		super(x, y, radius);
	}
	//TODO: fix this bug
	public boolean intersects(Circle other)
	{
		// if (Math.abs(center.x - other.center.x) <= radius &&
		// 	Math.abs(center.y - other.center.y) <= radius)
		// 	return true;
		// return false;

		int squaredDistance = (center.x - other.center.x) * center.x - other.center.x) +
				(center.y - other.center.y) * (center.y - other.center.y);
		int radiusSquared = (radius + center.radius) * (radius + center.radius);
		if (squaredDistance == radiusSquared)
			return true;
		else if (squaredDistance > radiusSquared)
			return false;
		else
			return true;
	}

}
