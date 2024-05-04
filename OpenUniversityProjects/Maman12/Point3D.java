package Maman12; //todo sh -  remove this 

//todo sh - check aliasing 
/**
 * This class represents a three-dimensional point with x, y, and z coordinates.
 */
public class Point3D {

    private double _x;
    private double _y;
    private double _z;

    static final double DEFAULT_COORDINATION_VALUE = 0;

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
     * Creates a new Point3D object with all coordinates initialized to 0.
     */
    public Point3D() {
        this(DEFAULT_COORDINATION_VALUE, DEFAULT_COORDINATION_VALUE, DEFAULT_COORDINATION_VALUE);
    }

    /**
     * Creates a new Point3D object by copying the coordinates from another Point3D
     * object.
     * 
     * @param other The Point3D object to initialize this object with its values.
     */
    public Point3D(Point3D other) {
        this(other._x, other._y, other._z);
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
     * Gets the y-coordinate of the point.
     * 
     * @return The y-coordinate.
     */
    public double getY() {
        return _y;
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
     * Sets the x-coordinate of the point.
     * 
     * @param num The new x-coordinate.
     */
    public void setX(double num) {
        _x = num;
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
        return _x == other._x && _y == other._y && _z == other._z;
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
        double dx = _x - p.getX();
        double dy = _y - p.getY();
        double dz = _z - p.getZ();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
    }

    /**
     * Checks if this point is above the other point according to z coordination.
     *
     * @param other The point to check whether this point is above it
     * @return true if this point is above the other point, false otherwise
     */
    public boolean isAbove(Point3D other) {
        return _z > other.getZ();
    }

    /**
     * Checks if this point is under the other point according to z coordination.
     *
     * @param other The point to check whether this point is under it.
     * @return true if this point is under the other point, false otherwise.
     */
    public boolean isUnder(Point3D other) {

        // Both points have equal z coordinates
        if (!isAbove(other) && !other.isAbove(this)) {
            return false;
        }

        if (isAbove(other)) {
            return false;
        }

        return true;
    }

    /**
     * Checks if this point is to the left of the other point according to y
     * coordination.
     *
     * @param other The point to check whether this point is left of it
     * @return true if this point is to the left of the other point, false otherwise
     */
    public boolean isLeft(Point3D other) {
        return _y < other.getY();
    }

    /**
     * Checks if this point is to the right of the other point according to y
     * coordination.
     *
     * @param other The point to check whether this point is right of it.
     * @return true if this point is to the right of the other point, false
     *         otherwise.
     */
    public boolean isRight(Point3D other) {

        // Both points have equal y coordinates
        if (!isLeft(other) && !other.isLeft(this)) {
            return false;
        }

        if (isLeft(other)) {
            return false;
        }

        return true;
    }

    /**
     * Checks if this point is behind the other point according to x coordination.
     *
     * @param other The point to check whether this point is behind it.
     * @return true if this point is behind the other point, false otherwise.
     */
    public boolean isBehind(Point3D other) {
        return _x < other.getX();
    }

    /**
     * Checks if this point is in front of the other point according to x
     * coordination.
     *
     * @param other The point to check whether this point is in front of it.
     * @return true if this point is in front of the other point, false otherwise.
     */
    public boolean isInFrontOf(Point3D other) {

        // Both points have equal x coordinates
        if (!isBehind(other) && !other.isBehind(this)) {
            return false;
        }

        if (isBehind(other)) {
            return false;
        }

        return true;
    }

    /**
     * Moves the point by specified amounts along each axis.
     *
     * @param dx The amount to move along the x-axis.
     * @param dy The amount to move along the y-axis.
     * @param dz The amount to move along the z-axis.
     */
    public void move(double dx, double dy, double dz) {
        _x += dx;
        _y += dy;
        _z += dz;
    }

    /**
     * Return a string representation of this Point3D object's coordinates.
     * 
     * @return a string representation of this Point3D object's coordinates.
     */
    public String toString() {
        return "(" + _x + "," + _y + "," + _z + ")";
    }
}
