package Lecture_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Реверс файла
*/

public class Solution_4 {
    public static void main(String[] args) {
        try (BufferedReader bR = new BufferedReader(
                new InputStreamReader(System.in));
             FileInputStream fIS = new FileInputStream(bR.readLine());
             FileOutputStream fOS1 = new FileOutputStream(bR.readLine())) {
            List <Integer> list = new ArrayList<>();
            while (fIS.available() > 0) {
                list.add(fIS.read());
            }
            Collections.reverse(list);
            for (Integer x : list) {
                fOS1.write(x);
            }
        } catch (IOException e) {
        }
    }
}
