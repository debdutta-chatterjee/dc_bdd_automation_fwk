package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil
{
    public static Properties propertyLoader(String filePath)
    {
        Properties prop = new Properties();
        try {
            prop.load (new BufferedReader(new FileReader(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("Unable to load property file"+ e.getMessage());
        }

        return prop;
    }
}
