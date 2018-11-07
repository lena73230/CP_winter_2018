package pl.waw.sgh;

import java.util.Arrays;

public class ArraysSimple {

    public static void main(String[] args) {
        //int[] arrInt = new int[3];
        Integer[] arrInt = new Integer[3];
        arrInt[0] = 1;
        arrInt[1] = 2;
        arrInt[2] = 5;

        System.out.println(Arrays.toString(arrInt));

        /*for (int i=0;i<arrInt.length;i++) {
            System.out.println("Elem " + i + " = " + (arrInt[i] + 10));

        }*/

        String[] arrStr = new String[]{
                "abc", "def", "efg"
        };
        System.out.println(Arrays.toString(arrStr));


    }
}
