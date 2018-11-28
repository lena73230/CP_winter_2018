package pl.waw.sgh.shapes;

public class EqTriangle extends AbstractTriangle
        implements PerimeterCalculation {

    public EqTriangle(double parA) {
        super(parA);
    }

    @Override
    public double calculateSurface() {
        return (Math.pow(parA, 2) * Math.sqrt(3)) / 4;
    }

    @Override
    public double calculatePerimeter() {
        return 3 * parA;
    }
}
