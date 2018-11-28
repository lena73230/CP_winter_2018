package pl.waw.sgh.shapes;

public class EqTriangle extends AbstractTriangle {
    public EqTriangle(double parA) {
        super(parA);
    }

    @Override
    public double calculateSurface() {
        return (Math.pow(parA, 2) * Math.sqrt(3)) / 4;
    }
}
