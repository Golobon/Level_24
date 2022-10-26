package Lecture_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Максимальный байт
*/

public class Solution_2 {
    public static void main(String[] args) {
        byte res = Byte.MAX_VALUE;
        try (BufferedReader bR = new BufferedReader(
                new InputStreamReader(System.in));
             FileInputStream fIS = new FileInputStream(bR.readLine())) {
            while (fIS.available() > 0) {
                byte res1 = (byte) fIS.read();
                if (res1 < res) {
                    res = res1;
                }
            }
            System.out.println(res);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
