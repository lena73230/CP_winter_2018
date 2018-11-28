package pl.waw.sgh.shapes;

public class PlayWithShapes {

    public static void main(String[] args) {
        Shape shape = new Rectangle(1, 2);
        Shape shape2 = new Circle(4);
        Shape shape3 = new Triangle(2, 3);

        Shape[] myShapes = new Shape[]{
                shape, shape2, shape3
        };

        for (Shape sh : myShapes) {
            System.out.println(sh);
        }

    }
}
