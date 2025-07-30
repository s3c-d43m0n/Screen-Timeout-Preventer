package com.ritvik.tools.screen.timeout.preventer.model;

import com.ritvik.tools.screen.timeout.preventer.config.Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Logger;

public class ConfigPrompt implements ActionListener {
    private static final Logger log = Logger.getLogger(ConfigPrompt.class.getName());
    private final Icon icon;
    private final Component parent;

    ConfigPrompt(Icon icon, Component parent) {
        this.icon = icon;
        this.parent = parent;
    }

    ConfigPrompt(Icon icon) {
        this(icon, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int timeout = Configuration.getConfig().getTimeout();
        String value = "";
        while (value != null) {
            value = (String) JOptionPane
                    .showInputDialog(
                            parent,
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
                    value = null;
                } catch (NumberFormatException ex) {
                    log.warning(ex.getLocalizedMessage());
                    JOptionPane.showMessageDialog(
                            parent,
                            "Please Enter Again",
                            "Invalid value entered",
                            JOptionPane.ERROR_MESSAGE,
                            icon
                    );
                } catch (IOException ex) {
                    log.warning(ex.getLocalizedMessage());
                    JOptionPane.showMessageDialog(
                            parent,
                            ex.getLocalizedMessage(),
                            "Exception Occurred",
                            JOptionPane.ERROR_MESSAGE,
                            icon
                    );
                }
            }
        }
    }
}
