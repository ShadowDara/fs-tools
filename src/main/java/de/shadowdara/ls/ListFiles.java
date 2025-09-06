package de.shadowdara.ls;

import java.io.File;

public class ListFiles {
    public static void run(String workingDir) {
        File folder = new File(workingDir);

        // Dateien und Verzeichnisse auflisten
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("[DIR]  " + file.getName());
                } else {
                    System.out.println("       " + file.getName());
                }
            }
        } else {
            System.out.println("Verzeichnis ist leer oder existiert nicht.");
        }
    }
}
