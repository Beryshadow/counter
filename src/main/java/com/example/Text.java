package com.example;

import javax.swing.*;

import java.awt.*;

public class Text extends JLabel {

    Text(int Number) {
        this.setText(JsonManager.getFieldOrNA("Value" + Number,
                folder.readGame("/Counter Files\\settings.txt")));
        this.setForeground(Color.white);
        Font font = new Font("Segoe UI", Font.BOLD, 40);
        this.setFont(font);
        this.setOpaque(false);
    }

    Text(String string) {
        this.setText(string);
        this.setForeground(Color.white);
        Font font = new Font("Segoe UI", Font.BOLD, 40);
        this.setFont(font);
        this.setOpaque(false);
    }

    Text(String string, int size) {
        this.setText(string);
        this.setForeground(Color.white);
        Font font = new Font("Segoe UI", Font.BOLD, size);
        this.setFont(font);
        this.setOpaque(false);
    }
}