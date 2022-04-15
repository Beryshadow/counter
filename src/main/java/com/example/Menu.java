package com.example;

import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;

import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.Desktop;

import javax.swing.JFrame;

public class Menu extends JFrame {

    Action Escape;

    static JFrame m;

    static Point mouseDownScreenCoords;
    static Point mouseDownCompCoords;

    public Menu(Point location) {
        m = new JFrame();

        Button but1 = new Button(50, 20, 400, 75, 4, 10);
        Button but2 = new Button(50, 115, 400, 75, 4, 11);
        Button but3 = new Button(50, 210, 400, 75, 4, 12);
        Button but4 = new Button(50, 305, 400, 75, 4, 13);

        Text textNew = new Text("Nouvelle partie", 20);
        Text textClose = new Text("Fermer le programme", 20);
        Text textKeybinds = new Text("Ouvrir la liste des raccourcis", 20);
        Text folders = new Text("Ouvrir les fichiers", 20);

        but1.add(textNew);
        but2.add(textClose);
        but3.add(textKeybinds);
        but4.add(folders);

        m.add(but1);
        m.add(but2);
        m.add(but3);
        m.add(but4);

        Escape = new Escape();

        m.setTitle("Menu");
        m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        m.getContentPane().setBackground(Color.decode(
                "#" + JsonManager.getFieldOrNA("Color4", folder.readGame("/Counter Files\\settings.txt"))));
        m.setUndecorated(true);
        m.setShape(new RoundRectangle2D.Double(0, 0, 499, 399, 40, 40));
        m.setLocation(location.getLocation());
        m.setSize(514, 437);
        m.setLayout(null);
        m.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 40, 17, Color.black));
        m.setVisible(true);

        if (Gui.j != null) {
            Gui.j.dispose();
        }

        Escape = new Escape();

        JRootPane rootPane = m.getRootPane();

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                        "Escape");
        rootPane.getActionMap().put("Escape", Escape);
        but4.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == but4) {
                    // open the folder
                    try {
                        Desktop.getDesktop().open(new File("/Counter Files"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
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

        but1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == but1) {
                    int x = Menu.m.getX();
                    int y = Menu.m.getY();
                    new Gui(x, y);
                    Menu.m.dispose();
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

        m.addMouseListener(new MouseListener() {
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

        m.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                m.setLocation(
                        mouseDownScreenCoords.x + (currCoords.x - mouseDownScreenCoords.x) - mouseDownCompCoords.x,
                        mouseDownScreenCoords.y + (currCoords.y - mouseDownScreenCoords.y) - mouseDownCompCoords.y);
            }
        });

    }

    public class Escape extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int x = Menu.m.getX();
            int y = Menu.m.getY();
            new Gui(x, y);
            Menu.m.dispose();
        }
    }
}
