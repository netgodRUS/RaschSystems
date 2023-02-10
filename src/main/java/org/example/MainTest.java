package org.example;

import org.junit.Test;

import java.util.Scanner;

public class MainTest {
    @Test
    public void testCharCountInput() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings: ");
        int n = sc.nextInt();

        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter string " + (i+1) + ": ");
            inputs[i] = sc.next();
        }

        int[][] charCounts = new int[n][26];
        for (int i = 0; i < n; i++) {
            String s = inputs[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                int index = (c >= 'a' && c <= 'z') ? (c - 'a') : ((c >= 'A' && c <= 'Z') ? (c - 'A') : -1);
                if (index >= 0) {
                    charCounts[i][index]++;
                }
            }
        }

        int[] totalCharCounts = new int[26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                totalCharCounts[j] += charCounts[i][j];
            }
        }

        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'a');
            System.out.println(c + " = " + totalCharCounts[i]);
        }
    }
}

