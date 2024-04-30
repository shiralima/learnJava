package Maman12; //todo sh -  remove this 

public class Point3D {

    private double _x;
    private double _y;
    private double _z;

    static final double DEFAULT_VALUE = 0;

    // Constructors:

    /**
     * Creates a new Point3D object with specified coordinates.
     * 
     * @param x - The x-coordinate of the point.
     * @param y - The y-coordinate of the point.
     * @param z - The z-coordinate of the point.
     */
    public Point3D(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    /**
     * Creates a new Point3D object with all coordinates initialized to zero.
     */
    public Point3D() {
        this(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    /**
     * Creates a new Point3D object by copying the coordinates from another Point3D
     * object.
     * 
     * @param other The Point3D object to initialize this object with its values.
     */
    public Point3D(Point3D other) {
        // todo sh check not null
        this(other.getX(), other.getY(), other.getZ());
    }

    // Getters and Setters:

    /**
     * Gets the x-coordinate of the point.
     * 
     * @return The x-coordinate.
     */
    public double getX() {
        return _x;
    }

    /**
     * Sets the x-coordinate of the point.
     * 
     * @param num The new x-coordinate.
     */
    public void setX(double num) {
        _x = num;
    }

    /**
     * Gets the y-coordinate of the point.
     * 
     * @return The y-coordinate.
     */
    public double getY() {
        return _y;
    }

    /**
     * Sets the y-coordinate of the point.
     * 
     * @param num The new y-coordinate.
     */
    public void setY(double num) {
        _y = num;
    }

    /**
     * Gets the z-coordinate of the point.
     * 
     * @return The z-coordinate.
     */
    public double getZ() {
        return _z;
    }

    /**
     * Sets the z-coordinate of the point.
     * 
     * @param z The new z-coordinate.
     */
    public void setZ(double num) {
        _z = num;
    }

    /**
     * Check if this object is equal to another Point3D object.
     * 
     * @param other The Point3D object to compare with this Point3D object.
     * @return true if the two objects have the same coordinates, false otherwise.
     */
    public boolean equals(Point3D other) {
        return _x == other.getX() && _y == other.getY() && _z == other.getZ();
    }

    /**
     * Return a string representation of this Point3D object's coordinates.
     * 
     * @return a string representation of this Point3D object's coordinates.
     */
    public String toString() {
        return "(" + _x + "," + _y + "," + _z + ")";
    }

    /**
     * Calculates the distance between this Point3D object and another Point3D
     * object.
     * 
     * @param p The Point3D object to which the distance is calculated.
     * @return The distance between this Point3D object and the specified Point3D
     *         object.
     */
    public double distance(Point3D p) {
        return Math.sqrt(Math.pow((_x - p.getX()), 2) + Math.pow((_y - p.getY()), 2) + Math.pow((_z - p.getZ()), 2));
    }

    public boolean isAbove(Point3D other) {
        return _z > other.getZ();
    }

    public boolean isUnder(Point3D other) {

        System.out.println("this in isUnder" + this);
        System.out.println("other in isUnder" + other);

        if (isAbove(other) && isAbove(this)) {
            System.out.println("isAbove other" + isAbove(other));
            System.out.println("isAbove this" + isAbove(this));
            System.out.println("isUnder false inside equals");
            return false; // both equals
        }

        if (isAbove(other)) {
            System.out.println("isUnder false inside isAbove other");
            return false;
        }

        return true;
    }

    public boolean isLeft(Point3D other) {
        return _y < other.getY();
    }

    public boolean isRight(Point3D other) {

        if (isLeft(other) && isLeft(this)) {
            return false; // both equals
        }

        if (isLeft(other)) {
            return false;
        }

        return true;
    }

    public boolean isBehind(Point3D other) {
        return _x < other.getX();
    }

    public boolean isInFrontOf(Point3D other) {

        if (isBehind(other) && isBehind(this)) {
            return false; // both equals
        }

        if (isBehind(other)) {
            return false;
        }

        return true;
    }

    public void move(double dx, double dy, double dz) {
        setX(_x + dx);
        setY(_y + dy);
        setZ(_z + dz);
    }

}
