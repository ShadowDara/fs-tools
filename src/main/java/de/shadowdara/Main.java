package de.shadowdara;

import de.shadowdara.ls.FolderSize;
import de.shadowdara.ls.ListFiles;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Zero Arguments Provided!\nRun with --help for more Information!");
            return;
        }

        //System.out.println("Anzahl der Argumente: " + args.length);

        //FolderSize.run("C:\\users\\schueler");

        int settings = 0;
        // Settings
        // --ls     =   +1
        // -s       =   +2

        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], "--help")) {
                System.out.println("Helps Comming Soon!");
            }
            else if (Objects.equals(args[i], "--ls")) {
                settings += 256;
            }
        }

        if (settings >= 256) {
            String workingDir = System.getProperty("user.dir");
            ListFiles.run(workingDir);
        }

        String version = System.getProperty("java.version");
        System.out.println("Java-Version: " + version);
    }
}
