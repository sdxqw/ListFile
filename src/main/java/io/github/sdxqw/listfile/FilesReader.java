package io.github.sdxqw.listfile;

import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FilesReader {

    public static void searchUp(@NotNull Scanner scn) {
        System.out.println("\nPlease input your dirName: ");
        String dirName = scn.nextLine();

        if (dirName == null || dirName.isEmpty()) return;

        Path path = Paths.get(dirName);
        if (Files.exists(path)) {
            try (Stream<Path> paths = Files.walk(path)) {
                System.out.println("\n");
                System.out.println("We have found some files: ");
                paths.filter(Files::isRegularFile).forEach(e -> {
                    if (e.getFileName().toFile().exists()) {
                        System.out.println("The dir is empty");
                    } else {
                        System.out.println(e.getFileName());
                        try {
                            writeOnFile(e.getFileName().toString());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("\n");
            System.out.println("Directory does not exist!");
        }
    }

    private static void writeOnFile(String files) throws IOException {
        FileWriter fileWriter = new FileWriter("listFile.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(files);
        printWriter.close();
    }

}
