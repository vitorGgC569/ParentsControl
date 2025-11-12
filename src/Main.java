import Gui.Screen;
import Services.*;
import Entities.Process;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {
        String raiz = System.getProperty("user.dir");
        FileService.criarPastasProcessos(raiz);
       /* MenuService.exibirMenu();

        ArrayList<Process> processos = ProcessService.desserializarTodos();
        for (Process processo : processos) {
            ProcessService.finalizar(processo.getProcessNameAndExtension());
            ProcessService.registrarRemocao(processo.getProcessNameAndExtension());
        }*/
       //monitorarProcessos();
        new Screen();
    }
}
