package de.shadowdara.fstools;

import java.io.File;

public class ListFiles {
    public static void run(String workingDir, Boolean full, Boolean noColor, Boolean show_error, int bytes) {
        File folder = new File(workingDir);

        if (!folder.exists() || !folder.isDirectory()) {
            if (show_error) {
                System.out.println("Path does not exist or is no directory!");
            }
            return;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Directory is empty!");
            return;
        }

        // Erweiterte Ausgabe
        if (full) {
            System.out.printf("%-6s %-30s %15s\n", "Typ", "Name", "Size");
            System.out.println("-------------------------------------------------------------");

            for (File file : files) {
                String name = file.getName();
                String type = file.isDirectory() ? "[DIR]" : "     ";
                long size;

                if (file.isDirectory()) {
                    // Fix: Übergabe des vollständigen Pfads
                    size = FolderSize.run(file.getAbsolutePath(), show_error);
                } else {
                    size = file.length();
                }

                for (int i = 0; i < bytes; i++) {
                    size = size / 1024;
                }

                System.out.printf("%-6s %-30s %15d\n", type, name, size);
            }

        } else {
            // Kompakte Ausgabe ohne Farbe
            if (noColor) {
                for (File file : files) {
                    System.out.print(file.getName() + "\t");
                }
            }
            // Kompakte Ausgabe mit Farbe
            else {
                for (File file : files) {
                    if (file.isDirectory()) {
                        ColorPrint.print(ColorPrint.BLUE, file.getName() + "\t");
                    } else {
                        System.out.print(file.getName() + "\t");
                    }
                }
            }
        }
    }
}
