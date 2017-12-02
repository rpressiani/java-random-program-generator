package system.controller;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;

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

}
