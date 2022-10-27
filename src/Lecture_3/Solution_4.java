package Lecture_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Solution_4 {
    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int[] result = new int[257];
        try (BufferedReader bR = new BufferedReader(
                new InputStreamReader(System.in));
             FileInputStream fIS = new FileInputStream(bR.readLine())) {
            while (fIS.available() > 0) {
                result[fIS.read()] += 1;
            }

            for (Integer x : result) {
                if (x < min && x >= 1) {
                    min = x;
                }
            }

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] == min && result[i] > 0 ? i + " " : "");
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}