package pl.waw.sgh;

import java.io.File;

public class DirectorySize {


    public static long CheckDirectorySize(File newFile) {
        long licznikDanych = 0;
        if (newFile.isDirectory()) {
            File[] files = newFile.listFiles();
            System.out.println("W folderze " + newFile.getName() + " są " + files.length + " pliki:");
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("Plik " + f.getName() + " rozmiar:" + f.length());
                    licznikDanych += f.length();
                } else if (f.isDirectory()) {
                    long subfolderSize = CheckDirectorySize(f);
                    System.out.println("Podfolder " + f.getName() + " size: " + subfolderSize);
                    licznikDanych += subfolderSize;
                }
            }
            //System.out.print("Folder "+newFile.getName()+" waży: " + licznikDanych+"\n");
        }
        return licznikDanych;
    }

    public static void main(String[] args) {
        File newFile = new File("C:/temp");
        long totalSize = CheckDirectorySize(newFile);
        System.out.println("TOTAL: " + totalSize);


    }

}