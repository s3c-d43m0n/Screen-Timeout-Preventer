package com.ritvik.tools.screen.timeout.preventer.gui;

import com.ritvik.tools.screen.timeout.preventer.config.Configuration;
import com.ritvik.tools.screen.timeout.preventer.model.TaskBarTray;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;

public class UserInterface{
    public void start() throws AWTException {
        SystemTray.getSystemTray().add(new TaskBarTray(
                Toolkit.getDefaultToolkit().getImage(Thread.currentThread().getContextClassLoader().getResource("icon.png")))
        );
    }
}
