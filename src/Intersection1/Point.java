package Intersection1;

// Point class with superclass AbstarctShape and interface CollisionDetector
public class Point extends AbstractShape implements CollisionDetector {

    // a point must have an x and y value
    private float x;
    private float y;

    // count the number of object instances for the subclass
    private static int numberOfInstances = 0;

    // initial constructor
    public Point() {
        this.x = 0;
        this.y = 0;
        numberOfInstances++;
    }

    // called constructor
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        numberOfInstances++;
    }

    // x getter
    public float getX() {
        return x;
    }

    // y getter
    public float getY() {
        return y;
    }

    // instances getter
    public int getNumOfInstances() { 
        return numberOfInstances;
    }

    // intersection methods
    // point-point intersection
    // only have to check if point = point
    public boolean intersect(Point s) {
        return this.x == s.getX() && this.y == s.getY();
    }

    // point-lineseg intersection
    public boolean intersect(LineSeg s) {
        // check collinearity by calculating the cross product using the start point and given point
        float crossProduct = (s.getEnd().getY() - s.getBegin().getY()) * (this.x - s.getBegin().getX()) - 
                             (s.getEnd().getX() - s.getBegin().getX()) * (this.y - s.getBegin().getY());

        // if the cross product is not close to zero, the point is not collinear
        if (Math.abs(crossProduct) > 0.0001) return false;

        // calculate the dot product to check if the point lies between the start and end of the segment
        // again using the start point and given point
        float dotProduct = (this.x - s.getBegin().getX()) * (s.getEnd().getX() - s.getBegin().getX()) + 
                           (this.y - s.getBegin().getY()) * (s.getEnd().getY() - s.getBegin().getY());

        // if the dot product is negative, the point is "behind" the start of the segment
        if (dotProduct < 0) return false;

        // calculate the squared length of the line segment to compare with the dot product
        float squaredLength = (s.getEnd().getX() - s.getBegin().getX()) * (s.getEnd().getX() - s.getBegin().getX()) + 
                              (s.getEnd().getY() - s.getBegin().getY()) * (s.getEnd().getY() - s.getBegin().getY());

        // check if the point is beyond or within the bounds of the line segement by using the dot product
        return dotProduct <= squaredLength;
}

    // point-rectangle intersection
    public boolean intersect(Rectangle s) {
        // check if the point is within the rectangle's bounds
        return (s.getBottomLeft().getX() <= this.x && this.x <= s.getTopRight().getX() &&
                s.getBottomLeft().getY() <= this.y && this.y <= s.getTopRight().getY());
    }

    // point-circle intersection
    public boolean intersect(Circle s) {
        // use equation of a circle to determine if a point intersects
        float dx = this.x - s.getCenter().getX();
        float dy = this.y - s.getCenter().getY();
        return dx * dx + dy * dy <= s.getRadius() * s.getRadius();
    }
}
