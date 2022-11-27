package Lev_25_lec_5_1;

import java.io.*;


/*
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bR.readLine();
        String path2 = bR.readLine();
        FileReader fR = new FileReader("111.");
        FileWriter fW = new FileWriter(path2);
        StringBuilder sB = new StringBuilder();
        while (fR.ready()) {
            int x = fR.read();
            sB.append((char) x);
        }
        String[] str = sB.toString().split("[\\d][\\d]");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("[\\d][\\d]")) {
            }
        }
        bR.close();
        fR.close();
    }
}
