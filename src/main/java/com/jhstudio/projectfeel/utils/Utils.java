package com.jhstudio.projectfeel.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class Utils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class.getName());

    @Bean(name="appEnvironmentConfig")
    public static Properties fetchProperties(){
        Properties properties = new Properties();
        try {
            File file = ResourceUtils.getFile("classpath:.env");
            InputStream in = new FileInputStream(file);
            properties.load(in);
            if (!properties.get("YELP_API_KEY").equals("")){
                System.out.println("Yelp API Key LOADED");
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return properties;
    }

}
