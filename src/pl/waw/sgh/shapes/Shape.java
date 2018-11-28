package pl.waw.sgh.shapes;

public abstract class Shape implements Comparable<Shape> {

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

    public double getParA() {
        return parA;
    }

    public double getParB() {
        return parB;
    }

    @Override
    public int compareTo(Shape o) {
        Double mySurface = Double.valueOf(calculateSurface());
        Double otherSurface = Double.valueOf(o.calculateSurface());
        return mySurface.compareTo(otherSurface);
    }

    public String explainCompareTo(Shape o) {
        int result = compareTo(o);
        switch (result) {
            case -1:
                return this.toString() + " LESS than " + o.toString();
            case 1:
                return this.toString() + " GREATER than " + o.toString();
            default:
                return this.toString() + " EQUAL to " + o.toString();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + parA + ", " + parB +
                "],surf:" + calculateSurface();
    }
}
