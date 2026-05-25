package Intersection1;

// interface for collision detection between shapes
public interface CollisionDetector {

    // check if a shape intersects with a Point
    boolean intersect(Point s);

    // check if a shape intersects with a LineSeg
    boolean intersect(LineSeg s);

    // check if a shape intersects with a Rectangle
    boolean intersect(Rectangle s);

    // check if a shape intersects with a Circle
    boolean intersect(Circle s);
}
