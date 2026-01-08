package util; import java.nio.file.*;import java.util.*;
public class CSVWriter {
    public static void write(String p, List<String> d) {
        try {
            Files.write(Paths.get(p), d);
        } catch (Exception e) {
            System.out.println("Gagal menulis CSV: " + p);
            e.printStackTrace();
        }
    }
}
