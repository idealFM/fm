package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfDataProperty {

    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    //protected static Properties PROPERTIES1;

    static  {
        try {
            fileInputStream = new FileInputStream("src/test/resources/config_property_data");
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
    //public static Integer getDataInt(int key1) { return PROPERTIES1.getProperty(key1);}


}


