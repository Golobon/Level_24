package Lecture_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Сортировка байт
*/

public class Solution_5 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader bR = new BufferedReader(
                new InputStreamReader(System.in));
             FileInputStream fIS = new FileInputStream(bR.readLine())) {
            while (fIS.available() > 0) {
                list.add(fIS.read());
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j)) && i != j) {
                        list.remove(list.get(j));
                        j--;
                    }
                }
            }
            Collections.sort(list);
            list.forEach(s -> System.out.print(s + " "));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

