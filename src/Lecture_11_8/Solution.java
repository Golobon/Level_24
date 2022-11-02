package Lecture_11_8;

import java.io.*;
import java.util.Arrays;

/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bR.readLine();
        String path2 = bR.readLine();
        bR.close();
        FileReader fR = new FileReader(path1);
        StringBuilder sB = new StringBuilder();

        while (fR.ready()) { Character ch = (char) fR.read(); sB.append(ch); }
        String str = sB.toString();
        String[] arrDub = str.split(" ");
        fR.close();
        FileWriter fW = new FileWriter(path2);
        for (int i = 0; i < arrDub.length; i++) { fW.write(Math.round(Double.parseDouble(arrDub[i])) + " ");}
        fW.flush();
        fW.close();
        System.out.println(Arrays.toString(arrDub)); } }

