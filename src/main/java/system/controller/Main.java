package system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import system.model.nodes.Node;
import system.model.nodes.classes.NormalClassDeclaration;
import utils.Config;
import utils.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Config config;

    public static void main(String[] args) {

        initConfig();

        new File("generatedSrc/main/java").mkdirs();

        NormalClassDeclaration cl = null;
        try {
            cl = new NormalClassDeclaration("Main");
        } catch (Exception e) {
            Logger.logError("MAIN", "Generation failed");
            e.printStackTrace();
            return;
        }
        Logger.log("MAIN", "Generation successful");

        if (cl != null) {
            save(cl);
        }

        if (CompileChecker.compileCheck("Main.java") == 0) {
            Logger.log("compiler", "Compilation successful");
        } else {
            Logger.logError("compiler","Compilation failed");
        }

    }

    private static void initConfig() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            config = mapper.readValue(new File("src/main/resources/conf.yaml"), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
