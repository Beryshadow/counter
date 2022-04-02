package com.example;

import java.awt.event.*;
import java.awt.event.MouseListener;
import javax.swing.*;

import java.awt.*;

public class Button extends JButton implements ActionListener, MouseListener {

    int number;

    Button(int locationX, int locationY, int width, int height, int ColorNumber, int action) {
        this.setBounds(locationX, locationY, width, height);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.addActionListener(this);
        this.addMouseListener(this);
        this.setBackground(Color.decode(
                "#" + JsonManager.getFieldOrNA("Color" + ColorNumber,
                        folder.readGame("/Counter Files\\settings.txt"))));
        this.setOpaque(true);
        this.number = action;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.decode(colorise(this)).darker().darker());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.decode(colorise(this)));
        this.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.number == 13) {
            // close the menu and open gui
            Gui.j.setVisible(false);
        } else if (this.number == 11) {
            System.exit(0);
        } else if (this.number == 12) {
            folder.deletelast();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            folder.Log(this.number);
            if (this.number == 9) {
                new Menu();
            }

            Gui.l1.setText(JsonManager.getFieldOrNA("team1Count",
                    folder.readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt")));

            Gui.l2.setText(JsonManager.getFieldOrNA("team2Count",
                    folder.readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt")));

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(40, 40); // Border corners arcs {width,height}, change this to whatever
                                                // you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color colored;
        try {
            if (this.getX() == 50) {
                colored = Color.decode("#" + JsonManager.getFieldOrNA("Color4",
                        folder.readGame("/Counter Files\\settings.txt")));
            } else if (this.getX() < 150) {
                colored = Color.decode("#" + JsonManager.getFieldOrNA("Color1",
                        folder.readGame("/Counter Files\\settings.txt")));
            } else if (this.getX() > 350) {
                colored = Color.decode("#" + JsonManager.getFieldOrNA("Color2",
                        folder.readGame("/Counter Files\\settings.txt")));

            } else if (this.getY() < 250) {
                colored = Color.decode("#" + JsonManager.getFieldOrNA("Color3",
                        folder.readGame("/Counter Files\\settings.txt")));
            } else if (this.getY() > 250) {
                colored = Color.decode("#" + JsonManager.getFieldOrNA("Color4",
                        folder.readGame("/Counter Files\\settings.txt")));
            } else {
                colored = Color.white;
            }
        } catch (Exception e) {
            colored = Color.decode("#FFFFFF");
        }

        // Draws the rounded panel with borders.
        graphics.setColor(colored.darker());
        graphics.fillRoundRect(0, -1, width - 1, height - 1, arcs.width, arcs.height);// paint background
        graphics.setColor(colored.darker().darker().darker());
        graphics.drawRoundRect(1, 1, width - 2, height - 2, arcs.width, arcs.height);// paint border
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        graphics.drawRoundRect(2, 2, width - 4, height - 4, arcs.width, arcs.height);
    }

    private static String colorise(Button that) {
        String str = "#FFFFFF";
        try {
            if (that.getX() == 50) {
                return ("#" + JsonManager.getFieldOrNA("Color4",
                        folder.readGame("/Counter Files\\settings.txt")));
            } else if (that.getX() < 150) {
                return ("#" + JsonManager.getFieldOrNA("Color1",
                        folder.readGame("/Counter Files\\settings.txt")));
            } else if (that.getX() > 350) {
                return ("#" + JsonManager.getFieldOrNA("Color2",
                        folder.readGame("/Counter Files\\settings.txt")));
            } else if (that.getY() < 250) {
                return ("#" + JsonManager.getFieldOrNA("Color3",
                        folder.readGame("/Counter Files\\settings.txt")));
            } else if (that.getY() > 250) {
                return ("#" + JsonManager.getFieldOrNA("Color4",
                        folder.readGame("/Counter Files\\settings.txt")));
            }
        } catch (Exception e) {
            return str;
        }
        return str;
    }
}