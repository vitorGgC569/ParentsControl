package Services;

import Entities.Process;
import Services.ProcessService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {

    public static void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int oper = 0;

        while (oper != 3) {
            System.out.println("""
                    1 - Cadastrar novo Processo
                    2 - Verificar processos controlados
                    3 - Sair
                    """);
            oper = sc.nextInt();
            sc.nextLine();

            switch (oper) {
                case 1 -> cadastrarProcesso();
                case 2 -> listarProcessos();
            }
        }
    }

    private static void cadastrarProcesso() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Nome do processo e extensão: ");
        String nomeProc = sc.nextLine();

        ProcessService.serializar(new Process(nome, descricao, nomeProc));
    }

    public static void listarProcessos() {
        ArrayList<Process> processos = ProcessService.desserializarTodos();
        for (Process p : processos) {
            System.out.println("Nome: " + p.getName() + " | Exec: " + p.getProcessNameAndExtension());
        }
    }
}
