package ru.job4j.cache;

import org.junit.Test;

import java.io.*;
import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class EmulatorTest {

    @Test
    public void whenRunEmulatorThenOutputMessages() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        StringJoiner input = new StringJoiner(System.lineSeparator());
        input.add("src/main/resources/text/")
                .add("1")
                .add("Names.txt")
                .add("2")
                .add("Positions.txt")
                .add("3");
        InputStream is = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(is);

        Emulator emulator = new Emulator();
        emulator.emulate();

        String output = os.toString();
        String[] result = output.split(System.lineSeparator());
        assertEquals("Enter directory: ", result[0]);

        assertEquals("", result[1]);
        assertEquals("Choose menu number", result[2]);
        assertEquals("1. Get Content From Cache", result[3]);
        assertEquals("2. Save Content In Cache", result[4]);
        assertEquals("3. Exit", result[5]);

        assertEquals("Enter filename to get content: ", result[6]);
        assertEquals("Load", result[7]);
        assertEquals("Content: ", result[8]);
        assertEquals("Genadiy", result[9]);
        assertEquals("Maksim", result[10]);
        assertEquals("Natasha", result[11]);
        assertEquals("Viktor", result[12]);
        assertEquals("Petr", result[13]);
        assertEquals("Dmitriy", result[14]);
        assertEquals("Anna", result[15]);
        assertEquals("Sveta", result[16]);
        assertEquals("Yulia", result[17]);
        assertEquals("Sasha", result[18]);

        assertEquals("", result[19]);
        assertEquals("Choose menu number", result[20]);
        assertEquals("1. Get Content From Cache", result[21]);
        assertEquals("2. Save Content In Cache", result[22]);
        assertEquals("3. Exit", result[23]);

        assertEquals("Enter filename to save content: ", result[24]);
        assertEquals("Load", result[25]);
        assertEquals("Saved", result[26]);

        assertEquals("", result[27]);
        assertEquals("Choose menu number", result[28]);
        assertEquals("1. Get Content From Cache", result[29]);
        assertEquals("2. Save Content In Cache", result[30]);
        assertEquals("3. Exit", result[31]);

        assertEquals("Exit", result[32]);
    }
}
