package com.ritvik.tools.screen.timeout.preventer.model;

import com.ritvik.tools.screen.timeout.preventer.config.Configuration;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.IOException;
import java.util.logging.Logger;

public class Menu extends PopupMenu {
    private static final Logger log = Logger.getLogger(Menu.class.getName());
    public Menu(TrayIcon taskBarTray, Icon icon){
        MenuItem timer = new MenuItem("Configure Timer");
        timer.addActionListener((e)->{
            int timeout = Configuration.getConfig().getTimeout();
            String value = "";
            while(value!=null) {
                value = (String) JOptionPane
                    .showInputDialog(
                        null,
                        "Current Timer Configuration: " + timeout + " seconds",
                        "Please enter new time in seconds",
                        JOptionPane.QUESTION_MESSAGE,
                        icon,
                        null,
                        timeout + "");
                if (value != null) {
                    try {
                        Integer.parseInt(value);
                        Configuration.getConfig().updateConfig(value);
                    } catch (NumberFormatException ex){
                        log.warning(ex.getLocalizedMessage());
                        JOptionPane.showMessageDialog(
                            null,
                            "Please Enter Again",
                            "Invalid value entered",
                            JOptionPane.ERROR_MESSAGE,
                            icon
                        );
                    } catch (IOException ex) {
                        log.warning(ex.getLocalizedMessage());
                        JOptionPane.showMessageDialog(
                                null,
                                ex.getLocalizedMessage(),
                                "Exception Occurred",
                                JOptionPane.ERROR_MESSAGE,
                                icon
                        );
                    }
                }
            }
        });
        add(timer);

        MenuItem exit = new MenuItem("Exit");
        exit.addActionListener(e-> {
            log.info("Received exit call, terminating application");
            SystemTray.getSystemTray().remove(taskBarTray);
            System.exit(0);
        });
        add(exit);
    }
}
