package utils;

public class Logger {

    public static void log(String entity, String message) {
        System.out.println("[" + entity.toUpperCase() + "] " + message);
    }

    public static void logError(String entity, String message) {
        System.err.println("[" + entity.toUpperCase() + "] " + message);
    }

}
