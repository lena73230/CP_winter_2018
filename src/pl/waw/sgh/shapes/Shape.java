package pl.waw.sgh.shapes;

public abstract class Shape {

    protected double parA = 0;
    protected double parB = 0;

    public Shape(double parA, double parB) {
        setParams(parA, parB);
    }

    public Shape(double parA) {
        setParams(parA, 0);
    }

    public void setParams(double parA, double b) {
        this.parA = parA;
        parB = b;
    }

    public void setParB(double parB) {
        this.parB = parB;
    }

    public abstract double calculateSurface();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + parA + ", " + parB +
                "],surf:" + calculateSurface();
    }
}
