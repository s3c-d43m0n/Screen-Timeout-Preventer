package com.ritvik.tools.screen.timeout.preventer.model;

import com.ritvik.tools.screen.timeout.preventer.utils.Constants;

import java.awt.Robot;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class Emulator implements Callable<Boolean> {

    private static final Logger log = Logger.getLogger(Emulator.class.getName());
    private final Robot robot;

    public Emulator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Boolean call() {
        log.info("Executing Keyboard Emulator Event");
        robot.keyPress(Constants.KEYBOARD_BUTTON);
        return true;
    }
}
