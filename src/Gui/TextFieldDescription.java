package Gui;

import javax.swing.*;

public class TextFieldDescription extends JTextField {
    public TextFieldDescription() {
        setVisible(true);
        setEditable(true);
        setText("Descrição: ");
        setBounds(500, 160, 200, 30);
    }

    @Override
    public String getText() {
        String texto = super.getText();
        if (texto.equals("Nome:") || texto.equals("Descrição:") || texto.equals("Executavel:")) {
            return "";
        }
        return texto;
    }
}
