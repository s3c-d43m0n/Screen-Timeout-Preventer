package com.ritvik.tools.screen.timeout.preventer.model;

import javax.swing.Icon;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.util.logging.Logger;

import static com.ritvik.tools.screen.timeout.preventer.utils.Constants.CONFIGURE_TIMER;

public class Menu extends PopupMenu {
    private static final Logger log = Logger.getLogger(Menu.class.getName());

    public Menu(TrayIcon taskBarTray, Icon icon) {
        MenuItem timer = new MenuItem(CONFIGURE_TIMER);
        timer.addActionListener(new ConfigPrompt(icon));
        add(timer);

        MenuItem exit = new MenuItem("Exit");
        exit.addActionListener(e -> {
            log.info("Received exit call, terminating application");
            SystemTray.getSystemTray().remove(taskBarTray);
            System.exit(0);
        });
        add(exit);
    }
}
