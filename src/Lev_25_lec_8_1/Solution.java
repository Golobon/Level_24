package Lev_25_lec_8_1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        PrintStream pS = new PrintStream(bAOS);
        System.setOut(pS);
        testString.printSomething();
        String result = bAOS.toString();
        Pattern pattern = Pattern.compile("\\b[\\d]+\\b");
        Matcher matcher = pattern.matcher(result);
        System.setOut(consoleStream);
        int[] values = new int[2];
        int count = 0;
        int value;

        if (result.contains("+")) {
            while (matcher.find()) {
                values[count++] = Integer.parseInt(matcher.group());
            }
            value = values[0] + values[1];
            System.out.println(values[0] + " + " + values[1] + " = " + value);
        } else if (result.contains("-")) {
            while (matcher.find()) {
                values[count++] = Integer.parseInt(matcher.group());
            }
            value = values[0] - values[1];
            System.out.println(values[0] + " - " + values[1] + " = " + value);
        } else if (result.contains("*")) {
            while (matcher.find()) {
                values[count++] = Integer.parseInt(matcher.group());
            }
            value = values[0] * values[1];
            System.out.println(values[0] + " * " + values[1] + " = " + value);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
