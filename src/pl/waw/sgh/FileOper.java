package pl.waw.sgh;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class FileOper {

    public static void main(String[] args) {
        String tmp = System.getenv("TMP");
        System.out.println(tmp);

        //Properties props = System.getProperties();
        tmp = System.getProperty("java.io.tmpdir");
        System.out.println(tmp);

        String myProp = System.getProperty("myprop", "defaultValue");
        System.out.println("myprop: " + myProp);

        tmp = System.getProperty("os.name");
        System.out.println(tmp);

        tmp = System.getProperty("user.home");
        System.out.println(tmp);

    }

}
