package edu.nmsu.cs.circles;

/***
 * Example JUnit testing class for Circle1 (and Circle)
 *
 * - must have your classpath set to include the JUnit jarfiles - to run the test do: java
 * org.junit.runner.JUnitCore Circle1Test - note that the commented out main is another way to run
 * tests - note that normally you would not have print statements in a JUnit testing class; they are
 * here just so you see what is happening. You should not have them in your test cases.
 ***/

import org.junit.*;

import edu.nmsu.cs.circles.Circle1;
import edu.nmsu.cs.circles.Point;

public class Circle1Test
{
	// Data you need for each test case
	private Circle1 circle1;

	//
	// Stuff you want to do before each test case
	//
	@Before
	public void setup()
	{
		System.out.println("\nTest starting...");
		circle1 = new Circle1(1, 2, 3);
	}

	//
	// Stuff you want to do after each test case
	//
	@After
	public void teardown()
	{
		System.out.println("\nTest finished.");
	}

	/**
	 * Test scale, that circle gets bigger
	 */
	@Test
	public void testScaleBigger() {
		System.out.println("Running Test: scales bigger properly");
		Circle1 cA = new Circle1(0,0,10);
		Circle1 cB = new Circle1(0, 0, 10);
		cA.radius = cA.scale(1.5);
		Assert.assertFalse(cA.radius == cB.radius);
		Assert.assertTrue(cA.radius > cB.radius);
	}

	/**
	 * Test scale, that circle gets smaller
	 */
	@Test
	public void testScaleSmaller() {
		System.out.println("Running Test: scales smaller properly");
		Circle1 cA = new Circle1(0,0,10);
		Circle1 cB = new Circle1(0, 0, 10);
		cA.radius = cA.scale(0.5);
		Assert.assertFalse(cA.radius == cB.radius);
		Assert.assertTrue(cA.radius < cB.radius);
	}

	/**
	 * Test scale with negative number
	 */
	@Test
	public void testScaleWithNeg() {
		System.out.println("Running test: scales with negative number");
		Circle1 cA = new Circle1(0,0,10);
		Circle1 cB = new Circle1(0, 0, 10);
		cA.radius = cA.scale(-0.5);
		Assert.assertFalse(cA.radius == cB.radius);
		Assert.assertTrue(cA.radius < cB.radius);
	}

	/**
	 * Test case of intersection if circles are not touching.
	 */
	@Test
	public void testNoIntersction() {
		System.out.println("Running test: Circles are not touching");
		System.out.println("\tNext to each other");
		Circle1 cA = new Circle1(0, 0, 10);
		Circle1 cB = new Circle1(30, 30, 10);
		Assert.assertFalse(cA.intersects(cB));
		Assert.assertFalse(cB.intersects(cA));

		System.out.println("\tAlmost touching");
		cA = new Circle1(1, 10, 2.9999999999);
		cB = new Circle1(1, 5, 2);
		Assert.assertFalse(cA.intersects(cB));
		Assert.assertFalse(cB.intersects(cA));

		cA = new Circle1(16, 128, 4);
		cB = new Circle1(23.45, 121.6, 5);
		Assert.assertFalse(cA.intersects(cB));
		Assert.assertFalse(cB.intersects(cA));
	}

	/**
	 * Test circle intersection if circles are perfectly overlapping.
	 */
	@Test
	public void testInterectionOnOverlap() {
		System.out.println("Running Test: Interesction on overlap");
		Circle1 cA = new Circle1(0, 0, 10);
		Circle1 cB = new Circle1(0, 0, 10);
		Assert.assertTrue(cA.intersects(cB));
		Assert.assertTrue(cB.intersects(cA));
	}

	/**
	 * Test if circle interection is true if it interects at one point
	 */
	@Test
	public void testInteresctionAtOnePoint() {
		System.out.println("Running Test: Interesction at one point");
		Circle1 cA = new Circle1(0, 0, 3);
		Circle1 cB = new Circle1(7, 0, 4);
		Assert.assertTrue(cA.intersects(cB));
		Assert.assertTrue(cB.intersects(cA));
	}

	/**
	 * Test intersection at multiple points
	 */
	@Test
	public void testTwoPointIntersection(){
		System.out.println("Running Test: Interesction at two points");
		Circle1 cA = new Circle1(0, 0, 10);
		Circle1 cB = new Circle1(5, 0, 10);
		Assert.assertTrue(cA.intersects(cB));
		Assert.assertTrue(cB.intersects(cA));
	}

	//
	// Test a simple positive move
	//
	@Test
	public void simpleMove()
	{
		Point p;
		System.out.println("Running test simpleMove.");
		p = circle1.moveBy(1, 2);
		Assert.assertTrue(p.x == 2 && p.y == 4);
	}

	//
	// Test a simple negative move
	//
	@Test
	public void simpleMoveNeg()
	{
		Point p;
		System.out.println("Running test simpleMoveNeg.");
		p = circle1.moveBy(-1, -2);
		Assert.assertTrue(p.x == 0 && p.y == 0);
	}

	/**
	 * Test no move to the same position (no move)
	 */
	@Test
	public void moveToSamePosition() {
		Point p;
		System.out.println("Running test: move to same position.");
		p = circle1.moveBy(0, 0);
		Assert.assertTrue(p.x == 1 && p.y == 2);
	}

	/**
	 * Test that cicle scales and doesn't change center
	 */
	@Test
	public void testCirlceScale() {
		System.out.println("Running Test: Circle center does not change with scaling ");
		Circle1 cA = new Circle1(0, 0, 10);
		cA.scale(10);
		Assert.assertTrue(cA.center.x == 0 && cA.center.y == 0);
	}

	/***
	 * NOT USED public static void main(String args[]) { try { org.junit.runner.JUnitCore.runClasses(
	 * java.lang.Class.forName("Circle1Test")); } catch (Exception e) { System.out.println("Exception:
	 * " + e); } }
	 ***/

}
