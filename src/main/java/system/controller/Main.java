package system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
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
import java.util.concurrent.TimeoutException;

public class Main {

    public static Config config;

    public static void main(String[] args){

        initConfig();
        Parser parser = new Parser();

        new File("generatedSrc/main/java").mkdirs();

        int numOfClass = 5;
        boolean run = true;
        int timeout = 1000;
        NormalClassDeclaration cl = null;
        String className = "";
        String basePath = "generatedSrc/main/java/";
        ScopeTable classScopeTable = null;
        List<String> classNames = new ArrayList<>();

        for(int i =0; i<numOfClass;i++){

            String oldClassName = className;
            className = "Main" + i;
            if(cl == null) {
                className = "Main";
                classNames.add(className+".java");
                try {
                    cl = new NormalClassDeclaration(className);
                } catch (Exception e) {
                    Logger.logError("CLASS: "+ className, "Generation failed");
                    e.printStackTrace();
                    return;
                }
            }else{
                classNames.add(className+".java");
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

        }
        if (CompileChecker.compileCheck(classNames) == 0) {
            Logger.log("compiler", "Compilation successful");
        } else {
            Logger.logError("compiler","Compilation failed");
        }

//        try {
//            Runtime.getRuntime().exec("java "+basePath+"Main4.class");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if(run){

            try {
                System.out.println("Running");
                executeCommandLine("java "+basePath+"Main4.class",timeout);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } catch (InterruptedException e) {
                System.out.println("Interrupt");
                e.printStackTrace();
                return;
            } catch (TimeoutException e) {
                System.out.println("Timeout");
                e.printStackTrace();
                return;
            }
            System.out.println("End execution");
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
        try {
            Files.write(f.toPath(), sourceLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int executeCommandLine(final String commandLine, final long timeout) throws IOException, InterruptedException, TimeoutException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(commandLine);
        Worker worker = new Worker(process);
        worker.start();
        try {
            worker.join(timeout);
            if (worker.exit != null)
                return worker.exit;
            else
                throw new TimeoutException();
        } catch(InterruptedException ex) {
            worker.interrupt();
            Thread.currentThread().interrupt();
            throw ex;
        } finally {
            process.destroy();
        }
    }

}
