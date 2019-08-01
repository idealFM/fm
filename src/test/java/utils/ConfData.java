package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfData {

    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static  {
        try {
            fileInputStream = new FileInputStream("src/test/resources/config_user_data");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }



    public static String getData(String key) {
        return PROPERTIES.getProperty(key);
    }
}


