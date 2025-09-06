package de.shadowdara.fstools;

import java.io.File;

public class ListFiles {
    public static void run(String workingDir, Boolean f, Boolean nc) {
        File folder = new File(workingDir);

        // Dateien und Verzeichnisse auflisten
        File[] files = folder.listFiles();

        if (files != null) {
            // Extended Version
            if (f) {
                System.out.printf("%-5s %-30s %10s\n", "Typ", "Name", "Größe (Bytes)");
                System.out.println("-------------------------------------------------------------");

                for (File file : files) {
                    String name = file.getName();
                    String type = file.isDirectory() ? "[DIR]" : "     ";
                    long size;

                    if (file.isDirectory()) {
                        size = FolderSize.run(file.getName());
                    } else {
                        size = file.length();
                    }

                    System.out.printf("%-5s %-30s %10d\n", type, name, size);
                }

            }

            // Compact Version
            else {
                // Without Colored Output
                if (!nc) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            System.out.print(file.getName() + "\t");
                        } else {
                            System.out.print(file.getName() + "\t");
                        }
                    }
                }

                // With Colored Output
                else {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            //System.out.print(file.getName() + "\t");
                            ColorPrint.print(ColorPrint.BLUE, file.getName() + "\t");
                        } else {
                            System.out.print(file.getName() + "\t");
                        }
                    }
                }
            }
        } else {
            System.out.println("Verzeichnis ist leer oder existiert nicht.");
        }
    }
}
