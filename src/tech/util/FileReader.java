package tech.util;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public static List<String> read(String filePath, String fileName) {
        Path path = Paths.get(filePath, fileName);
        List<String> data;
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            data = bufferedReader.lines().collect(Collectors.toList());
            return data;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
