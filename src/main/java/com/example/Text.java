package com.example;

import javax.swing.*;
import java.awt.font.*;
import java.awt.geom.AffineTransform;

import java.awt.*;

public class Text extends JLabel {

    Text(int locationX, int locationY, int width, int height, int Number, boolean visible) {
        // this.setBounds(locationX, locationY, width, height);
        this.setText(":");
        Font font = new Font("Monotype Corsiva", Font.BOLD, 40);
        // this.setForeground(Color.black);
        this.setFont(font);
        this.setBackground(Color.white);
        this.setOpaque(false);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // setBackground(Color.white);
        int w = getSize().width;
        int h = getSize().height;
        Graphics2D g2d = (Graphics2D) g;
        FontRenderContext fontRendContext = g2d.getFontRenderContext();
        Font font = new Font("Monotype Corsiva", Font.BOLD, 40);
        String st = new String(JsonManager.getFieldOrNA("Value1",
                folder.readGame("/Counter Files\\settings.txt")));
        TextLayout text = new TextLayout(st, font, fontRendContext);
        AffineTransform affineTransform = new AffineTransform();
        Shape shape = text.getOutline(null);
        Rectangle rect = shape.getBounds();
        affineTransform = g2d.getTransform();
        affineTransform.translate(-this.getX() + 20, -this.getY() + 20);
        g2d.transform(affineTransform);
        g2d.setColor(Color.black);
        g2d.draw(shape);
        g2d.setClip(shape);
        g2d.setColor(Color.white);
        // this.setOpaque(true);
        g2d.fill(shape.getBounds());
        g2d.draw(shape);
    }
}