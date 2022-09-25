package com.ritvik.tools.screen.timeout.preventer.config;

import com.ritvik.tools.screen.timeout.preventer.utils.Constants;
import lombok.Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

@Data
public class Configuration implements AutoCloseable{
    private File configFile;
    private int timeout;
    private FileLock configFileLock;

    public Configuration(){
        configFile = new File(System.getProperty(Constants.HOME_DIR), Constants.CONFIG_FILE);

        //Checking if new config file is needed
        if(!configFile.exists()){
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(configFile)))){
                writer.write(Constants.DEFAULT_TIMEOUT);
                writer.flush();
            } catch (IOException e){
                //:TODO Logging
                System.exit(-1);
            }
        }

        //Reading timeout value from config file
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(configFile)))){
            timeout = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            //:TODO Logging
            System.exit(-1);
        }

        //Acquiring process level lock on config file
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(configFile,"rw")){
            configFileLock = randomAccessFile.getChannel().tryLock();
        } catch (IOException e) {
            //:TODO Logging
            System.exit(-1);
        }
    }

    @Override
    public void close() throws Exception {
        if(configFile!=null){
            configFileLock.release();
        }
    }
}
