package Gui;

import Entities.Process;
import Services.ProcessService;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    public Screen() {
        setTitle("Parents Control Panel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        // Ícone da janela
        ImageIcon icon = new ImageIcon("C:\\SpringBoot\\ParentsControl\\src\\imgs\\icon.png");
        setIconImage(icon.getImage());

        // Painel de fundo
        PainelDeFundo panel = new PainelDeFundo();
        setContentPane(panel);
        panel.setLayout(null);

        // JTextArea com scroll
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setText("Cuide de quem você mais ama e se importa");
        textArea.setFont(new Font("Arial", Font.BOLD, 20));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 50, 400, 200);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

        // Campos de texto
        JTextField nome = new TextFieldNome();
        JTextField description = new TextFieldDescription();
        JTextField exec = new TextFieldExec();
        panel.add(nome);
        panel.add(description);
        panel.add(exec);

        // Botão salvar
        JButton botaoSalvar = new SubmmitButton();
        //botaoSalvar.setBounds(150, 300, 150, 50);
        botaoSalvar.addActionListener(e -> {
            Process p = new Process(nome.getText(), description.getText(), exec.getText());
            System.out.println("Serializando: " + p);
            ProcessService.serializar(p);
            botaoSalvar.setEnabled(false);
            new javax.swing.Timer(2000, ev -> botaoSalvar.setEnabled(true)).start();
        });
        panel.add(botaoSalvar);

        // Botão patrol
        JButton patrolButton = new PatrolButton();
        patrolButton.setBounds(500, 500, 250, 50);
        panel.add(patrolButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Screen::new);
    }
}
