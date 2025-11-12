package Entities;

import java.io.Serial;
import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Process implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static int contador = 0;
    private static final String ARQUIVO_CONTADOR = "process_id.ser";

    private int id;
    private String Name;
    private String Description;
    private String processNameAndExtension;

    // Construtor
    public Process(String name, String description, String processNameAndExtension) {
        carregarContador();
        this.id = ++contador;
        salvarContador();
        this.Name = name;
        this.Description = description;
        this.processNameAndExtension = processNameAndExtension;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getProcessNameAndExtension() {
        return processNameAndExtension;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setProcessNameAndExtension(String processNameAndExtension) {
        this.processNameAndExtension = processNameAndExtension;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", processNameAndExtension='" + processNameAndExtension + '\'' +
                '}';
    }

    private static void salvarContador() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTADOR))) {
            oos.writeObject(contador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void carregarContador() {
        File f = new File(ARQUIVO_CONTADOR);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                contador = (Integer) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
