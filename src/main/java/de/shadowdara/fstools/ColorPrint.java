package de.shadowdara.fstools;

public class ColorPrint {
    // ANSI-Farbcodes
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void print(String color, String message) {
        System.out.print(color + message + RESET);
    }

    public static void println(String color, String message) {
        print(color, message + "\n"); // alias
    }

    public static void printError(String message) {
        print(RED, "ERROR: " + message);
    }

    public static void printSuccess(String message) {
        print(GREEN, "SUCCESS: " + message);
    }

    public static void printWarning(String message) {
        print(YELLOW, "WARNING: " + message);
    }

    public static void printInfo(String message) {
        print(CYAN, "INFO: " + message);
    }
}
