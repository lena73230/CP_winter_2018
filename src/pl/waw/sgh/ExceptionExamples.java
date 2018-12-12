package pl.waw.sgh;

import java.io.FileNotFoundException;

public class ExceptionExamples {

    public static void main(String[] args) /*throws Exception*/ {
        //throw new RuntimeException("My exception");
        System.err.println("This is an error");
        try {
            System.out.println("Message 1");
            if (Math.random() < 0.7)
                throw new Exception();
            System.out.println("Message 2");
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Problem: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Problem appeared");
            e.printStackTrace();
        }

    }
}
