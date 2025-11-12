package Gui;

import javax.swing.*;
import java.awt.*;

public class PainelDeFundo extends JPanel {
    private Image imagem;

    public PainelDeFundo() {
        imagem = new ImageIcon("C:\\SpringBoot\\ParentsControl\\src\\imgs\\Wallpaper.png").getImage();
        setLayout(null); // pra permitir setBounds nos botões
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
    }
}
