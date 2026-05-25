package Intersection1;

// JUnit java file to test cases using the JUnit library
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Essentially takes the examples found in the main java file and converts them into separate JUnit test cases (methods)

// This java file also checks the other object's implementation of intersect to
// check if they have the same boolean value as the other object's implementation.

// This file also uses catch and try blocks for every LineSeg, Rectangle,
// and Circle object implementation to check if the bounds are valid or not.

// This JUnit test file should return completely green.
public class A2Test {

    // Test Point-Point intersection
    @Test
    public void testPointIntersectPoint() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 2);
        
        // Self intersection
        assertTrue(p1.intersect(p1), "A point should intersect with itself.");
        assertTrue(p1.intersect(p2), "Point p1 should intersect with Point p2.");
        assertTrue(p2.intersect(p1), "Point p2 should intersect with Point p1.");
        assertFalse(p1.intersect(p3), "Point p1 should not intersect with Point p3.");
        assertFalse(p3.intersect(p1), "Point p3 should not intersect with Point p1.");
    }

    // Test Point-LineSeg intersection
    @Test
    public void testPointIntersectLineSeg() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(5, 5);
        
        LineSeg l1 = null;
        try {
            l1 = new LineSeg(p1, p2, false);
        } catch (ShapeArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        Point p3 = new Point(3, 3);
        Point p4 = new Point(6, 6);
        
        assertTrue(p3.intersect(l1), "Point p3 should intersect with LineSeg l1.");
        assertTrue(l1.intersect(p3), "LineSeg l1 should intersect with Point p3.");
        assertFalse(p4.intersect(l1), "Point p4 should not intersect with LineSeg l1.");
        assertFalse(l1.intersect(p4), "LineSeg l1 should not intersect with Point p4.");
    }

    // Test LineSeg-LineSeg intersection
    @Test
    public void testLineSegIntersectLineSeg() {
        LineSeg l1 = null, l2 = null, l3 = null;
        try {
            l1 = new LineSeg(new Point(0, 0), new Point(4, 4), false);
            l2 = new LineSeg(new Point(4, 0), new Point(0, 4), false);
            l3 = new LineSeg(new Point(5, 5), new Point(6, 6), false);
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }

        // Self intersection
        // A LineSeg shouldn't intersect with itself because
        // they are both parallel to each other
        assertFalse(l1.intersect(l1), "A LineSeg shouldn't intersect with itself.");
        assertTrue(l1.intersect(l2), "LineSeg l1 should intersect with LineSeg l2.");
        assertTrue(l2.intersect(l1), "LineSeg l2 should intersect with LineSeg l1.");
        assertFalse(l1.intersect(l3), "LineSeg l1 should not intersect with LineSeg l3.");
        assertFalse(l3.intersect(l1), "LineSeg l3 should not intersect with LineSeg l1.");
    }

    // Test Point-Rectangle intersection
    @Test
    public void testPointIntersectRectangle() {
    	
        Rectangle r1 = null;
        try {
            r1 = new Rectangle(new Point(0, 0), new Point(0, 4), new Point(4, 4), new Point(4, 0));
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        Point p1 = new Point(2, 2);
        Point p2 = new Point(5, 5);
        
        assertTrue(p1.intersect(r1), "Point p1 should intersect with Rectangle r1.");
        assertTrue(r1.intersect(p1), "Rectangle r1 should intersect with Point p1.");
        assertFalse(p2.intersect(r1), "Point p2 should not intersect with Rectangle r1.");
        assertFalse(r1.intersect(p2), "Rectangle r1 should not intersect with Point p2.");
    }

    // Test LineSeg-Rectangle intersection
    @Test
    public void testLineSegIntersectRectangle() {
    	
        Rectangle r1 = null;
        try {
            r1 = new Rectangle(new Point(0, 0), new Point(0, 4), new Point(4, 4), new Point(4, 0));
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }

        LineSeg l1 = null, l2 = null;
        try {
            l1 = new LineSeg(new Point(-1, 1), new Point(1, -1), false);
            l2 = new LineSeg(new Point(5, 5), new Point(6, 6), false);
        } catch (ShapeArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        assertTrue(l1.intersect(r1), "LineSeg l1 should intersect with Rectangle r1.");
        assertTrue(r1.intersect(l1), "Rectangle r1 should intersect with LineSeg l1.");
        assertFalse(l2.intersect(r1), "LineSeg l2 should not intersect with Rectangle r1.");
        assertFalse(r1.intersect(l2), "Rectangle r1 should not intersect with LineSeg l2.");
    }

    // Test Rectangle-Rectangle intersection
    @Test
    public void testRectangleIntersectRectangle() {
    	
    	Rectangle r1 = null, r2 = null, r3 = null;
        try {
            r1 = new Rectangle(new Point(0, 0), new Point(0, 4), new Point(4, 4), new Point(4, 0));
            r2 = new Rectangle(new Point(3, 3), new Point(3, 5), new Point(5, 5), new Point(5, 3));
            r3 = new Rectangle(new Point(6, 6), new Point(6, 8), new Point(8, 8), new Point(8, 6));
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        // Self intersection
        assertTrue(r1.intersect(r1), "A rectangle should itersect with itself.");
        assertTrue(r1.intersect(r2), "Rectangle r1 should intersect with Rectangle r2.");
        assertTrue(r2.intersect(r1), "Rectangle r2 should intersect with Rectangle r1.");
        assertFalse(r1.intersect(r3), "Rectangle r1 should not intersect with Rectangle r3.");
        assertFalse(r3.intersect(r1), "Rectangle r3 should not intersect with Rectangle r1.");
    }

    // Test Point-Circle intersection
    @Test
    public void testPointIntersectCircle() {
    	
        Circle c1 = null;
        try {
            c1 = new Circle(new Point(0, 0), 5);
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);
        
        assertTrue(p1.intersect(c1), "Point p1 should intersect with Circle c1.");
        assertTrue(c1.intersect(p1), "Circle c1 should intersect with Point p1.");
        assertFalse(p2.intersect(c1), "Point p2 should not intersect with Circle c1.");
        assertFalse(c1.intersect(p2), "Circle c1 should not intersect with Point p2.");
    }

    // Test LineSeg-Circle intersection
    @Test
    public void testLineSegIntersectCircle() {
        
        Circle c1 = null;
        try {
            c1 = new Circle(new Point(0, 0), 5);
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        LineSeg l1 = null, l2 = null;
        try {
            l1 = new LineSeg(new Point(-6, -6), new Point(6, 6), false);
            l2 = new LineSeg(new Point(6, 6), new Point(10, 10), false);
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        assertTrue(l1.intersect(c1), "LineSeg l1 should intersect with Circle c1.");
        assertTrue(c1.intersect(l1), "Circle c1 should intersect with LineSeg l1.");
        assertFalse(l2.intersect(c1), "LineSeg l2 should not intersect with Circle c1.");
        assertFalse(c1.intersect(l2), "Circle c1 should not intersect with LineSeg l2.");
    }

    // Test Rectangle-Circle intersection
    @Test
    public void testRectangleIntersectCircle() {
        
        Circle c1 = null;
        try {
            c1 = new Circle(new Point(0, 0), 5);
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        Rectangle r1 = null, r2 = null;
        try {
            r1 = new Rectangle(new Point(-4, -4), new Point(-4, 4), new Point(4, 4), new Point(4, -4));
            r2 = new Rectangle(new Point(6, 6), new Point(6, 8), new Point(8, 8), new Point(8, 6));
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        assertTrue(r1.intersect(c1), "Rectangle r1 should intersect with Circle c1.");
        assertTrue(c1.intersect(r1), "Circle c1 should intersect with Rectangle r1.");
        assertFalse(r2.intersect(c1), "Rectangle r2 should not intersect with Circle c1.");
        assertFalse(c1.intersect(r2), "Circle c1 should not intersect with Rectangle r2.");
    }

    // Test Circle-Circle intersection
    @Test
    public void testCircleIntersectCircle() {
    	
        Circle c1 = null, c2 = null, c3 = null;
        try {
            c1 = new Circle(new Point(0, 0), 5);
            c2 = new Circle(new Point(3, 3), 4);
            c3 = new Circle(new Point(10, 10), 2);
        } catch (ShapeArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        // Self intersection
        assertTrue(c1.intersect(c1), "A circle should intersect with itself.");
        assertTrue(c1.intersect(c2), "Circle c1 should intersect with Circle c2.");
        assertTrue(c2.intersect(c1), "Circle c2 should intersect with Circle c1.");
        assertFalse(c1.intersect(c3), "Circle c1 should not intersect with Circle c3.");
        assertFalse(c3.intersect(c1), "Circle c3 should not intersect with Circle c1.");
    }
}
