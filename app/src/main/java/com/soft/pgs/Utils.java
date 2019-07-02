package com.soft.pgs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class Utils {

    private static final String PROPERTIES_FILE = "config.properties";
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    static void loadProperties() {
        try {
            InputStream propFile = Application.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);

            Properties p = new Properties(System.getProperties());
            p.load(propFile);
            System.setProperties(p);

            logger.info("Got properties from file");

        } catch (FileNotFoundException e) {
            logger.info("Properties file not found");
        } catch (IOException e) {
            logger.info("Can't read properties file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
