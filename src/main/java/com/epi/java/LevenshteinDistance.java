package com.epi.java;

import java.util.HashMap;
import java.util.Map;

public class LevenshteinDistance {

    public static Map<Key, Integer> cache = new HashMap<Key, Integer>();

    public static void main(String[] args) {

        int result = levenshteinDistanceRecursive("horse", "house");
        System.out.println("Final result: " + result);
    }

    public static int levenshteinDistanceRecursive(String A, String B) {
        if (A.length() == 0) {
            System.out.println("distance for " + A + "-" + B + " is " + B.length());
            return B.length();
        } else if (B.length() == 0) {
            System.out.println("distance for " + A + "-" + B + " is " + A.length());
            return A.length();
        }
        Key key = new Key(A.length(), B.length());
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int result;
        if (A.charAt(A.length() - 1) == B.charAt(B.length() - 1)) {
            result = levenshteinDistanceRecursive(A.substring(0, A.length() - 1),
                    B.substring(0, B.length() - 1));
            System.out.println("distance for " + A + "-" + B + " is " + result);
        } else {
            int case1 = levenshteinDistanceRecursive(A.substring(0, A.length() - 1),
                    B.substring(0, B.length()));
            int case2 = levenshteinDistanceRecursive(A.substring(0, A.length()),
                    B.substring(0, B.length() - 1));
            int case3 = levenshteinDistanceRecursive(A.substring(0, A.length() - 1),
                    B.substring(0, B.length() - 1));
            result = 1 + Math.min(Math.min(case1, case2), case3);
        }
        cache.put(key, result);
        System.out.println("distance for " + A + "-" + B + " is " + result);
        //assert(levenshteinDistance(A, B) == checkAnswer(A, B));
        return result;
    }

    static class Key {
        int aPrefixLength;
        int bPrefixLength;
        Key(int x, int y) {
            aPrefixLength = x;
            bPrefixLength = y;
        }
        @Override
        public int hashCode() {
            return Integer.valueOf(aPrefixLength).hashCode()
                    + Integer.valueOf(bPrefixLength).hashCode();
        }
        @Override
        public boolean equals(Object obj) {
            Key that = (Key)obj;
            return aPrefixLength == that.aPrefixLength
                    && bPrefixLength == that.bPrefixLength;
        }
        @Override
        public String toString() {
            return "" + aPrefixLength + "," + bPrefixLength;
        }
    }
}
