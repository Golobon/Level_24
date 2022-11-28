package Lev_25_lec_8_1;

import java.io.*;

/*
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        PrintStream pS = new PrintStream(bAOS);
        System.setOut(pS);
        testString.printSomething();
        String result = bAOS.toString();

        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fOS = new FileOutputStream(bR.readLine());
        fOS.write(result.getBytes());
        bR.close();
        fOS.close();

        System.setOut(consoleStream);
        System.out.println(result);
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
