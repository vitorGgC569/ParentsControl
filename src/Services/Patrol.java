package Services;

import Entities.Process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Patrol {

    public static void monitorarProcessos() {
        ArrayList<Entities.Process> processos = ProcessService.desserializarTodos();

        System.out.println("Monitorando processos... Pressione Ctrl + C para encerrar.");

        while (true) {
            for (Process processo : processos) {
                try {
                    java.lang.Process check = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq " + processo.getProcessNameAndExtension() + "\"");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(check.getInputStream()));
                    String line;
                    boolean ativo = false;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(processo.getProcessNameAndExtension())) {
                            ativo = true;
                            break;
                        }
                    }

                    if (ativo) {
                        ProcessService.finalizar(processo.getProcessNameAndExtension());
                        ProcessService.registrarRemocao(processo.getProcessNameAndExtension());
                    }

                    Thread.sleep(1500);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
