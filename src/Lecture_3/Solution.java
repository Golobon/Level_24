package Lecture_3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Знакомство с тегами
*/

public class Solution {
    public static int indexFirst;
    public static int indexNext;
    public static int count;
    public static String str = "";
    public static String teg;

    public static int[] Method1(String str) {

        indexFirst = str.indexOf("<" + teg);
        indexNext = str.indexOf("</" + teg + ">");
        String strShare = str.substring(indexFirst + teg.length() + 1, indexNext);
        while (strShare.contains("<" + teg)) {
            indexFirst = indexNext + 2;
            indexNext = str.indexOf("</" + teg + ">", indexNext + teg.length() + 3);
            strShare = str.substring(indexFirst + teg.length() + 1, indexNext);
        }
        int[] index = new int[2];
        index[0] = str.indexOf("<" + teg);
        index[1] = indexNext;
        str = str.substring(str.indexOf("<" + teg), indexNext + teg.length() + 3);
        System.out.println(str);
        return index;
    }

    public static void main(String[] args) throws IOException {
        teg = "таг";//args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        StringBuilder stringBuilder = new StringBuilder(str);
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {
            while (reader1.ready()) {
                stringBuilder.append(reader1.readLine());
            }
        }
        str = stringBuilder.toString();

        while (str.contains("<" + teg)) {
            int[] index = Solution.Method1(str);
            str = str.substring(0, index[0]) + str.substring(index[0] + teg.length() + 2, index[1]) + str.substring(index[1] + teg.length() + 3);
        }
    }
}
