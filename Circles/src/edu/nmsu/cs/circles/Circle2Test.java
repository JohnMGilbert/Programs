package edu.nmsu.cs.circles;

/***
 * Example JUnit testing class for Circle2 (and Circle)
 *
 * - must have your classpath set to include the JUnit jarfiles - to run the test do: java
 * org.junit.runner.JUnitCore Circle2Test - note that the commented out main is another way to run
 * tests - note that normally you would not have print statements in a JUnit testing class; they are
 * here just so you see what is happening. You should not have them in your test cases.
 ***/

import org.junit.*;

import edu.nmsu.cs.circles.Circle2;
import edu.nmsu.cs.circles.Point;

public class Circle2Test
{
	// Data you need for each test case
	private Circle2 Circle2;

	//
	// Stuff you want to do before each test case
	//
	@Before
	public void setup()
	{
		System.out.println("\nTest starting...");
		Circle2 = new Circle2(1, 2, 3);
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
	 * Test case of intersection if circles are not touching.
	 */
	@Test
	public void testNoIntersction() {
		System.out.println("Running test: Circles are not touching");
		System.out.println("\tNext to each other");
		Circle2 cA = new Circle2(0, 0, 10);
		Circle2 cB = new Circle2(30, 30, 10);
		Assert.assertFalse(cA.intersects(cB));
		Assert.assertFalse(cB.intersects(cA));

		System.out.println("\tAlmost touching");
		cA = new Circle2(1, 10, 2.9999999999);
		cB = new Circle2(1, 5, 2);
		Assert.assertFalse(cA.intersects(cB));
		Assert.assertFalse(cB.intersects(cA));

		cA = new Circle2(16, 128, 4);
		cB = new Circle2(23.45, 121.6, 5);
		Assert.assertFalse(cA.intersects(cB));
		Assert.assertFalse(cB.intersects(cA));
	}

	/**
	 * Test circle intersection if circles are perfectly overlapping.
	 */
	@Test
	public void testInterectionOnOverlap() {
		System.out.println("Running Test: Interesction on overlap");
		Circle2 cA = new Circle2(0, 0, 10);
		Circle2 cB = new Circle2(0, 0, 10);
		Assert.assertTrue(cA.intersects(cB));
		Assert.assertTrue(cB.intersects(cA));
	}

	/**
	 * Test if circle interection is true if it interects at one point
	 */
	@Test
	public void testInteresctionAtOnePoint() {
		System.out.println("Running Test: Interesction at one point");
		Circle2 cA = new Circle2(0, 0, 3);
		Circle2 cB = new Circle2(7, 0, 4);
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
		p = Circle2.moveBy(1, 1);
		Assert.assertTrue(p.x == 2 && p.y == 3);
	}

	//
	// Test a simple negative move
	//
	@Test
	public void simpleMoveNeg()
	{
		Point p;
		System.out.println("Running test simpleMoveNeg.");
		p = Circle2.moveBy(-1, -1);
		Assert.assertTrue(p.x == 0 && p.y == 1);
	}

	/**
	 * Test no move to the same position (no move)
	 */
	// @Test
	// public void moveToSamePosition() {
	// 	Point p;
	// 	Point q;
	// 	System.out.println("Running test: move to same position.");
	// 	p = Circle2.moveBy(0, 0);
	// 	Assert.assertTrue(p.x == 0 && p.y == 0);
	// }

	/**
	 * Test that cicle scales
	 */
	// @Test
	// public void testCirlceScale() {
	// 	Circle2 cA = new Circle2(0, 0, 10);
	// 	cA.scale(10);
	// 	Assert.assertTrue(cA.center.x == 0 && cA.center.y == 0);
	// }

	/***
	 * NOT USED public static void main(String args[]) { try { org.junit.runner.JUnitCore.runClasses(
	 * java.lang.Class.forName("Circle2Test")); } catch (Exception e) { System.out.println("Exception:
	 * " + e); } }
	 ***/

}
