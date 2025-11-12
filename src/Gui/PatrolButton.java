package Gui;

import javax.swing.*;
import java.awt.*;

import static Services.Patrol.monitorarProcessos;

public class PatrolButton extends JButton {
    public PatrolButton(){
        setText("Iniciar Monitoramento");
        setBounds(300, 500, 250, 50);
        setFont(new Font("Arial", Font.BOLD, 20));
        setForeground(Color.white);
        setBackground(Color.GRAY);

        addActionListener(e -> {
            monitorarProcessos();
        });
    }
}
