package com.bpawan.util;

public class StringHelper {
    public static Boolean stringEqual(String first, String second) {
        return first
                .replaceAll("\\s+", "")
                .equalsIgnoreCase(second.replaceAll("\\s+", ""));
    }

    public static String normalizeString(String input) {
         return input.trim()
                .toLowerCase()
                .replaceAll("\\s+","");
    }
}
