package pl.waw.sgh;

public class BowlsRecursion {

    public static int sum(int parA, int parB) {
        int sum = parA + parB;
        return sum;
    }

    public static int sumBowls(int row) {
        if (row == 1) return 1;
        else return sumBowls(row - 1) + row;

    }


    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        System.out.println("sum is: " + sum(a, b));

        System.out.println("Bowls in row 5: " + sumBowls(100));
    }
}
