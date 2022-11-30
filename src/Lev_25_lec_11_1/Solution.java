package Lev_25_lec_11_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static void main(String[] args) throws IOException {

        List<String> fileList1 = new ArrayList<>();
        List<String> fileList2 = new ArrayList<>();

        try (BufferedReader bR1 = new BufferedReader(new InputStreamReader(System.in))) {
            String path1 = bR1.readLine();
            String path2 = bR1.readLine();

            try (BufferedReader bR2 = new BufferedReader(new FileReader(path1));
                 BufferedReader bR3 = new BufferedReader(new FileReader(path2))) {

                while (bR2.ready()) { fileList1.add(bR2.readLine()); }

                while (bR3.ready()) { fileList2.add(bR3.readLine()); }

                for (int i = 0; i < Math.max(fileList1.size(), fileList2.size()); i++) {
                   if (fileList1.size() > i + 1 && fileList2.size() > i + 1) {
                        if (!fileList1.get(i).equals(fileList2.get(i)) &&
                                fileList1.get(i).equals(fileList2.get(i + 1))) {
                            fileList1.add(i, null);
                        } else if (!fileList1.get(i).equals(fileList2.get(i)) &&
                                !fileList1.get(i).equals(fileList2.get(i + 1))) {
                            fileList2.add(i, null); } } }

                if (fileList1.size() > fileList2.size()) fileList2.add(null);
                else if (fileList2.size() > fileList1.size()) fileList1.add(null);

                System.out.println(fileList1);
                System.out.println(fileList2);

                for (int i = 0; i < fileList1.size(); i++) {
                    if (fileList1.get(i) != null &&
                        fileList2.get(i) != null &&
                        fileList1.get(i).equals(fileList2.get(i))) {
                        lines.add(new LineItem(Type.SAME, fileList1.get(i)));
                    } else if (fileList2.get(i) == null) {
                        lines.add(new LineItem(Type.REMOVED, fileList1.get(i)));
                    } else if (fileList1.get(i) == null) {
                        lines.add(new LineItem(Type.ADDED, fileList2.get(i)));
                    } } } } System.out.println(lines); }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line; }

        @Override
        public String toString() {
            String type = null;
            switch (this.type) {
                case ADDED:
                    type = "ADDED:   ";
                    break;
                case REMOVED:
                    type = "REMOVED: ";
                    break;
                case SAME:
                    type = "SAME:    ";
                    break; }
            return type + line + "\n"; } } }
