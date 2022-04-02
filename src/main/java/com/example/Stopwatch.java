package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch extends JLabel {

    static long time = System.nanoTime();
    static long elapsedTime = 0;
    static long millis = 0;
    static long seconds = 0;
    static long minutes = 0;
    static long hours = 0;
    boolean stopStart = false;

    static String millisString = String.format("%03d", millis);
    static String secondsString = String.format("%02d", seconds);
    static String minutesString = String.format("%02d", minutes);
    static String hoursString = String.format("%01d", hours);

    static Timer timer = new Timer(1, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapsedTime = ((System.nanoTime() - time) / 1000000);
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            millis = elapsedTime % 1000;
            millisString = String.format("%03d", millis);
            secondsString = String.format("%02d", seconds);
            minutesString = String.format("%02d", minutes);
            hoursString = String.format("%01d", hours);
            System.out.println(System.nanoTime());
            Gui.stopwatch.setText(hoursString + ":" + minutesString + ":" + secondsString + ":" + millisString);
        }
    });

    Stopwatch() {
        this.setBounds(180, 30, 140, 30);
        this.setText(hoursString + ":" + minutesString + ":" + secondsString + ":" + millisString);
        this.setForeground(Color.white);
        Font font = new Font("Segoe UI", Font.BOLD, 35);
        this.setFont(font);
    }

    public static void start() {
        timer.start();
    }

    public static void stop() {
        timer.stop();
    }
}