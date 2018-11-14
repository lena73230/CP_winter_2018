package pl.waw.sgh;

import java.io.File;

public class FileSize {

    public static void main(String[] args) {
        File newFile = new File("c:/temp");

        if (newFile.isDirectory()) {
            File[] files = newFile.listFiles();
            for (File f : files) {
                System.out.println(f.getName() + " " + f.length());
            }
        }

    }
}
