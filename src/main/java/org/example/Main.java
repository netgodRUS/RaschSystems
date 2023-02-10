package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of strings: ");
        int n = scanner.nextInt();
        String[] inputs = new String[n];
        System.out.println("Enter the strings: ");
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.next();
        }

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            char[] chars = inputs[i].toCharArray();
            java.util.Arrays.sort(chars);
            String sortedString = new String(chars);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, String.valueOf(i));
            } else {
                String indexes = map.get(sortedString);
                indexes = "%s, %s".formatted(indexes, String.valueOf(i));
                map.put(sortedString, indexes);
            }
        }

        for (String key : map.keySet()) {
            String value = map.get(key);
            if (value.contains(",")) {
                System.out.println(key + " = " + value);
            }
        }
    }
}
