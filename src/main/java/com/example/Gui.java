package com.example;

import java.awt.event.*;
import java.awt.Point;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.geom.RoundRectangle2D;
import java.awt.*;

public class Gui extends JFrame {
    static Point mouseDownScreenCoords;
    static Point mouseDownCompCoords;
    static JFrame j;
    Action Button1;
    Action Button2;
    Action Button3;
    Action Button4;
    Action Button5;
    Action Button6;
    Action Start_stop;
    Action Cancel;
    Action Escape;
    Action NewGame;
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
    public static Text textErase = new Text("<html>Effacer le<br/>temps</html>", 25);
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

        Button1 = new Button1();
        Button2 = new Button2();
        Button3 = new Button3();
        Button4 = new Button4();
        Button5 = new Button5();
        Button6 = new Button6();
        Start_stop = new Start_stop();
        Cancel = new Cancel();
        Escape = new Escape();
        NewGame = new NewGame();

        JRootPane rootPane = j.getRootPane();

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(
                        (JsonManager.getFieldOrNA("Buton1", folder.readGame("/Counter Files\\settings.txt")))
                                .charAt(0)),
                        "button1");
        rootPane.getActionMap().put("button1", Button1);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(
                        (JsonManager.getFieldOrNA("Buton2", folder.readGame("/Counter Files\\settings.txt")))
                                .charAt(0)),
                        "button2");
        rootPane.getActionMap().put("button2", Button2);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(
                        (JsonManager.getFieldOrNA("Buton3", folder.readGame("/Counter Files\\settings.txt")))
                                .charAt(0)),
                        "button3");
        rootPane.getActionMap().put("button3", Button3);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(
                        (JsonManager.getFieldOrNA("Buton4", folder.readGame("/Counter Files\\settings.txt")))
                                .charAt(0)),
                        "button4");
        rootPane.getActionMap().put("button4", Button4);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(
                        (JsonManager.getFieldOrNA("Buton5", folder.readGame("/Counter Files\\settings.txt")))
                                .charAt(0)),
                        "button5");
        rootPane.getActionMap().put("button5", Button5);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(
                        (JsonManager.getFieldOrNA("Buton6", folder.readGame("/Counter Files\\settings.txt")))
                                .charAt(0)),
                        "button6");
        rootPane.getActionMap().put("button6", Button6);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(
                        (JsonManager.getFieldOrNA("PauseT", folder.readGame("/Counter Files\\settings.txt")))
                                .charAt(0)),
                        "start_stop");
        rootPane.getActionMap().put("start_stop", Start_stop);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                        "Escape");
        rootPane.getActionMap().put("Escape", Escape);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK), "cancel");
        rootPane.getActionMap().put("cancel", Cancel);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), "new game");
        rootPane.getActionMap().put("new game", NewGame);

        j.setTitle("Compteur");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setBackground(Color.WHITE);
        j.setUndecorated(true);
        j.setShape(new RoundRectangle2D.Double(0, 0, 499, 399, 40, 40));
        j.setLocation(x, y);
        j.setSize(514, 437);
        j.setLayout(null);
        j.setVisible(true);

        if (Menu.m != null) {
            Menu.m.dispose();
        }

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

    public class Button1 extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            folder.Log(1);
            refresh();
        }
    }

    public class Button2 extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            folder.Log(2);
            refresh();
        }
    }

    public class Button3 extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            folder.Log(3);
            refresh();
        }
    }

    public class Button4 extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            folder.Log(4);
            refresh();
        }
    }

    public class Button5 extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            folder.Log(5);
            refresh();
        }
    }

    public class Button6 extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            folder.Log(6);
            refresh();
        }
    }

    public class Start_stop extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Stopwatch.stopStart == true) {
                Stopwatch.stop();
                Stopwatch.stopStart = false;
            } else {
                Stopwatch.start();
                Stopwatch.stopStart = true;
            }
        }
    }

    public class Cancel extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            folder.deletelast();
            refresh();
        }
    }

    public class NewGame extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            folder.Log(10);
            refresh();
        }
    }

    public class Escape extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Point location = j.getLocation();
            new Menu(location);
        }
    }

    public void refresh() {
        Gui.l1.setText(JsonManager.getFieldOrNA("team1Count",
                folder.readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt")));

        Gui.l2.setText(JsonManager.getFieldOrNA("team2Count",
                folder.readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt")));
    }

}
