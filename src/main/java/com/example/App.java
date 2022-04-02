package com.example;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 */
public final class App {
    static boolean stopStart;

    public static void main(String[] args) {
        folder.createFile();
        int number = 1;
        folder.NewGame(number);
        new Gui(0, 0);
        Stopwatch stopwatch = new Stopwatch();
    }
}
