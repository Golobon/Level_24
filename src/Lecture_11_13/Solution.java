package Lecture_11_13;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> set = new TreeSet<>((o1, o2) -> {
            int x1 = Integer.parseInt(o1.substring(o1.lastIndexOf(".part") + 5));
            int x2 = Integer.parseInt(o2.substring(o2.lastIndexOf(".part") + 5));
            return x1 - x2; });

        try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
        while (true) { String path = bR.readLine();
            if (path.equals("end")) break;
            set.add(path); } }

        File theFile = new File(set.stream().iterator().next());

        String directory = theFile.getParent();
        String[] fileNameParts = theFile.getName().split("\\.");
        String fileName = fileNameParts[0] + "." + fileNameParts[1];

        String writeWay;
        if (directory == null) writeWay = fileName;
        else writeWay = directory + "\\" + fileName;

        for (String fileParts : set) {
            try (BufferedInputStream bIS = new BufferedInputStream(new FileInputStream(fileParts));
                BufferedOutputStream bW = new BufferedOutputStream(new FileOutputStream(writeWay, true))) {
                byte[] bufferWriter = new byte[bIS.available()];
                while (bIS.available() > 0) {
                    int count = bIS.read(bufferWriter);
                    bW.write(bufferWriter, 0, count); } } } } }
