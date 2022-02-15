package wtbot.wtbot.files;

import java.io.*;

public class FileManager {

    public FileManager(){

    }
    public void mkDirectory(String path){
        File theDir = new File(path);
        if (!theDir.exists()){
            System.out.println("[WTBot] CARPETA NO EXISTENTE, CREAR CARPETA");
            new File(path).mkdirs();
        }
    }
    public void mkFile(String name, String path){
        File file = new File(path+name);
        if(file.exists()){
            System.out.println("[WT Bot] El archivo " + path+name + " ya existe, por lo tanto no ha sido sobre escrito");
            return;
        }
                    PrintWriter exit = null;
        try {
            exit = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
        if (exit != null) {
            exit.close();
        }
        System.out.println("[WT BOT] Archivo: "+ name +  " creado con exito");
    }

    public void writeOnFile(String path, String name, String content) {
        File file = new File(path + name);
        if (file.exists()) {
            PrintWriter exit = null;
            try {
                exit = new PrintWriter(file);
                exit.println(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
            }
            if (exit != null) {
                exit.close();
            }
            System.out.println("[WT BOT] Archivo: " + name + "se ha sobreescrito exitosamente");
        }
    }
}
