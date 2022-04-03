package com.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Point;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.geom.RoundRectangle2D;
import java.awt.*;

public class Gui extends JFrame {
    static Point mouseDownScreenCoords;
    static Point mouseDownCompCoords;
    static JFrame j;
    Button but1 = new Button(25, 140, 100, 80, 1, 1);
    Button but2 = new Button(25, 220, 100, 80, 1, 2);
    Button but3 = new Button(25, 300, 100, 80, 1, 3);
    Button but4 = new Button(375, 140, 100, 80, 2, 4);
    Button but5 = new Button(375, 220, 100, 80, 2, 5);
    Button but6 = new Button(375, 300, 100, 80, 2, 6);
    Button butStopStart = new Button(175, 80, 150, 80, 3, 7);
    Button butErase = new Button(175, 160, 150, 80, 3, 8);
    Button butMenu = new Button(175, 285, 150, 80, 4, 9);
    public static Text textMenu = new Text("Menu");
    public static Text textStopStart = new Text("<html>Démarrer<br/>Arrêter</html>", 25);
    public static Text textErase = new Text("Effacer", 35);
    public static Text text1 = new Text(1);
    public static Text text2 = new Text(2);
    public static Text text3 = new Text(3);
    public static Text text4 = new Text(4);
    public static Text text5 = new Text(5);
    public static Text text6 = new Text(6);
    public static Stopwatch stopwatch = new Stopwatch();
    public static Text l1 = new Text((JsonManager.getFieldOrNA("team1Count",
            folder.readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt"))), 80);
    public static Text l2 = new Text((JsonManager.getFieldOrNA("team2Count",
            folder.readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt"))), 80);

    Gui(int x, int y) {
        j = new JFrame();
        j.setResizable(false);

        Border bord = BorderFactory.createLineBorder(Color.black, 2);

        JPanel one = new JPanel();
        one.setBackground(Color.decode(
                "#" + JsonManager.getFieldOrNA("Color1", folder.readGame("/Counter Files\\settings.txt"))));
        one.setBorder(bord);
        one.setOpaque(true);
        one.setBounds(0, 0, 150, 400);

        JPanel two = new JPanel();
        two.setBackground(Color
                .decode("#" + JsonManager.getFieldOrNA("Color2", folder.readGame("/Counter Files\\settings.txt"))));
        two.setOpaque(true);
        two.setBorder(bord);
        two.setBounds(350, 0, 150, 400);

        JPanel three = new JPanel();
        three.setBackground(Color
                .decode("#" + JsonManager.getFieldOrNA("Color3", folder.readGame("/Counter Files\\settings.txt"))));
        three.setOpaque(true);
        three.setBorder(bord);
        three.setBounds(150, 0, 200, 250);

        JPanel four = new JPanel();
        four.setBackground(
                Color.decode(
                        "#" + JsonManager.getFieldOrNA("Color4", folder.readGame("/Counter Files\\settings.txt"))));
        four.setOpaque(true);
        four.setBorder(bord);
        four.setBounds(150, 250, 200, 150);

        but1.add(text1);
        but2.add(text2);
        but3.add(text3);
        but4.add(text4);
        but5.add(text5);
        but6.add(text6);
        butMenu.add(textMenu);
        butErase.add(textErase);
        butStopStart.add(textStopStart);

        three.add(stopwatch);

        one.add(l1);
        two.add(l2);

        j.add(but1);
        j.add(but2);
        j.add(but3);
        j.add(but4);
        j.add(but5);
        j.add(but6);
        j.add(butStopStart);
        j.add(butErase);
        j.add(butMenu);

        j.add(four);
        j.add(three);
        j.add(one);
        j.add(two);

        j.setTitle("Compteur");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setBackground(Color.WHITE);
        j.setUndecorated(true);
        j.setShape(new RoundRectangle2D.Double(0, 0, 499, 399, 40, 40));
        j.setLocation(x, y);
        j.setSize(514, 437);
        j.setLayout(null);
        j.setVisible(true);

        butStopStart.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (Stopwatch.stopStart == true) {
                    Stopwatch.stop();
                    Stopwatch.stopStart = false;
                } else {
                    Stopwatch.start();
                    Stopwatch.stopStart = true;
                }
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {

            }
        });

        butErase.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                Stopwatch.elapsedTime = 0;
                Stopwatch.time = System.nanoTime();
                Stopwatch.savedTime = 0;
                stopwatch.setText("0:00:00:000");
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {

            }
        });

        j.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                mouseDownScreenCoords = null;
                mouseDownCompCoords = null;
            }

            public void mousePressed(MouseEvent e) {
                mouseDownScreenCoords = e.getLocationOnScreen();
                mouseDownCompCoords = e.getPoint();
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseClicked(MouseEvent e) {

            }
        });

        j.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                j.setLocation(
                        mouseDownScreenCoords.x + (currCoords.x - mouseDownScreenCoords.x) - mouseDownCompCoords.x,
                        mouseDownScreenCoords.y + (currCoords.y - mouseDownScreenCoords.y) - mouseDownCompCoords.y);
            }
        });

    }
}
