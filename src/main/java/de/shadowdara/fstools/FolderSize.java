package de.shadowdara.fstools;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderSize {
    public static long getFolderSize(Path path, Boolean show_error) throws IOException {
        final long[] size = {0};

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                // Symbolische Links überspringen
                if (!Files.isSymbolicLink(file)) {
                    size[0] += attrs.size();
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                // Fehler beim Zugriff auf einzelne Dateien protokollieren, aber nicht abbrechen
                if (show_error) {
                    System.err.println("Acces denied or File Error: " + file);
                    System.err.println("Reason: " + exc.getMessage());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                // Symbolische Links bei Verzeichnissen überspringen, um Endlosschleifen zu vermeiden
                if (Files.isSymbolicLink(dir)) {
                    if (show_error) {
                        System.out.println("Skip Link: " + dir);
                    }
                    return FileVisitResult.SKIP_SUBTREE;
                }
                return FileVisitResult.CONTINUE;
            }
        });

        return size[0];
    }

    public static long run(String folder_string, Boolean show_error) {
        Path folder = Paths.get(folder_string);

        if (!Files.exists(folder) || !Files.isDirectory(folder)) {
            if (show_error) {
                System.out.println("Path does not exist is is not a directory.");
            }
            return 0;
        }

        try {
            long sizeBytes = getFolderSize(folder, show_error);
            return sizeBytes;
        } catch (IOException e) {
            if (show_error) {
                System.err.println("Error while calculating Foldersize:");
                e.printStackTrace();
            }
        }
        return 0;
    }
}
