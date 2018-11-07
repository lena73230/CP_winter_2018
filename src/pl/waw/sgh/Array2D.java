package pl.waw.sgh;

import java.util.Arrays;

public class Array2D {

    public static void main(String[] args) {
        int[][] arr2d = new int[5][5];

        arr2d[0][0] = 1;
        arr2d[1][1] = 2;
        arr2d[2][0] = 9;
        arr2d[3][2] = 5;
        arr2d[4][3] = 6;
        arr2d[2][4] = 7;
        arr2d[4][4] = 7;

        //arr2d[0]

        System.out.println(Arrays.deepToString(arr2d));
    }
}
