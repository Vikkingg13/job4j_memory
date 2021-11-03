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
        String state;
        do {
            System.out.println("Enter the key to load and get content: ");
            String key = scanner.nextLine();
            String value = cache.get(key);
            System.out.println(value);
            System.out.println("Continue? yes/no");
            state = scanner.nextLine();
        } while (state.equals("yes"));

    }

}
