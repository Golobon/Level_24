package Lecture_11_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bR.readLine();
        String path2 = bR.readLine();
        bR.close();
        FileReader fR1 = new FileReader(path1);
        List<Character>list = new ArrayList<>();
        while (fR1.ready()) {
            list.add((char) fR1.read());
        }
        fR1.close();
        FileReader fR2 = new FileReader(path2);
        FileWriter fW2 = new FileWriter(path1);
        while (fR2.ready()) {
            char ch = (char) fR2.read();
            fW2.write(ch);
        }
        for(Character x : list) {
            fW2.write(x);
        }
        fR2.close();
        fW2.flush();
        fW2.close();
    }
}

