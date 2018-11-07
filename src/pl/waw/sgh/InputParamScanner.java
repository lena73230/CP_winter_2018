package pl.waw.sgh;

import java.util.Scanner;

public class InputParamScanner {

    public static void main(String[] args) {
        System.out.println("This is output");
        System.err.println("This is an error");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide your name: \t");
        // \t - tab
        // \n - new line (Mac and Unix)
        // \r\n - Windows CR LF

        while (scanner.hasNextInt()) {
            Integer myInt = scanner.nextInt();
            if (myInt.equals(0)) break;
            System.out.println("I got " + myInt);
        }


        /*while (scanner.hasNext()) {
            String name = scanner.next();
            if (name.equals("exit")) break;
            System.out.println("Hello " + name);
        }
        */

    }
}
