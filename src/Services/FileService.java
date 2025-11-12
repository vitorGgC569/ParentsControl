package Services;

import java.io.*;

public class FileService {

    public static void criarPastasProcessos(String raiz) {
        File file = new File(raiz + File.separator + "processSaved");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Pasta criada: " + file.getAbsolutePath());
            } else {
                System.out.println("Erro ao criar pasta processSaved");
            }
        }

        File file2 = new File(raiz + File.separator + "KilledServices");
        if (!file2.exists()) {
            if (file2.mkdir()) {
                System.out.println("Pasta criada: " + file2.getAbsolutePath());
            } else {
                System.out.println("Erro ao criar pasta KilledServices");
            }
        }

        File finishedFile = new File(file2, "FinishedServices.txt");
        if (!finishedFile.exists()) {
            try {
                if (finishedFile.createNewFile()) {
                    System.out.println("Arquivo criado: " + finishedFile.getAbsolutePath());
                } else {
                    System.out.println("Erro ao criar arquivo FinishedServices.txt");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
