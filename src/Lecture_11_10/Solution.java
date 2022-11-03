package Lecture_11_10;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String path = bR.readLine();
        BufferedReader bFR = new BufferedReader(new FileReader(path));
        while (bFR.ready()) {
            String[] product = bFR.readLine().split(" ");
            int id = Integer.parseInt(product[0]);
            if (id == Integer.parseInt(args[0])) {
                for(String x : product) {
                    System.out.print(x + " ");
                }
            }
        }
        bR.close();
        bFR.close();
    }
}

