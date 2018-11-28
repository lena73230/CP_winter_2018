package pl.waw.sgh.shapes;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        Double sumOfPars1 = Double.valueOf(o1.getParA() + o1.getParB());
        Double sumOfPars2 = Double.valueOf(o2.getParA() + o2.getParB());
        return sumOfPars1.compareTo(sumOfPars2);
    }
}
