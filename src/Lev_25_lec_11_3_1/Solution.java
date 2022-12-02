package Lev_25_lec_11_3_1;

/*
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {
        String path;

        try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
            path = bR.readLine();
        }

        String str;

        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            StringBuilder sB = new StringBuilder();

            while (bRF.ready()) {
                sB.append(bRF.readLine());
            }
            str = sB.toString();
        }

        String v = "таг";//args[0];

        List<String> listStr = new ArrayList<>();
        List<String> listRes = new ArrayList<>();

        String regOp = String.format("<%s", v);
        String regCl = String.format("</%s>", v);

        Pattern pOp = Pattern.compile(regOp);
        Pattern pCl = Pattern.compile(regCl);
        //Pattern pd2 = Pattern.compile("</span");

        Matcher matcherOp = pOp.matcher(str);
        Matcher matcherCl = pCl.matcher(str);

        while (matcherOp.find() && matcherCl.find()) {
            matcherOp.group();
            matcherCl.group();

            listStr.add(matcherOp.start() + "<" + v);
            listStr.add(matcherCl.start() + "</" + v);
        }

        listStr.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                int x = Integer.parseInt(o1.replaceAll("\\D", ""));
                int y = Integer.parseInt(o2.replaceAll("\\D", ""));
                return x - y;
            }
        });

        for (String x : listStr) {
            System.out.println(x);
        }

        int count = 0;

        int start = 0;

        int end = 0;

        for (int i = 0; i < listStr.size(); i++) {
            if (listStr.get(i).contains("<" + v)) {
                count++;
                if (end == 0) {
                    start = Integer.parseInt(listStr.get(i).replaceAll("\\D", ""));
                }
            }
            if (listStr.get(i).contains("</" + v)) {
                count--;
                end = Integer.parseInt(listStr.get(i).replaceAll("\\D", "")) + v.length() + 3;
            }
            if (count == 0 && listStr.get(i).contains("</" + v)) {
                listRes.add(str.substring(start, end));
                start = 0;
                end = 0;
            }

            for (String x : listRes) {
                System.out.println(x);
            }
        }
    }
}



