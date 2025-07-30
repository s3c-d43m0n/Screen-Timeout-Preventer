package com.ritvik.tools.screen.timeout.preventer;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemCheckTestCase {
    @Test
    public void robot() {
        assertTrue(isRobotSupported());
    }

    private boolean isRobotSupported() {
        if (System.getProperty("os.name").startsWith("Windows")) try {
            new Robot().keyPress(KeyEvent.VK_F23);
            return true;
        } catch (Exception e) {
            return false;
        }
        else return true;
    }

    @Test
    public void systemTray() {
        if (System.getProperty("os.name").startsWith("Windows")) assertTrue(SystemTray.isSupported());
    }
}
