package Lecture_11_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String path = bR.readLine();
        BufferedReader bRIS = new BufferedReader(new FileReader(path));
        FileWriter fW = new FileWriter(path, true);
        if (args.length != 0 && args[0].equals("-c")) {
            int max;
            List<String> listStr = new ArrayList<>();
            List<Integer> listInt = new ArrayList<>();
            while (bRIS.ready()) {
                listStr.add(bRIS.readLine().substring(0, 8));
                for (int i = 0; i < listStr.size(); i++) {
                    listStr.set(i, listStr.get(i).replace(" ", ""));
                    listInt.add(Integer.parseInt(listStr.get(i)));
                }
            }
            Collections.sort(listInt);
            max = listInt.get(listInt.size() - 1);
            System.out.println(max);
            String result = String.format("\n" + "%-8d%-30s%-8s%-4s", ++max, args[1], args[2], args[3]);
            System.out.println(result);
            fW.write(result);
            bR.close();
            bRIS.close();
            fW.close();
        }
    }
}

