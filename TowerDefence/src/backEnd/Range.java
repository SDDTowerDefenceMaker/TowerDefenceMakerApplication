package backEnd;

/**
 * A region specified its upperleft vertex and lowerright vertex
 */
public class Range {
    private Coordinate upperLeft = new Coordinate();
    private Coordinate lowerRight = new Coordinate();
    private int area = 0; 
    
    // CONSTRUCTORS
    public Range() {
        this.upperLeft = new Coordinate();
        this.lowerRight = new Coordinate();
        this.area = 0; 
    }
    public Range(Coordinate ul, Coordinate lr) {
        this.upperLeft = ul;
        this.lowerRight = lr;
        computeArea();
    }
    public Range(Range r) {
        this.upperLeft = r.getUpperLeft();
        this.lowerRight = r.getLowerRight();
        this.area = r.getArea();
    }

    // ACCESSORS
    public Coordinate getUpperLeft() {
        Coordinate ul = new Coordinate(this.upperLeft);
        return ul;
    }
    public Coordinate getLowerRight() {
        Coordinate lr = new Coordinate(this.lowerRight);
        return lr;
    }
    public int getArea() {
        int a = area;
        return a;
    }
    public boolean equals(Range r) {
        return( (r.getUpperLeft()).equals(this.upperLeft) &&
                (r.getLowerRight()).equals(this.lowerRight) &&
                (r.getArea()) == (this.area) );
    }

    // MODIFIERS
    public void setUpperLeft(Coordinate ul) {
        // if ul.isUpperLeft(lowerRight):
        this.upperLeft = ul;
        computeArea();
    }
    public void setLowerRight(Coordinate lr) {
        // if lr.isLowerRight(upperLeft):
        this.lowerRight = lr;
        computeArea();
    }
    public void computeArea() {
        this.area = ( (this.lowerRight.getX() - this.upperLeft.getX())
                    * (this.upperLeft.getY() - this.lowerRight.getY()) );
    }
    public void copyRange(Range r) {
        this.upperLeft = r.getUpperLeft();
        this.lowerRight = r.getLowerRight();
        this.area = r.getArea();
    }
    public boolean isIn(Range position) {
        return ( (position.getUpperLeft().getX() >= this.upperLeft.getX())
              && (position.getLowerRight().getX() <= this.lowerRight.getX())
              && (position.getLowerRight().getY() >= this.lowerRight.getY())
              && (position.getUpperLeft().getY() <= this.upperLeft.getY()) );
    }

}