package Lecture_11_12;

import java.io.*;

/*
Нити и байты
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        String path = null;
        try {
            while (true) {
                BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
                path = bR.readLine();
                File file = new File(path);
                FileInputStream fIS = new FileInputStream(file);
                if (!file.exists()) {
                    fIS.close();
                }
                Thread thread = new ReadThread(fIS);
                thread.start();
            }
        } catch (FileNotFoundException e) {
            System.out.println(path);

        }
    }

    public static class ReadThread extends Thread {
        FileInputStream fIS;

        public ReadThread(FileInputStream fIS) {
            this.fIS = fIS;
        }

        @Override
        public void run() {
            try {
                fIS.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


