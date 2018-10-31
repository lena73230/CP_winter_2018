package pl.waw.sgh;

public class Loops {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("I=" + i);
        }
        System.out.println();
        for (int i = 6; i > 1; i--) {
            // skip to next iteration
            if (i == 5) continue;
            System.out.println("I=" + i);
            // stop the loop
            if (i == 4) break;
        }
        System.out.println();

        int j = 0;
        while (j < 6) {
            System.out.println("J=" + j);
            j++;
        }
        System.out.println();
        int k = 1;
        do {
            System.out.println("K=" + k);
            k--;
        } while (k > 2);

    }
}
