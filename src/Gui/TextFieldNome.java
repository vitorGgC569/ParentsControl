package Gui;

import javax.swing.*;

public class TextFieldNome extends JTextField {

    public TextFieldNome() {
        setVisible(true);
        setEditable(true);
        setText("Nome:");
        setBounds(500, 100, 200, 30);
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
