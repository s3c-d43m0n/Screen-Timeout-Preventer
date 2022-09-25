package com.ritvik.tools.screen.timeout.preventer;

import org.junit.jupiter.api.Test;

import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class SystemCheckTestCase {
    @Test
    public void robot(){
        assertTrue(isRobotSupported());
    }

    private boolean isRobotSupported() {
        try{
            new Robot().keyPress(KeyEvent.VK_F23);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Test
    public void systemTray(){
        assertTrue(SystemTray.isSupported());
    }
}
