package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    private static final String GET_ACTION = "1";
    private static final String SAVE_ACTION = "2";
    private static final String EXIT_ACTION = "3";

    public Scanner scanner = new Scanner(System.in);
    private AbstractCache<String, String> cache;

    public void emulate() {
        System.out.println("Enter directory: ");
        String dir = scanner.nextLine();
        cache = new DirFileCache(dir);
        String input;
        String answer;
        do {
            System.out.println();
            System.out.println("Choose menu number");
            System.out.println("1. Get Content From Cache");
            System.out.println("2. Save Content In Cache");
            System.out.println("3. Exit");
            answer = scanner.nextLine();
            switch (answer) {
                case GET_ACTION -> {
                    System.out.println("Enter filename to get content: ");
                    input = scanner.nextLine();
                    String result = cache.get(input);
                    System.out.println("Content: ");
                    System.out.println(result);
                }
                case SAVE_ACTION -> {
                    System.out.println("Enter filename to save content: ");
                    input = scanner.nextLine();
                    cache.save(input);
                    System.out.println("Saved");

                }
                case EXIT_ACTION -> {
                    System.out.println("Exit");
                    return;
                }
                default -> System.out.println("Incorrect menu number");
            }
        } while (true);
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.emulate();
    }
}
