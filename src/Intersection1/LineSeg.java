package Intersection1;

// LineSeg class with superclass AbstarctShape and interface CollisionDetector
public class LineSeg extends AbstractShape implements CollisionDetector {

    // a lineseg must have a begin and end value whcih are points
    private Point begin;
    private Point end;

    // count the number of object instances for the subclass
    private static int numberOfInstances = 0;

    // called constructor
    public LineSeg(Point b, Point e, boolean temp) {
        this.begin = b;
        this.end = e;
        // if not temporary, increment instances
        if (!temp) {
            numberOfInstances++;
        }
    }

    // begin getter
    public Point getBegin() {
        return begin;
    }

    // end getter
    public Point getEnd() {
        return end;
    }

    // instances getter
    public int getNumOfInstances() {
        return numberOfInstances;
    }

    // intersection methods
    // lineseg-point intersection
    // redirects to Point's intersection method
    public boolean intersect(Point s) {
        return s.intersect(this);
    }

    // lineseg-lineseg intersection
    public boolean intersect(LineSeg s) {

        // calculate the denominator for the intersection formulas
        float denom = (this.end.getX() - this.begin.getX()) * (s.getEnd().getY() - s.getBegin().getY()) - 
                      (this.end.getY() - this.begin.getY()) * (s.getEnd().getX() - s.getBegin().getX());

        // if the denominator is 0, the lines are parallel
        if (denom == 0) {
            return false;
        }

        // calculate the parameter ua, which represents where the intersection occurs on this line segment
        float ua = ((s.getEnd().getX() - s.getBegin().getX()) * (this.begin.getY() - s.getBegin().getY()) - 
                    (s.getEnd().getY() - s.getBegin().getY()) * (this.begin.getX() - s.getBegin().getX())) / denom;

        // calculate the parameter ub, which represents where the intersection occurs on the other line segment
        float ub = ((this.end.getX() - this.begin.getX()) * (this.begin.getY() - s.getBegin().getY()) - 
                    (this.end.getY() - this.begin.getY()) * (this.begin.getX() - s.getBegin().getX())) / denom;

        // check if both ua and ub lie between 0 and 1, meaning the intersection occurs within the bounds of both segments
        return (ua >= 0 && ua <= 1) && (ub >= 0 && ub <= 1);
    }

    // lineseg-rectangle intersection
    public boolean intersect(Rectangle s) {
        // create line segments based on the sides of the rectangle
        LineSeg[] sides = {
            new LineSeg(s.getBottomLeft(), s.getBottomRight(), true),
            new LineSeg(s.getBottomRight(), s.getTopRight(), true),
            new LineSeg(s.getTopRight(), s.getTopLeft(), true),
            new LineSeg(s.getTopLeft(), s.getBottomLeft(), true)
        };
        // iterate over the sides / line segments and calculate lineseg-lineseg intersection
        for (LineSeg side : sides) {
            if (this.intersect(side)) return true;
        }
        return false;
    }

    // lineseg-circle intersection
    public boolean intersect(Circle s) {
        // calculate the difference in x and y coordinates between the end and beginning of the segment
        float dx = this.end.getX() - this.begin.getX();
        float dy = this.end.getY() - this.begin.getY();

        // calculate the squared length of the line segment
        float lengthSquared = dx * dx + dy * dy;

        // calculate t to find the closest point on the line segment to the circle's center
        // t represents the relative position of the closest point along the segment (0 <= t <= 1)
        float t = ((s.getCenter().getX() - this.begin.getX()) * dx + 
                  (s.getCenter().getY() - this.begin.getY()) * dy) / lengthSquared;

        // force `t` to be between 0 and 1 to ensure the closest point lies on the segment
        t = Math.max(0, Math.min(1, t));

        // calculate the coordinates of the closest point on the line segment to the circle's center
        // start with beginning point and increment with slope
        float closestX = this.begin.getX() + t * dx;
        float closestY = this.begin.getY() + t * dy;

        // calculate the distance from the circle's center to the closest point
        float distX = closestX - s.getCenter().getX();
        float distY = closestY - s.getCenter().getY();

        // intersects if the distance squared is less than or equal to the radius squared (equation of circle)
        return distX * distX + distY * distY <= s.getRadius() * s.getRadius();
    }
}
