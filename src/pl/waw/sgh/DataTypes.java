package pl.waw.sgh;

public class DataTypes {

    /*
    This is a comment

     */

    /*This should be a
            comment
    */

    // psvm
    public static void main(String[] args) {
        byte b1 = 5;
        byte b2 = 120;
/*
        int i1 = 1434535355;
        int i2 = 985245454;
        int i3 = i1 + i2;
*/

        int i1 = 1434535355;
        int i2 = 985245454;

        long i3 = i1;
        // i3 = i3 + i2;
        i3 += i2;
        ///long i3 = i1 + i2;

        // sout
        // str(i3) - python
        System.out.println("i3: " + i3);

        int a = 5;
        int b, bb;
        b = a++;
        //a = 5;
        bb = ++a;

        System.out.println("b=" + b);
        System.out.println("bb=" + bb);

        double d1 = 2;
        double d2 = 3;

        double d3 = Math.pow(d1, d2);   // 2^3

        System.out.println("d3=" + d3);

        int ii1, ii2;
        ii1 = 3;
        ii2 = 6;

        // ii1==ii2
        // ii1<ii2
        // ii1<=ii2
        // ii1>=ii2
        boolean cond = ii1 == ii2;
        // ! - negate
        // || - OR
        // && - AND
        //
        if ((cond || ii2 > 3) && ii1 > 5) {
            System.out.println("ii2=ii1");
        } else {
            System.out.println("ii2 not eq ii1");
        }


        int iii = (ii1 > 5 ? 15 : 10);

        if (ii1 > 5)
            iii = 15;
        else
            iii = 10;

        System.out.println("iii=" + iii);
    }
}
