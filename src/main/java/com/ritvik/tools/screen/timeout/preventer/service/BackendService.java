package com.ritvik.tools.screen.timeout.preventer.service;

import com.ritvik.tools.screen.timeout.preventer.config.Configuration;
import com.ritvik.tools.screen.timeout.preventer.model.Emulator;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BackendService extends Thread implements Runnable{
    private final Configuration configuration = Configuration.getConfig();
    private final ScheduledExecutorService executorService;
    private final static Logger log = Logger.getLogger(BackendService.class.getName());

    public BackendService() {
        this.setName(this.getClass().getName());
        executorService = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void run() {
        try {
            Robot robot = new Robot();
            while (true) try {
                log.info("Scheduling new emulator event with delay of " + configuration.getTimeout() + " seconds");
                executorService.schedule(new Emulator(robot), configuration.getTimeout(), TimeUnit.SECONDS).get();
            } catch (InterruptedException | ExecutionException e) {
                log.warning(e.getLocalizedMessage());
                throw new RuntimeException(e);
            }
        } catch (AWTException e) {
            log.warning(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }
}
