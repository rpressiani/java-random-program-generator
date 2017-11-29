package system.controller;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        new File("generatedSrc/main/java").mkdirs();
    }

}
