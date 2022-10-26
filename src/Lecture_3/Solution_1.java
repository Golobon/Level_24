package Lecture_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Максимальный байт
*/

public class Solution_1 {
    public static void main(String[] args) throws Exception {
        ArrayList<Byte> list = new ArrayList<>();
        try (BufferedReader bR = new BufferedReader(
             new InputStreamReader(System.in));
             FileInputStream fIS = new FileInputStream(bR.readLine())) {
            while (fIS.available() > 0) {
                list.add((byte) fIS.read());
            }
            System.out.println(list);
            Collections.sort(list);
            System.out.println(list.get(list.size() - 1));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
