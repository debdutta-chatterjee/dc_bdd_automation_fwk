package com.util;

import com.constants.Environments;

import java.io.File;
import java.util.Properties;

public class ConfigLoader
{
    private Properties prop;
    private static ConfigLoader loader;

    private ConfigLoader()
    {
        String separator = File.separator;
        String env = System.getProperty("execEnv",String.valueOf(Environments.QA).toLowerCase());
        String filePath = System.getProperty("user.dir")+separator+
                "src/test/resources"+separator+"Environments"+separator+env+"_config.properties";

        prop = PropertiesUtil.propertyLoader(filePath);
    }

    public static ConfigLoader getInstance()
    {
        if(loader == null) loader = new ConfigLoader();
        return loader;
    }

    public String getBaseUrl()
    {
        String url = prop.getProperty("App_Url");
        if(url == null) throw new RuntimeException("App_Url property not found in the config file.");
        return url;
    }

    public String getApiBaseUrl()
    {
        String url = prop.getProperty("ApiBase");
        if(url == null) throw new RuntimeException("App_Url property not found in the config file.");
        return url;
    }
}
