package com.protrack.web.selenium.utility;

import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(String propName) {
        Properties properties=new Properties();
        FileReader reader = null;
    //    System.out.println("Environment is :" + System.getProperty("env") );
        try {
            if(System.getProperty("env")=="uat"){
                reader = new FileReader("src//test//resources//uat.properties");}
            else if(System.getProperty("env")=="qa")
            { reader = new FileReader("src//test//resources//qa.properties");}
            else{
                reader=new FileReader("src//test//resources//qa.properties");
            }

            System.out.println("reader is :" + reader);
            properties.load(reader);
        }catch(Exception ex){
            System.out.println("File not found");
        }
        return properties.getProperty(propName);
    }
}
