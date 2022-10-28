package Lecture_5;

import java.io.*;

public class Solution_3 {
    public static void main(String[] args) {
        try (BufferedReader bR = new BufferedReader(
                new InputStreamReader(System.in));
             FileInputStream fIS = new FileInputStream(bR.readLine());
             FileOutputStream fOS1 = new FileOutputStream(bR.readLine());
             FileOutputStream fOS2 = new FileOutputStream(bR.readLine())) {
            byte[] buffer = new byte[fIS.available()];

            int sHalf = fIS.available() / 2;
            int fHalf = fIS.available() - sHalf;

            fIS.read(buffer);
            fOS1.write(buffer, 0, fHalf);
            fOS2.write(buffer, fHalf, sHalf);
        } catch (IOException e) {
        }
    }
}
