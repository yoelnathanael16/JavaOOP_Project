package util;

import java.io.*;
import java.util.*;

public class CSVWriter {
    public static void write(String path, List<String> lines) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
        bw.close();
    }
}