package Lecture_11_7;

import java.io.*;

/*
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bR.readLine();
        String path2 = bR.readLine();
        String path3 = bR.readLine();
        FileReader fR1 = new FileReader(path2);
        FileWriter fW1 = new FileWriter(path1);
        while (fR1.ready()) {
            char ch = (char) fR1.read();
            fW1.write(ch);
        }
        fR1.close();
        fW1.flush();
        fW1.close();

        FileReader fR2 = new FileReader(path3);
        FileWriter fW2 = new FileWriter(path1, true);
        while (fR2.ready()) {
            char ch = (char) fR2.read();
            fW2.write(ch);
        }
        fR2.close();
        fW2.flush();
        fW2.close();
    }
}

