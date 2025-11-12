package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TextArea extends JTextArea{
    public TextArea() {
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
        setBackground(Color.white);
        setCaretPosition(0);
        setText("Aqui estou eu");
        setVisible(true);
        setFocusable(true);
        requestFocus();
        requestFocusInWindow();
        setBounds(50, 25, 400, 500);
    }
}
