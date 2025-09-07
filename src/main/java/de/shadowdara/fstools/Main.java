package de.shadowdara.fstools;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> flags = new HashSet<>(Set.of(args));

        if (flags.contains("--help")) {
            System.out.println("Usage: fs-tools");
            System.out.println("\t[--ls]\tto show all files and folders in a folder");
            System.out.println("\t\t[-f]\tto show the full content with more infos");
            System.out.println("\t\t\t[-0]\tto show the size as Bytes");
            System.out.println("\t\t\t[-1]\tto show the size as KB");
            System.out.println("\t\t\t[-2]\tto show the size as MB");
            System.out.println("\t\t\t[-3]\tto show the size as GB");
            System.out.println("\t\t[-nc]\tto suppres colored output");
            System.out.println("\t\t[-e]\tto show file and directory errors");
            System.out.println("\nMore Information available here:");
            System.out.println("https://github.com/shadowdara/fs-tools");
            return;
        }

        if (flags.contains("--license")) {
            System.out.println("LICENSE available at:");
            System.out.println("https://github.com/shadowdara/fs-tools");
            return;
        }

        // Parameter für --ls
        boolean full = false;
        boolean colored = true;
        boolean show_error = false;
        int bytes = 0;
        String pathForLs = null;

        // Wir gehen die args durch und suchen nach --ls
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--ls":
                    // Wenn nächstes Argument existiert und kein Flag (kein - oder -- am Anfang), dann ist das Pfad
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        pathForLs = args[i + 1];
                        i++; // Wir überspringen den Pfad beim nächsten Durchlauf
                    }
                    break;
                case "-f":
                    full = true;
                    break;
                case "-nc":
                    colored = false;
                    break;
                case "-e":
                    show_error = true;
                case "-0":
                    bytes = 0;
                    break;
                case "-1":
                    bytes = 1; //KB
                    break;
                case "-2":
                    bytes = 2; // MB
                    break;
                case "-3":
                    bytes = 3; // GB
                    break;
                default:
                    // Andere Argumente ignorieren
                    break;
            }
        }

        if (flags.contains("--ls")) {
            if (pathForLs == null) {
                pathForLs = System.getProperty("user.dir");
            }
            ListFiles.run(pathForLs, full, colored, show_error, bytes);
            return;
        }

        if (args.length == 0) {
            System.out.println("Zero Arguments Provided!\nRun with --help for more Information!");
            return;
        }
    }
}
