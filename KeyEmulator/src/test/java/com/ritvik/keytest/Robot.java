/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ritvik.keytest;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Ritvik
 */
public class Robot {
    
    public Robot() {
    }

    @Test
    public void testRobot() {
        Boolean test=false;
        try{
            new java.awt.Robot().keyPress(KeyEvent.VK_F23);
            test=true;
        } catch (AWTException ex) {
        }
        assertTrue(test);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
