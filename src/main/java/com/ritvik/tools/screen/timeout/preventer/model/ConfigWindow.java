package com.ritvik.tools.screen.timeout.preventer.model;

import com.ritvik.tools.screen.timeout.preventer.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.ritvik.tools.screen.timeout.preventer.utils.Constants.APP_NAME;
import static com.ritvik.tools.screen.timeout.preventer.utils.Constants.CONFIGURE_TIMER;

public class ConfigWindow extends Frame {
    public ConfigWindow(Image icon) {
        super(APP_NAME);
        setIconImage(icon);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Panel button_panel = new Panel(new GridLayout(2, 1, 10, 10));
        button_panel.add(new Label(" No support for System-Tray on this OS, hence using this Window.", Label.CENTER));
        Button configure_timer = new Button(CONFIGURE_TIMER);
        configure_timer.addActionListener(new ConfigPrompt(new ImageIcon(icon, Constants.APP_NAME), this));
        button_panel.add(configure_timer);
        add(button_panel);
        pack();
        setResizable(false);
        setVisible(true);
    }
}
