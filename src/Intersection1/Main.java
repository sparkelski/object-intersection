package Intersection1;

// main class to implement test cases
public class Main {
    public static void main(String[] args) {
        
        // Test Point-Point intersection
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 2);
        System.out.println("Point p1 intersects Point p2: " + p1.intersect(p2) + " " + p2.intersect(p1)); // Expected: true
        System.out.println("Point p1 intersects Point p3: " + p1.intersect(p3) + " " + p3.intersect(p1)); // Expected: false

        // Test Point-LineSeg intersection
        Point p4 = new Point(2, 2);
        Point p5 = new Point(5, 5);
        LineSeg l1 = new LineSeg(p4, p5, false);
        Point p6 = new Point(3, 3);
        Point p7 = new Point(6, 6);
        System.out.println("Point p6 intersects LineSeg l1: " + p6.intersect(l1) + " " + l1.intersect(p6)); // Expected: true
        System.out.println("Point p7 intersects LineSeg l1: " + p7.intersect(l1) + " " + l1.intersect(p7)); // Expected: false

        // Test LineSeg-LineSeg intersection
        LineSeg l2 = new LineSeg(new Point(0, 0), new Point(4, 4), false);
        LineSeg l3 = new LineSeg(new Point(4, 0), new Point(0, 4), false);
        LineSeg l4 = new LineSeg(new Point(5, 5), new Point(6, 6), false);
        System.out.println("LineSeg l2 intersects LineSeg l3: " + l2.intersect(l3) + " " + l3.intersect(l2)); // Expected: true
        System.out.println("LineSeg l2 intersects LineSeg l4: " + l2.intersect(l4) + " " + l4.intersect(p2)); // Expected: false

        // Test Point-Rectangle intersection
        Rectangle r1 = new Rectangle(new Point(0, 0), new Point(0, 4), new Point(4, 4), new Point(4, 0));
        Point p8 = new Point(2, 2);
        Point p9 = new Point(5, 5);
        System.out.println("Point p8 intersects Rectangle r1: " + p8.intersect(r1) + " " + r1.intersect(p8)); // Expected: true
        System.out.println("Point p9 intersects Rectangle r1: " + p9.intersect(r1) + " " + r1.intersect(p9)); // Expected: false

        // Test LineSeg-Rectangle intersection
        LineSeg l5 = new LineSeg(new Point(-1, 1), new Point(1, -1), false);
        LineSeg l6 = new LineSeg(new Point(5, 5), new Point(6, 6), false);
        System.out.println("LineSeg l5 intersects Rectangle r1: " + l5.intersect(r1) + " " + r1.intersect(l5)); // Expected: true
        System.out.println("LineSeg l6 intersects Rectangle r1: " + l6.intersect(r1) + " " + r1.intersect(l6)); // Expected: false

        // Test Rectangle-Rectangle intersection
        Rectangle r2 = new Rectangle(new Point(3, 3), new Point(3, 5), new Point(5, 5), new Point(5, 3));
        Rectangle r3 = new Rectangle(new Point(6, 6), new Point(6, 8), new Point(8, 8), new Point(8, 6));
        System.out.println("Rectangle r1 intersects Rectangle r2: " + r1.intersect(r2) + " " + r2.intersect(r1)); // Expected: true
        System.out.println("Rectangle r1 intersects Rectangle r3: " + r1.intersect(r3) + " " + r3.intersect(r1)); // Expected: false

        // Test Point-Circle intersection
        Circle c1 = new Circle(new Point(0, 0), 5);
        Point p10 = new Point(3, 4);
        Point p11 = new Point(6, 8);
        System.out.println("Point p10 intersects Circle c1: " + p10.intersect(c1) + " " + c1.intersect(p10)); // Expected: true
        System.out.println("Point p11 intersects Circle c1: " + p11.intersect(c1) + " " + c1.intersect(p11)); // Expected: false

        // Test LineSeg-Circle intersection
        LineSeg l7 = new LineSeg(new Point(-6, -6), new Point(6, 6), false);
        LineSeg l8 = new LineSeg(new Point(6, 6), new Point(10, 10), false);
        System.out.println("LineSeg l7 intersects Circle c1: " + l7.intersect(c1) + " " + c1.intersect(l7)); // Expected: true
        System.out.println("LineSeg l8 intersects Circle c1: " + l8.intersect(c1) + " " + c1.intersect(l8)); // Expected: false

        // Test Rectangle-Circle intersection
        Rectangle r4 = new Rectangle(new Point(-4, -4), new Point(-4, 4), new Point(4, 4), new Point(4, -4));
        Rectangle r5 = new Rectangle(new Point(6, 6), new Point(6, 8), new Point(8, 8), new Point(8, 6));
        System.out.println("Rectangle r4 intersects Circle c1: " + r4.intersect(c1) + " " + c1.intersect(r4)); // Expected: true
        System.out.println("Rectangle r5 intersects Circle c1: " + r5.intersect(c1) + " " + c1.intersect(r5)); // Expected: false

        // Test Circle-Circle intersection
        Circle c2 = new Circle(new Point(3, 3), 4);
        Circle c3 = new Circle(new Point(10, 10), 2);
        System.out.println("Circle c1 intersects Circle c2: " + c1.intersect(c2) + " " + c2.intersect(c1)); // Expected: true
        System.out.println("Circle c1 intersects Circle c3: " + c1.intersect(c3) + " " + c3.intersect(c1)); // Expected: false

        // Display number of instances for each class
        System.out.println("Total Point instances: " + p1.getNumOfInstances());
        System.out.println("Total LineSeg instances: " + l1.getNumOfInstances());
        System.out.println("Total Rectangle instances: " + r1.getNumOfInstances());
        System.out.println("Total Circle instances: " + c1.getNumOfInstances());

        // Create two new points  
        Point p1_l1 = new Point();
        Point p2_l1 = new Point(4, 4);

        // Create a line segment using the two points 
        LineSeg example1 = new LineSeg(p1_l1, p2_l1, false);

        // Create four new points (corners of the rectangle) 
        Point p1_r1 = new Point(-4, -4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(4, 4);

        // Create a new rectangle using the four points 
        Rectangle example2 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        // Check the intersection status between the line segment l1 and the rectangle r1  
        // Store the result (true/false) in the variable status
        boolean status_r1_intersects_l1 = example1.intersect(example2);
        boolean status_l1_intersects_r1 = example2.intersect(example2);

        // Print out the result of the intersection 
        System.out.println("Does LineSeg l1 intersect Rectangle r1? " + status_r1_intersects_l1);
        System.out.println("Does Rectangle r1 intersect LineSeg l1? " + status_l1_intersects_r1);
    }
}
