package Intersection1;

// Rectangle class with superclass AbstarctShape and interface CollisionDetector
public class Rectangle extends AbstractShape implements CollisionDetector {
    
    // a rectangle must have 4 points
    private Point bottomLeft;
    private Point topLeft;
    private Point topRight;
    private Point bottomRight;

    // count the number of object instances for the subclass
    private static int numberOfInstances = 0;
    
    // called constructor
    public Rectangle(Point bl, Point tl, Point tr, Point br) throws ShapeArgumentException {
    	
    	// throws exception if out of bounds
    	// left >= right || bottom >= top
        if (bl.getX() >= br.getX() || bl.getY() >= tr.getY()) {
            throw new ShapeArgumentException("ShapeArgumentException in constructing Rectangle: invalid boundaries.");
        }
        
        this.bottomLeft = bl;
        this.topLeft = tl;
        this.topRight = tr;
        this.bottomRight = br;
        numberOfInstances++;
    }

    // BottomLeft getter
    public Point getBottomLeft() {
        return bottomLeft;
    }

    // TopLeft getter
    public Point getTopLeft() {
        return topLeft;
    }

    // TopRight getter
    public Point getTopRight() {
        return topRight;
    }

    // BottomRight getter
    public Point getBottomRight() {
        return bottomRight;
    }

    // instances getter
    public int getNumOfInstances() {
        return numberOfInstances;
    }

    // intersection methods
    // rectangle-point intersection
    // redirects to Point's intersection method
    public boolean intersect(Point s) {
        return s.intersect(this);
    }

    // rectangle-lineseg intersection
    // redirects to LineSeg's intersection method
    public boolean intersect(LineSeg s) {
        return s.intersect(this);
    }

    // rectangle-rectangle intersection
    // check rectangle bounds, false if everything on the first rectangle is outside of the second rectangle
    public boolean intersect(Rectangle s) {
        return !(s.getBottomLeft().getX() > this.getTopRight().getX() ||
                 s.getTopRight().getX() < this.getBottomLeft().getX() ||
                 s.getBottomLeft().getY() > this.getTopRight().getY() ||
                 s.getTopRight().getY() < this.getBottomLeft().getY());
    }

    // rectangle-circle intersection
    public boolean intersect(Circle s) {
        // find the closest point on the rectangle to the circle center and check distance
        float closestX = Math.max(this.getBottomLeft().getX(), Math.min(s.getCenter().getX(), this.getTopRight().getX()));
        float closestY = Math.max(this.getBottomLeft().getY(), Math.min(s.getCenter().getY(), this.getTopRight().getY()));

        // equation of a circle
        float dx = closestX - s.getCenter().getX();
        float dy = closestY - s.getCenter().getY();
        return dx * dx + dy * dy <= s.getRadius() * s.getRadius();
    }
}
