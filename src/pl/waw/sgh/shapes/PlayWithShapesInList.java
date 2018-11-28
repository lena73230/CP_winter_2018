package pl.waw.sgh.shapes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlayWithShapesInList {

    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Rectangle(1, 2));
        shapeList.add(new Circle(4));
        shapeList.add(new Triangle(2, 3));
        shapeList.add(new EqTriangle(3));

        // Sort using the compareTo in Shape (surface)
        Collections.sort(shapeList);
        // Sort using the ShapeComparator (parA + parB)
        //Collections.sort(shapeList, new ShapeComparator());

        for (Shape sh : shapeList) {
            System.out.println(sh);
        }

    }
}
