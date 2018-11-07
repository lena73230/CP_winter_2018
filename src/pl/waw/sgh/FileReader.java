package pl.waw.sgh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void main(String[] args) throws FileNotFoundException {
        //File inFile = new File("h:\\mytxtfile.txt");
        File inFile = new File("h:/mytxtfile.txt");
        //File inFile = new File("h:" + File.separator + "mytxtfile.txt");

        Scanner scanner = new Scanner(inFile);
        int i = 1;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] elems = line.split(";");
            System.out.println(i + ": " + line);

            i++;
        }

    }
}
