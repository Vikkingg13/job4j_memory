package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
            result = Files.readString(Path.of(cachingDir, key));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
