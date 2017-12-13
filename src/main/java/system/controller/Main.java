package system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import sun.reflect.generics.scope.Scope;
import system.controller.parser.Parser;
import system.model.ScopeTable;
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
        Parser parser = new Parser();

        new File("generatedSrc/main/java").mkdirs();

        int numOfClass = 5;
        NormalClassDeclaration cl = null;
        String className = "";
        String basePath = "generatedSrc/main/java/";
        ScopeTable classScopeTable = null;

        for(int i =0; i<numOfClass;i++){

            String oldClassName = className;
            className = "Main" + i;
            if(cl == null) {
                className = "Main";
                try {
                    cl = new NormalClassDeclaration(className);
                } catch (Exception e) {
                    Logger.logError("CLASS: "+ className, "Generation failed");
                    e.printStackTrace();
                    return;
                }
            }else{
                System.out.println("Guardo: " + basePath + oldClassName +".java");
                classScopeTable = parser.getClassScopeTable(new File(basePath + oldClassName +".java"), classScopeTable);
                try {
                    cl = new NormalClassDeclaration(className, classScopeTable);
                } catch (Exception e) {
                    Logger.logError("CLASS: "+ className, "Generation failed");
                    e.printStackTrace();
                    return;
                }
            }
            Logger.log("CLASS: "+ className, "Generation successful");

            if (cl != null) {
                save(cl, basePath + className +".java");
            }

            if (CompileChecker.compileCheck(basePath + className +".java") == 0) {
                Logger.log("compiler", "Compilation successful");
            } else {
                Logger.logError("compiler","Compilation failed");
            }
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

    private static void save(Node node, String path) {

        List<String> sourceLines = new ArrayList<>();
        sourceLines.add(node.produce());

        File f = new File(path);
        System.out.println(f.toPath());
        try {
            Files.write(f.toPath(), sourceLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
