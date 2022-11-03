package Lecture_11_9;

import java.io.*;
import java.util.*;

/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        FileReader fR1 = new FileReader(path);
        Map<Character, Integer> treeMap = new TreeMap<>();
        List<Character> list = new ArrayList<>();

        while (fR1.ready()) {
            char ch = (char) fR1.read();
            treeMap.put(ch, 0);
            list.add(ch);
        }
        fR1.close();

        for (Character x : treeMap.keySet()) {
            for (int i = 0; i < list.size(); i++) {
                if (x.equals(list.get(i))) {
                    treeMap.replace(x, treeMap.get(x) + 1);
                }
            }
        }
        for (Character x : treeMap.keySet()) {
            System.out.println(x + " " + treeMap.get(x));
        }
    }
}

