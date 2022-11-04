package Lecture_11_11;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String path = bR.readLine();
            if (path.equals("exit")) {
                break;
            }
            new ReadThread(path).start();
        }
        for (String key : resultMap.keySet()) {
            System.out.println(key + " " + resultMap.get(key));
        }
        bR.close();

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            int[] bytes = new int[255];
            try (FileInputStream fIS = new FileInputStream(fileName)) {
                while (fIS.available() > 0) {
                  bytes[fIS.read()] += 1;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int maxCount = 0;
            int maxCountByte = 0;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > maxCount) {
                    maxCount = bytes[i];
                    maxCountByte = i;
                }
            }
            ////Integer max = IntStream.range(0, bytes.length).filter(i -> bytes[i] == Arrays.stream(bytes).max().getAsInt()).findFirst().orElse(-1);
            resultMap.put(fileName, maxCountByte);
        }
    }
}

