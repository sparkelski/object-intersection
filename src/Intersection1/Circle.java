package Intersection1;

// rectangle class with superclass AbstarctShape and interface CollisionDetector
public class Circle extends AbstractShape implements CollisionDetector {

    // a circle must have a center and a radius
    private Point center;
    private float radius;

    // count the number of object instances for the subclass
    private static int numberOfInstances = 0;

    // called constructor
    public Circle(Point c, float r) throws ShapeArgumentException {
    	
    	// throws exception if out of bounds
        if (r <= 0) {
            throw new ShapeArgumentException("ShapeArgumentException in constructing Circle: radius must be greater than zero.");
        }
        
        this.center = c;
        this.radius = r;
        numberOfInstances++;
    }

    // Center getter
    public Point getCenter() {
        return center;
    }

    // Radius getter
    public float getRadius() {
        return radius;
    }

    // instances getter
    public int getNumOfInstances() {
        return numberOfInstances;
    }

    // intersection methods
    // circle-point intersection
    // redirects to Point's intersection method
    public boolean intersect(Point s) {
        return s.intersect(this);
    }

    // circle-lineseg intersection
    // redirects to LineSeg's intersection method
    public boolean intersect(LineSeg s) {
        return s.intersect(this);
    }

    // circle-rectangle intersection
    // redirects to Rectangle's intersection method
    public boolean intersect(Rectangle s) {
        return s.intersect(this);
    }

    // cirlce-circle intersection
    public boolean intersect(Circle s) {
        // use equation of circle to check if distance between centers
        // is less than or equal to the sum of radii
        float dx = this.center.getX() - s.getCenter().getX();
        float dy = this.center.getY() - s.getCenter().getY();
        float distanceSquared = dx * dx + dy * dy;

        float radiusSum = this.radius + s.getRadius();
        return distanceSquared <= radiusSum * radiusSum;
    }
}
