package Lecture_5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/*
Подсчет запятых
*/

public class Solution_2 {
    public static void main(String[] args) {
        int count = 0;
        try (BufferedReader bR = new BufferedReader(
                new InputStreamReader(System.in));
             FileInputStream fIS = new FileInputStream(bR.readLine())) {



            while (fIS.available() > 0) {
                int value = fIS.read();
                if (value == 44) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
