package com.ritvik.tools.screen.timeout.preventer.gui;

import com.ritvik.tools.screen.timeout.preventer.model.ConfigWindow;
import com.ritvik.tools.screen.timeout.preventer.model.TaskBarTray;

import java.awt.*;

public class UserInterface {
    public void start() throws AWTException {
        Image image = Toolkit.getDefaultToolkit().getImage(Thread.currentThread().getContextClassLoader().getResource("icon.png"));
        if (SystemTray.isSupported()) {
            SystemTray.getSystemTray().add(new TaskBarTray(image));
        } else {
            new ConfigWindow(image);
        }
    }
}
