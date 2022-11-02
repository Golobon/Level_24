package Lecture_11_5;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fR = new FileReader(args[0]);
        double resultProb = 0;
        double resultSymb = 0;
        while (fR.ready()) {
            Character ch = (char) fR.read();
            Pattern pattern = Pattern.compile("[ ]");
            Matcher matcher = pattern.matcher(ch.toString());
            if (matcher.find()) {
                resultProb++;
            }
                resultSymb++;
        }
        String result = String.format("%.2f",resultProb / resultSymb * 100);
        System.out.println(result);
        fR.close();
    }
}

