package Lecture_5;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
DownloadException
*/

public class Solution_5 {
    public static void main(String[] args) throws DownloadException, IOException {
        FileInputStream fIS = null;
        try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                fIS = new FileInputStream(bR.readLine());
                if (fIS.available() < 1000) {
                    throw new DownloadException();
                }
                fIS.read();

            }
        } catch (IOException e) {
        } finally {
            fIS.close();
        }
    }

    public static class DownloadException extends Exception {

    }
}
