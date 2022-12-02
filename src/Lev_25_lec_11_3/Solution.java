package Lev_25_lec_11_3;

/*
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path;

        try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
            path = bR.readLine(); }

        String str;

        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            StringBuilder sB = new StringBuilder();
            while (bRF.ready()) { sB.append(bRF.readLine());
            } str = sB.toString(); }

        String v = args[0];

        List<String> listResult = new ArrayList<>();

        //Code for find substrings with tag
        // using pattern <tag ></tag>

        String regex1 = String.format("<%s.*</%s>", v, v);
        findStrManyTags1(str, regex1, listResult, v);

        //Code for find substrings with tag
        // using pattern <tag><tag></tag><tag></tag><tag></tag></tag>

        String regex2 = String.format("<%s(.*</%s></%s>)", v, v, v);
        findStrManyTags2(str, regex2, listResult);

        //Code for find substrings with tag
        // using pattern <tag></tag>

        String regex3 = String.format("<%s>[^<>]*</%s>", v, v);
        findStrOneTag(str, regex3, listResult);

        for (String strResList : listResult) {
            System.out.println(strResList); } }

    public static void findStrManyTags1(String str, String pat, List list, String v) {

        Pattern p1 = Pattern.compile(pat);

        Matcher matcher1 = p1.matcher(str);

        String regexVal = String.format("</%s></%s>", v, v);

        int count = 0;

        while (matcher1.find()) {
            String findStrForCut = matcher1.group();

            int substr = findStrForCut.length() - (v.length() + v.length() + 6);

            if (!findStrForCut.substring(substr).equals(regexVal)) {
                String findForCut = String.format("</%s>", v);
                Pattern forCutPattern = Pattern.compile(findForCut);
                Matcher forCutMatcher = forCutPattern.matcher(findStrForCut);
                while (forCutMatcher.find()) {
                    forCutMatcher.group();
                    count++;
                    if (count == 2) {
                        int subs = forCutMatcher.start() + v.length() + 3;
                        String finResult = findStrForCut.substring(0, subs);
                        list.add(finResult);
                        break; } } } } }

    public static void findStrManyTags2(String str, String pat, List list) {

        Pattern p2 = Pattern.compile(pat);

        Matcher matcher2 = p2.matcher(str);

        while (matcher2.find()) {
            String findStr = matcher2.group();
            list.add(findStr); } }

    public static void findStrOneTag(String str, String pat, List list) {
        Pattern p2 = Pattern.compile(pat);
        //Pattern pd2 = Pattern.compile("<span.*<span></span>");

        Matcher matcher2 = p2.matcher(str);

        while (matcher2.find()) {
            String findStr = matcher2.group();
            list.add(findStr); }
    }
}


