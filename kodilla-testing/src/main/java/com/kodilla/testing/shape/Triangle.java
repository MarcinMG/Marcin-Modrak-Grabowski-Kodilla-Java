package com.kodilla.testing.shape;

public class Triangle implements Shape{
    String shapeName;
    double side;
    double height;

    public Triangle(String shapeName, double side, double height) {
        this.shapeName = shapeName;
        this.side = side;
        this.height = height;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getSide() {
        return side;
    }

    public double getHeight() {
        return height;
    }

    public double getField() {
        return 0.5*side*height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.side, side) != 0) return false;
        if (Double.compare(triangle.height, height) != 0) return false;
        return shapeName.equals(triangle.shapeName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = shapeName.hashCode();
        temp = Double.doubleToLongBits(side);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
