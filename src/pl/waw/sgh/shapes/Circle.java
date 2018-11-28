package pl.waw.sgh.shapes;

public class Circle extends Shape {

    public Circle(double parA) {
        super(parA);
    }

    @Override
    public double calculateSurface() {
        return Math.PI * Math.pow(parA, 2);
    }
}
