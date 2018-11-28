package pl.waw.sgh.shapes;

public class PlayWithShapes {

    public static void main(String[] args) {
        Shape shape = new Rectangle(1, 2);
        Shape shape2 = new Circle(4);
        Shape shape3 = new Triangle(2, 3);
        Shape shape4 = new EqTriangle(3);

        Shape[] myShapes = new Shape[]{
                shape, shape2, shape3, shape4
        };

        //int result = shape.compareTo(shape2);
        System.out.println("shape compared to shape2: "
                + shape.explainCompareTo(shape2));


        for (Shape sh : myShapes) {
            System.out.println(sh);
            // This casting will not always succeed as not all Shapes are Rectangles
            //Rectangle r = ((Rectangle)sh);
            if (sh instanceof PerimeterCalculation) {
                PerimeterCalculation pm = (PerimeterCalculation) sh;
                double perim = pm.calculatePerimeter();
                System.out.println("Perimeter: " + perim);
            }
        }

    }
}
