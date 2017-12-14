package system.controller;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * https://stackoverflow.com/questions/2946338/how-do-i-programmatically-compile-and-instantiate-a-java-class
 */
public class CompileChecker {

    public static int compileCheck(String fileName) {

        File sourceDir = new File("./generatedSrc/main/java");
        File sourceFile = new File(sourceDir, fileName);

        // Compile source file.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // return 0 for success; nonzero otherwise
        return compiler.run(null, null, null, sourceFile.getPath());

    }

    public static int compileCheck(List<String> fileNames) {

        List<String> toCompile = new ArrayList<>();
        for(String fileName: fileNames) {
            File sourceDir = new File("./generatedSrc/main/java");
            File sourceFile = new File(sourceDir, fileName);
            toCompile.add(sourceFile.getPath());
        }

        String[] stockArr = new String[toCompile.size()];
        stockArr = toCompile.toArray(stockArr);
        // Compile source file.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        String outputDir = "generatedSrc/out";
//        new File("generated/Src/out").mkdirs();
        // return 0 for success; nonzero otherwise
        int result = compiler.run(null, null, null, stockArr);
        File sourceDir = new File("./generatedSrc/main/java");
        File[] compiled =  sourceDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(".class"); }
        } );
        for(File c: compiled) {
            c.renameTo(new File(outputDir+"/"+c.getName()));
        }
//        myFile.renameTo(new File("/the/new/place/newName.file"));

        return result;


    }

}
