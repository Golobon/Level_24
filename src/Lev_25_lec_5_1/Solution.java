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
        BufferedReader bR2 = new BufferedReader(new FileReader(path1));
        BufferedWriter bW = new BufferedWriter(new FileWriter(path2));
        while (bR2.ready()) {
            int x = bR2.read();
            if (String.valueOf((char)x).matches("[^\\p{Punct}\\r\\n]")) {
                bW.write((char)x); } }
        bR.close();
        bR2.close();
        bW.close();
    }
}
