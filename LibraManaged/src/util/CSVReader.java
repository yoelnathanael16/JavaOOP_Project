package util;

import java.io.*;
import java.util.*;

public class CSVReader {
    public static List<String[]> read(String path) throws IOException {
        List<String[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            data.add(line.split(","));
        }
        br.close();
        return data;
    }
}