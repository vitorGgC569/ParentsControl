package Gui;

import Entities.Process;
import Services.ProcessService;

import javax.swing.*;
import java.awt.*;

import static Services.Patrol.monitorarProcessos;

public class SubmmitButton extends JButton {
    public SubmmitButton() {
        setText("Enviar Processo");
        setBounds(500, 300, 200, 50);
        setFont(new Font("Arial", Font.BOLD, 20));
        setForeground(Color.white);
        setBackground(new Color(21, 47, 225, 173));

    }
}
