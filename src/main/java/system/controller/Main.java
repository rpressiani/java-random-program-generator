package system.controller;

import system.model.nodes.Node;
import system.model.nodes.NormalClassDeclaration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new File("generatedSrc/main/java").mkdirs();

        NormalClassDeclaration cl = new NormalClassDeclaration();

        save(cl);

    }

    private static void save(Node node) {

        List<String> sourceLines = new ArrayList<>();
        sourceLines.add(node.produce());

        File f = new File("generatedSrc/main/java/Main.java");

        try {
            Files.write(f.toPath(), sourceLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
