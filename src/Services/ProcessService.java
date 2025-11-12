package Services;

import Entities.Process;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ProcessService implements Serializable {

    private static final String BASE_PATH = "C:\\SpringBoot\\ParentsControl";

    public static void serializar(Process processo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(String.format(BASE_PATH + "\\processSaved\\%s %d.fuck", processo.getName(), processo.getId())))) {
            oos.writeObject(processo);
            System.out.println("Objeto salvo!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Process> desserializarTodos() {
        ArrayList<Process> processos = new ArrayList<>();
        File pasta = new File(BASE_PATH + "\\processSaved");

        File[] arquivos = pasta.listFiles((dir, nome) -> nome.endsWith(".fuck"));
        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum arquivo .fuck encontrado.");
            return processos;
        }

        for (File file : arquivos) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Process processo = (Process) ois.readObject();
                processos.add(processo);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao ler arquivo: " + file.getName());
            }
        }

        return processos;
    }

    public static void finalizar(String nomeProcesso) {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM " + nomeProcesso);
            System.out.println("Processo finalizado: " + nomeProcesso);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registrarRemocao(String nomeProcesso) {
        String raiz = System.getProperty("user.dir");
        LocalDateTime ldt = LocalDateTime.now();
        File file = new File(raiz + File.separator + "KilledServices" + File.separator + "FinishedServices.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.append("Nome: ").append(nomeProcesso).append(" foi removido às: ").append(ldt.toString()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
