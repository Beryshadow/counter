package com.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Point;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.geom.RoundRectangle2D;
import java.awt.*;

import javax.swing.JFrame;

public class Menu extends JFrame {

    public Menu() {

        Button but1 = new Button(50, 20, 400, 75, 4, 10);
        Button but2 = new Button(50, 115, 400, 75, 4, 11);
        Button but3 = new Button(50, 210, 400, 75, 4, 12);
        Button but4 = new Button(50, 305, 400, 75, 4, 13);

        Text textNew = new Text("Nouvelle partie", 20);
        Text textClose = new Text("Fermer le programe", 20);
        Text textCancel = new Text("Annuler la derniere action", 20);
        Text textBack = new Text("Retour en arriere", 20);

        but1.add(textNew);
        but2.add(textClose);
        but3.add(textCancel);
        but4.add(textBack);

        this.add(but1);
        this.add(but2);
        this.add(but3);
        this.add(but4);

        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode(
                "#" + JsonManager.getFieldOrNA("Color4", folder.readGame("/Counter Files\\settings.txt"))));
        this.setUndecorated(true);
        this.setShape(new RoundRectangle2D.Double(0, 0, 499, 399, 40, 40));
        setLocation(Gui.j.getLocation());
        this.setSize(514, 437);
        this.setLayout(null);
        this.setVisible(true);
        if (Gui.j != null) {
            Gui.j.dispose();
        }

        but4.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == but4) {
                    int x = Menu.this.getX();
                    int y = Menu.this.getY();
                    Menu.this.dispose();
                    new Gui(x, y);
                    // make a new gui at the same location as the menu

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
    }
}
