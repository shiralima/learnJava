package Maman12; //todo sh -  remove this 

//todo sh - check aliasing 

public class Box3D {
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;

    static final int DEFAULT_SIZE_VALUE = 1;

    /**
     * Constructs and initializes a box with a default base point and all dimensions
     * to 1.
     */
    public Box3D() {
        _base = new Point3D();
        _length = DEFAULT_SIZE_VALUE;
        _width = DEFAULT_SIZE_VALUE;
        _height = DEFAULT_SIZE_VALUE;
    }

    /**
     * Constructs and initializes a box object from a given base point and 3
     * integers as the dimensions of the Box.
     *
     * @param base   the base point of the box
     * @param length the length of the box
     * @param width  the width of the box
     * @param height the height of the box
     */
    public Box3D(Point3D base, int length, int width, int height) {
        _base = new Point3D(base);
        _length = length > 0 ? length : DEFAULT_SIZE_VALUE;
        _width = width > 0 ? width : DEFAULT_SIZE_VALUE;
        _height = height > 0 ? height : DEFAULT_SIZE_VALUE;
    }

    /**
     * Constructs and initializes a Box3D object from a given Box3D.
     *
     * @param other the box to copy from. Contains the initialization of the base
     *              point and all dimensions.
     */
    public Box3D(Box3D other) {
        _base = new Point3D(other._base);
        _length = other._length;
        _width = other._width;
        _height = other._height;
    }

    // Getters:

    /**
     * Returns the lower-left-front (base) Point3D of the box.
     *
     * @return the base point of the box
     */
    public Point3D getBase() {
        return new Point3D(_base);
    }

    /**
     * Returns the length dimension.
     *
     * @return the length of the box
     */
    public int getLength() {
        return _length;
    }

    /**
     * Returns the width dimension.
     *
     * @return the width of the box
     */
    public int getWidth() {
        return _width;
    }

    /**
     * Returns the height dimension.
     *
     * @return the height of the box
     */
    public int getHeight() {
        return _height;
    }

    // Setters:

    /**
     * Sets the base point of the box.
     *
     * @param p the Point3D to set as the base point
     */
    public void setBase(Point3D p) {
        _base.setX(p.getX());
        _base.setY(p.getY());
        _base.setZ(p.getZ());
    }

    /**
     * Sets the length of the box only if the given value is equal or greater than
     * 1.
     *
     * @param num the length to set
     */

    public void setLength(int num) {
        if (num > 0) {
            _length = num;
        }
    }

    /**
     * Sets the width of the box only if the given value is equal or greater than 1.
     *
     * @param num the width to set
     */
    public void setWidth(int num) {
        if (num > 0) {
            _width = num;
        }
    }

    /**
     * Sets the height of the box only if the given value is equal or greater than
     * 1.
     *
     * @param num the height to set
     */
    public void setHeight(int num) {
        if (num > 0) {
            _height = num;
        }
    }

    public String toString() {
        return "The base point is " + _base.toString() + ", length = " + _length + ", width = " + _width
                + ", height = " + _height;
    }

    /**
     * Determines whether or not the two boxes are equal.
     *
     * @param other a Box3D object to be compared with this Box3D
     * @return true if the Box3D object to be compared has the same values; false
     *         otherwise.
     */
    public boolean equals(Box3D other) {
        return _base.equals(other._base) && _length == other._length && _width == other._width
                && _height == other._height;
    }

    /**
     * Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) without
     * changing the box dimensions.
     *
     * @param dx the addition for coordinate x value
     * @param dy the addition for coordinate y value
     * @param dz the addition for coordinate z value
     * @return the new box in its new location
     */
    public Box3D move(double dx, double dy, double dz) {
        Point3D newBase = new Point3D(_base);
        newBase.move(dx, dy, dz);

        return new Box3D(newBase, _length, _width, _height);
    }

    /**
     * Calculates and returns the upper-right-back point of this box.
     *
     * @return the upper-right-back point of this box
     */
    public Point3D getUpRightBackPoint() {
        Point3D newUpRightBackPoint = new Point3D(_base);
        newUpRightBackPoint.move(-_length, _width, _height);
        return newUpRightBackPoint;
    }

    /**
     * Calculates and returns the center point of the box.
     *
     * @return the center point of the box
     */
    public Point3D getCenter() {
        double centerX = _base.getX() - (_length / 2.0);
        double centerY = _base.getY() + _width / 2.0;
        double centerZ = _base.getZ() + _height / 2.0;

        return new Point3D(centerX, centerY, centerZ);
    }

    /**
     * Computes the distance between two boxes based on the distance of their center
     * points.
     *
     * @param other a Box3D object that will be used to calculate the distance
     *              between it and this Box3D object
     * @return the distance between two Box3D objects
     */
    public double distance(Box3D other) {
        Point3D centerBox1 = getCenter();
        Point3D centerBox2 = other.getCenter();
        return Math.sqrt(Math.pow(centerBox1.getX() - centerBox2.getX(), 2)
                + Math.pow(centerBox1.getY() - centerBox2.getY(), 2)
                + Math.pow(centerBox1.getZ() - centerBox2.getZ(), 2));
    }

    /**
     * Computes the surface area of a box.
     *
     * @return the surface area of the box
     */
    public int getSurfaceArea() {
        return 2 * (_length * _width + _length * _height + _width * _height);
    }

    /**
     * Computes the volume of the box.
     *
     * @return the volume of the box
     */
    public int getVolume() {
        return _length * _width * _height;
    }

    /**
     * Determines whether this box has a greater volume compared to another box.
     *
     * @param other a Box3D object whose volume will be compared with the volume of
     *              this Box3D
     * @return true if this object has a greater volume, false otherwise.
     */
    public boolean isLargerCapacity(Box3D other) {
        return getVolume() > other.getVolume();
    }

    /**
     * Determines whether this box is above another box.
     *
     * @param other The box to check if this box is above it
     * @return true if this box is above the other box, false otherwise
     */
    public boolean isAbove(Box3D other) {
        return _base.getZ() > other.getUpRightBackPoint().getZ();
    }

    /**
     * Determines whether this box can contain another box.
     *
     * @param other a Box3D object to check if it can be contained within this box
     * @return true if this Box3D object can contain the other, false otherwise.
     */
    public boolean contains(Box3D other) {
        if (_length <= other._length) {
            return false;
        }

        if (_width <= other._width) {
            return false;
        }

        if (_height <= other._height) {
            return false;
        }

        return true;
    }
}
