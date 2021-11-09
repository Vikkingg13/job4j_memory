package ru.job4j.cache;

import ru.job4j.cache.product.AbstractCache;
import ru.job4j.cache.product.DirFileCache;

import java.util.Scanner;

public class Emulator {

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
                case "1" -> {
                    System.out.println("Enter filename to get content: ");
                    input = scanner.nextLine();
                    String result = cache.get(input);
                    System.out.println("Content: ");
                    System.out.println(result);
                }
                case "2" -> {
                    System.out.println("Enter filename to save content: ");
                    input = scanner.nextLine();
                    cache.save(input);
                    System.out.println("Saved");

                }
                case "3" -> {
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
