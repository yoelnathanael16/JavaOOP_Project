package util;

public class InputValidator {
    public static boolean isNotEmpty(String s) {
        return s != null && !s.trim().isEmpty();
    }
}