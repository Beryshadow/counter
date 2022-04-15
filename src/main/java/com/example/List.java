package com.example;

import javax.swing.*;
import java.awt.event.*;

import java.awt.geom.RoundRectangle2D;
import java.awt.*;

public class List extends JFrame {

    Action Escape;

    static JFrame l;
    static JLabel text;

    static Point mouseDownScreenCoords;
    static Point mouseDownCompCoords;

    public List() {

        l = new JFrame();

        JPanel one = new JPanel();
        one.setBackground(Color.decode(
                "#" + JsonManager.getFieldOrNA("Color4", folder.readGame("/Counter Files\\settings.txt"))));
        one.setOpaque(true);
        one.setBounds(20, 20, 455, 275);

        text = new JLabel(
                "<html><center>ERREUR: Le fichier /Counter Files/keybinds.txt est corrompu, <br/> effacer le et redémarrer le programme.",
                JLabel.CENTER);

        String html = "<html><center>";
        html += "Bouton 1: "
                + (JsonManager.getFieldOrNA("Buton1", folder.readGame("/Counter Files\\settings.txt"))) + "<br/>";
        html += "Bouton 2: "
                + (JsonManager.getFieldOrNA("Buton2", folder.readGame("/Counter Files\\settings.txt"))) + "<br/>";
        html += "Bouton 3: "
                + (JsonManager.getFieldOrNA("Buton3", folder.readGame("/Counter Files\\settings.txt"))) + "<br/>";
        html += "Bouton 4: "
                + (JsonManager.getFieldOrNA("Buton4", folder.readGame("/Counter Files\\settings.txt"))) + "<br/>";
        html += "Bouton 5: " + (JsonManager.getFieldOrNA("Buton5", folder.readGame("/Counter Files\\settings.txt")))
                + "<br/>";
        html += "Bouton 6: " + (JsonManager.getFieldOrNA("Buton6", folder.readGame("/Counter Files\\settings.txt")))
                + "<br/>";
        html += "Démarrer/Arrêter: "
                + (JsonManager.getFieldOrNA("PauseT", folder.readGame("/Counter Files\\settings.txt")))
                + "<br/>";
        html += "Annuler la derniere action: Ctrl + z<br/>";
        html += "Nouvelle partie/Tout effacer: Ctrl + n<br/>";
        html += "Retour en arrière: Esc<br/>";
        text.setText(html);

        Font font = new Font("Segoe UI", Font.BOLD, 20);
        text.setFont(font);

        text.setForeground(Color.GRAY.darker());

        Button escbut = new Button(50, 305, 400, 75, 4, 20);
        Text textNew = new Text("Appuyer ici ou presser sur la touche Esc", 19);
        escbut.add(textNew);

        one.add(text);

        l.add(one);

        l.add(escbut);

        l.setTitle("Liste");
        l.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        l.getContentPane().setBackground(Color.decode(
                "#" + JsonManager.getFieldOrNA("Color4", folder.readGame("/Counter Files\\settings.txt"))));
        l.setUndecorated(true);
        l.setShape(new RoundRectangle2D.Double(0, 0, 499, 399, 40, 40));
        l.setLocation(Menu.m.getLocation());
        l.setSize(514, 437);
        l.setLayout(null);
        l.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 40, 17, Color.black));
        l.setVisible(true);

        if (Menu.m != null) {
            Menu.m.dispose();
        }

        escbut.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == escbut) {
                    Point location = l.getLocation();
                    new Menu(location);
                    List.l.dispose();
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

        Escape = new Escape();

        JRootPane rootPane = l.getRootPane();

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                        "Escape");
        rootPane.getActionMap().put("Escape", Escape);

        l.addMouseListener(new MouseListener() {
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

        l.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                l.setLocation(
                        mouseDownScreenCoords.x + (currCoords.x - mouseDownScreenCoords.x) - mouseDownCompCoords.x,
                        mouseDownScreenCoords.y + (currCoords.y - mouseDownScreenCoords.y) - mouseDownCompCoords.y);
            }
        });

    }

    public class Escape extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            Point location = l.getLocation();
            new Menu(location);
            List.l.dispose();
        }
    }
}
