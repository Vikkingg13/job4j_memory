package ru.job4j.cache.product;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        System.out.println("Load");
        String result = null;
        try {
            result = Files.readString(Path.of(cachingDir + key));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
