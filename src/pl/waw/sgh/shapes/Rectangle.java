package pl.waw.sgh.shapes;

public class Rectangle extends Shape {

    public Rectangle(double parA, double parB) {
        super(parA, parB);
    }

    @Override
    public double calculateSurface() {
        return parA * parB;
    }
}
