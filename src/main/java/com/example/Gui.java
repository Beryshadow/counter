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
    JFrame j;
    Button but1 = new Button(25, 140, 100, 80, 1, 1);
    Button but2 = new Button(25, 220, 100, 80, 1, 2);
    Button but3 = new Button(25, 300, 100, 80, 1, 3);
    Button but4 = new Button(375, 140, 100, 80, 2, 4);
    Button but5 = new Button(375, 220, 100, 80, 2, 5);
    Button but6 = new Button(375, 300, 100, 80, 2, 6);
    Button butStopStart = new Button(175, 80, 150, 80, 3, 7);
    Button butErase = new Button(175, 160, 150, 80, 3, 8);
    Button butMenu = new Button(175, 285, 150, 80, 4, 9);
    Text textMenu = new Text("Menu");
    Text textStopStart = new Text("<html>Stop/<br/>Start</html>", 30);
    Text textErase = new Text("Erase");
    Text text1 = new Text(1);
    Text text2 = new Text(2);
    Text text3 = new Text(3);
    Text text4 = new Text(4);
    Text text5 = new Text(5);
    Text text6 = new Text(6);

    Gui() {
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

        Text l1 = new Text("0", 80);
        Text l2 = new Text("0", 80);

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

        j.setTitle("Counter");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setBackground(Color.WHITE); // Background
        j.setUndecorated(true);
        j.setShape(new RoundRectangle2D.Double(0, 0, 499, 399, 40, 40));
        j.setSize(514, 437);// 400 width and 500 height
        j.setLayout(null);// using no layout managers
        j.setVisible(true);// making the frame visible

        // text1.setLocation(this.getParent().getWidth() / 3,
        // this.getParent().getHeight() / 8);

        // text1.setLocation(35, 10);

        text1.translate(1);
        text2.translate(2);
        text3.translate(3);
        text4.translate(4);
        text5.translate(5);
        text6.translate(6);
        textMenu.setLocation(20, 10);
        textErase.setLocation(25, 10);
        textStopStart.setLocation(40, 5);
        l1.setLocation(50, 20);
        l2.setLocation(50, 20);

        // l1.setText("h10");
        // l1.getParent().repaint();

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
