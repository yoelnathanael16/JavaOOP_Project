package util; import java.nio.file.*;import java.util.*;
public class CSVReader{ public static List<String> read(String p){
 try{return Files.readAllLines(Paths.get(p));}catch(Exception e){e.printStackTrace();return List.of();}}}