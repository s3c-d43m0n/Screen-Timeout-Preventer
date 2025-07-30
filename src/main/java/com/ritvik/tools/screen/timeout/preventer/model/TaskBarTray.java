package com.ritvik.tools.screen.timeout.preventer.model;

import com.ritvik.tools.screen.timeout.preventer.utils.Constants;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.TrayIcon;

public class TaskBarTray extends TrayIcon {

    public TaskBarTray(Image image) {
        super(image, Constants.APP_NAME);
        this.setPopupMenu(new Menu(this, new ImageIcon(image, Constants.APP_NAME)));
        setImageAutoSize(true);
    }
}
