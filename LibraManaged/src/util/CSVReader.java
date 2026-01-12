package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CSVReader {

    public static List<String> read(String resourcePath) {
        try {
            InputStream is = CSVReader.class.getResourceAsStream(resourcePath);

            if (is == null) {
                throw new RuntimeException("File tidak ditemukan: " + resourcePath);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            return br.lines().toList();

        } catch (Exception e) {
            System.err.println("Gagal membaca CSV: " + resourcePath);
            e.printStackTrace();
            return List.of();
        }
    }
}
