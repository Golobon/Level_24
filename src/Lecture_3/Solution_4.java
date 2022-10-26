package Lecture_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_4 {
    public static void main(String[] args) {
        int count = 0;
        ArrayList<Byte> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        try (BufferedReader bR = new BufferedReader(
                new InputStreamReader(System.in));
             FileInputStream fIS = new FileInputStream(bR.readLine())) {
            while (fIS.available() > 0) {
                list.add((byte) fIS.read());
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j)) && j != i) {
                        count = count + 1;
                    }
                }
                result.add(count);
                count = 0;
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.println("элемент " + list.get(i) + " повторяется " +
                        result.get(i) + " раз");
            }

            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j)) && j != i) {
                        ;
                        list.set(j, (byte) -1);
                        result.set(j, -1);
                    }
                }
            }

            System.out.println();

            for (int i = 0; i < list.size(); i++) {
                System.out.println("элемент " + list.get(i) + " повторяется " +
                        result.get(i) + " раз");
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals((byte)-1)) {
                    list.remove(i);
                    result.remove(i);
                    i--;
                }
            }

            System.out.println();

            for (int i = 0; i < list.size(); i++) {
                System.out.println("элемент " + list.get(i) + " повторяется " +
                        result.get(i) + " раз");
            }

            int max = 0;
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) > max) max = result.get(i);
            }

            for (int i = 0; i < list.size(); i++) {
                if (max >0 && result.get(i).equals(max)) System.out.print(list.get(i) +" ");
            }

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}