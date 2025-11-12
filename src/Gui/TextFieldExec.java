package Gui;

import javax.swing.*;

public class TextFieldExec extends JTextField {
    public TextFieldExec()
    {
        setVisible(true);
        setEditable(true);
        setText("Executavel: ");
        setBounds(500, 220, 200, 30);
    }

    @Override
    public String getText() {
        String texto = super.getText();
        if (texto.equals("Nome:") || texto.equals("Descrição:") || texto.equals("Executavel:")) {
            return "";
        }
        return super.getText();
    }
}
