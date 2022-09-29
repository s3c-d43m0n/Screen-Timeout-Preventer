package com.ritvik.tools.screen.timeout.preventer.config;

import com.ritvik.tools.screen.timeout.preventer.utils.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.logging.Logger;

public class Configuration{
    private final File configFile;
    private int timeout;

    private static final Logger log = Logger.getLogger(Configuration.class.getName());
    private static Configuration configurationInstance;
    static{
        try {
            configurationInstance = new Configuration();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static Configuration getConfig() {
        return configurationInstance;
    }

    public Configuration() throws IOException {
        configFile = new File(System.getProperty(Constants.HOME_DIR), Constants.CONFIG_FILE);

        //Checking if new config file is needed
        if(!configFile.exists()){
            log.info("Config file not present : "+configFile.getAbsolutePath());
            updateConfig(Constants.DEFAULT_TIMEOUT);
        } else {
            readConfig();
        }
    }

    private void readConfig() throws IOException {
        log.info("Reading timeout value from config file");
        BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(configFile.toPath())));
        try {
            timeout = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (NumberFormatException e){
            updateConfig(Constants.DEFAULT_TIMEOUT);
        }
    }

    public void updateConfig(String timeoutValue) throws IOException {
        log.info("Writing timeout value "+timeoutValue+"to config file");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(configFile.toPath())));
        writer.write(timeoutValue);
        writer.flush();
        writer.close();
        readConfig();
    }

    public int getTimeout() {
        return timeout;
    }
}
