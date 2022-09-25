package com.ritvik.tools.screen.timeout.preventer;

import com.ritvik.tools.screen.timeout.preventer.config.Configuration;
import com.ritvik.tools.screen.timeout.preventer.gui.UserInterface;
import com.ritvik.tools.screen.timeout.preventer.service.BackendService;

public class Application {
    public static void main(String[] args) {
        try {
            new BackendService().start();
            new UserInterface().start();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
