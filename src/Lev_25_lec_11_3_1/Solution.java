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
        String tagArgument = args[0];

        String path = selectPath();

        String stringWithTags = getString(path);

        List<String> listResult = findTags(tagArgument, stringWithTags);

        for (String x : listResult) {
            System.out.println(x);
        }
    }

    public static String selectPath() throws IOException {
        String path;
        try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
            path = bR.readLine();
        }
        return path;
    }

    public static String getString(String path) throws IOException {
        String str;
        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            StringBuilder sB = new StringBuilder();
            while (bRF.ready()) {
                sB.append(bRF.readLine());
            }
            str = sB.toString();
        }
        return str;
    }

    public static List<String> findTags(String v, String str) {
        List<String> listTagsStructure = new ArrayList<>();
        List<String> listWithResult = new ArrayList<>();

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

            listTagsStructure.add(matcherOp.start() + "<" + v);
            listTagsStructure.add(matcherCl.start() + "</" + v);
        }

        listTagsStructure.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int x = Integer.parseInt(o1.replaceAll("\\D", ""));
                int y = Integer.parseInt(o2.replaceAll("\\D", ""));
                return x - y;
            }
        });

//        for (String x : listTagsStructure) {
//            System.out.println(x);
//        }

        int count = 0;
        int start = 0;
        int end = 0;
        int indexOp = 0;
        int indexCl = 0;
        int flag = 0;
        int i = 0;

        while (listTagsStructure.size() > 1) {
            for (i = 0; i < listTagsStructure.size(); i++) {
                if (listTagsStructure.get(i).contains("<" + v)) {
                    count++;
                    if (flag == 0) {
                        indexOp = i;
                        start = Integer.parseInt(listTagsStructure.get(i).replaceAll("\\D", ""));
                        flag = 1;
                    }
                }
                if (listTagsStructure.get(i).contains("</" + v)) {
                    count--;
                    if (count == 0) {
                        indexCl = i;
                        end = Integer.parseInt(listTagsStructure.get(i).replaceAll("\\D", "")) + v.length() + 3;
                    }
                }
                if (count == 0 && listTagsStructure.get(i).contains("</" + v)) {
                    listWithResult.add(str.substring(start, end));
//                    System.out.println(str.substring(start, end));
                    start = 0;
                    end = 0;
                    flag = 0;
                    listTagsStructure.remove(indexCl);
                    listTagsStructure.remove(indexOp);
                    i = -1;
                }
            }
        }
        listTagsStructure = null;
        return listWithResult;
    }
}



