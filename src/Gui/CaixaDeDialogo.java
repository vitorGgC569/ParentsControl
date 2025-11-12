package Gui;

import javax.swing.*;
import java.awt.event.ActionListener;

import static Services.MenuService.listarProcessos;

public class CaixaDeDialogo extends JOptionPane {
    private String[] userInfo;
    private String menu = """
                    1 - Cadastrar novo Processo
                    2 - Verificar processos controlados
                    3 - Sair
                    """;
    public CaixaDeDialogo() {
        cadastrarProcesso();
    }

    public void cadastrarProcesso() {
        Integer n = Integer.parseInt(showInputDialog(this.getMenu()));
        switch (n){
            case 1 -> cadastrarProcesso();
            case 2 -> listarProcessos();
            case 3 -> System.exit(0);
        }
    }

    public String getMenu(){
        return this.menu;
    }
}
