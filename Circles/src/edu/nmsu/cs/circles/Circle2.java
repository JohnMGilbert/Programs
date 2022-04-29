package edu.nmsu.cs.circles;

public class Circle2 extends Circle
{

	public Circle2(double x, double y, double radius)
	{
		super(x, y, radius); //Fixed bug, x and y were switched
	}

	public boolean intersects(Circle other)
	{
		//Fixed intersects to actually include if a circle is touching as well.

		double squaredDistance = (this.center.x - other.center.x) * (this.center.x - other.center.x) + (this.center.y - other.center.y) * (this.center.y - other.center.y);
		double radiusSquared = (this.radius + other.radius)*(this.radius + other.radius);
		if (squaredDistance == radiusSquared)
			return true;
		else if (squaredDistance > radiusSquared)
			return false;
		else
			return true;
	}

}
