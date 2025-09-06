package de.shadowdara.fstools;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //ColorPrint.print(ColorPrint.BLUE, "Willkommen zu fs-tools!");

        Set<String> flags = new HashSet<>(Set.of(args));

        if (flags.contains("--help")) {
            System.out.println("Usage: fs-tools");
            System.out.println("\t[--ls]\tto show all files and folders in a folder");
            System.out.println("\t\t[-f]\tto show the full content with more infos");
            System.out.println("\t\t[-nc]\to suppres colored output");
            System.out.println("\t[--help]");
            return;
        }

        if (flags.contains("--license")) {
            License.run();
        }

        if (flags.contains("--ls")) {
            Boolean full = false;
            Boolean colored = true;

            if (flags.contains("-f")) {
                full = true;
            }
            if (flags.contains("-nc")) {
                colored = false;
            }

            String workingDir = System.getProperty("user.dir");
            ListFiles.run(workingDir, full, colored);
            return;
        }

        if (args.length == 0) {
            System.out.println("Zero Arguments Provided!\nRun with --help for more Information!");
            return;
        }
    }
}
