package Lev_26_lec_10_2;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 's', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'm', 'r', 'o', 'v'},
                {'m', 'l', 'e', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> list = new ArrayList<>();

        //Получаем массив с границами - нулями
        int[][] cross2 = returnModufyArray(crossword);

        //Определяем количество циклов, равное количеству слов.
        //Это позволит осуществить поиск по каждому слову отдельно
        for (int i = 0; i < words.length; i++) {

            //каждое слово развиваем на массив букв, где
            //ch[0] - это всегда первая буква искомого слова
            char[] ch = words[i].toCharArray();

            int wordLenth = words[i].length(); //Длина слова (количество символов)
            int checkWordLenth = 0; //Счетчик совпадений символов
            int firstCharX = 0;
            int firstCharY = 0;
            int lastCharX = 0;
            int lastCharY = 0;


            for (int k = 0; k < cross2.length; k++) {
                for (int l = 0; l < cross2[k].length; l++) {

                        //Если находим букву, с которой начинается слово,
                        //начинаем поиск остальных букв
                        if (cross2[k][l] == (int) ch[0]) {
                            StringBuilder sB = new StringBuilder();
                            sB.append(ch[0]);
                            firstCharX = k; //Определяем координаты (строка)
                            firstCharY = l; //первой буквы (столбец)

                            System.out.print(ch[0]);
                            checkWordLenth = checkWordLenth + 1;

                            //Создаем цикл с количеством повторений, равным длине слова
                            for (int m = 1; m < wordLenth; m++) {



                                //ищем по горизонтали влево
                                if (l - (wordLenth - 1) > 0) {
                                    if (cross2[k][l - m] == ch[m]) {
                                        sB.append((char) cross2[k][l - m]);
                                        System.out.print((char) cross2[k][l - m]);
                                        checkWordLenth = checkWordLenth + 1;
                                    }
                                    else checkWordLenth = 0;

                                if (checkWordLenth == wordLenth) {

                                    lastCharX = k;     //Определяем координаты (строка)
                                    lastCharY = l - m; //последней буквы (столбец)

                                    Word word = new Word(sB.toString());
                                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                                    list.add(word);
                                    System.out.println();
                                    System.out.println(word);
                                    word = null;
                                }
                                }

                                //ищем по вертикали вниз
                                if ((k + 1) + (wordLenth + 1) <= cross2.length) {
                                    if (cross2[k + m][l] == ch[m]) {
                                        sB.append((char) cross2[k + m][l]);
                                        System.out.print((char) cross2[k + m][l]);
                                        checkWordLenth = checkWordLenth + 1;
                                    }
                                    else checkWordLenth = 0;

                                    if (checkWordLenth == wordLenth) {

                                        lastCharX = k + m;     //Определяем координаты (строка)
                                        lastCharY = l;         //последней буквы (столбец)

                                        Word word = new Word(sB.toString());
                                        word.setStartPoint(firstCharY - 1, firstCharX - 1);
                                        word.setEndPoint(lastCharY - 1, lastCharX - 1);
                                        list.add(word);
                                        System.out.println();
                                        System.out.println(word);
                                        word = null;
                                    }
                                }

                                //ищем по вертикали вверх
                                if (k - (wordLenth - 1) > 0) {
                                    if (cross2[k - m][l] == ch[m]) {
                                        sB.append((char) cross2[k - m][l]);
                                        System.out.print((char) cross2[k - m][l]);
                                        checkWordLenth = checkWordLenth + 1;
                                    }
                                    else checkWordLenth = 0;

                                    if (checkWordLenth == wordLenth) {

                                        lastCharX = k - m;     //Определяем координаты (строка)
                                        lastCharY = l;         //последней буквы (столбец)

                                        Word word = new Word(sB.toString());
                                        word.setStartPoint(firstCharY - 1, firstCharX - 1);
                                        word.setEndPoint(lastCharY - 1, lastCharX - 1);
                                        list.add(word);
                                        System.out.println();
                                        System.out.println(word);
                                        word = null;
                                    }
                                }

                            }
                        }

                }
            }
        }
        return null;
    }

    public static int[][] returnModufyArray(int[][] crossword) {
        int[][] cross2 = new int[crossword.length + 2][crossword[0].length + 2];

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                cross2[i + 1][j + 1] = crossword[i][j];
            }
        }

        for (int i = 0; i < cross2.length; i++) {
            for (int j = 0; j < cross2[i].length; j++) {
                if (cross2[i][j] == 0) System.out.print("0 ");
                else System.out.print((char)cross2[i][j] + " ");
            }
            System.out.println();
        }
        return cross2;
    }

//    public static Word findWordHorizRight(int[][] cross2, char[] ch, int wordLenth) {
//        //ищем по горизонтали вправо
//        for (int m = 1; m < wordLenth; m++) {
//        int checkWordLenth = 0; //Счетчик совпадений символов
//        int firstCharX = 0;
//        int firstCharY = 0;
//        int lastCharX = 0;
//        int lastCharY = 0;
//
//
//        if ((l + 1) + (wordLenth - 1) <= cross2[k].length) {
//            if (cross2[k][l + m] == ch[m]) {
//                sB.append((char) cross2[k][l + m]);
//                System.out.print((char) cross2[k][l + m]);
//                checkWordLenth = checkWordLenth + 1;
//            }
//            else checkWordLenth = 0;
//
//            if (checkWordLenth == wordLenth) {
//
//                lastCharX = k;     //Определяем координаты (строка)
//                lastCharY = l + m; //последней буквы (столбец)
//
//                Word word = new Word(sB.toString());
//                word.setStartPoint(firstCharY - 1, firstCharX - 1);
//                word.setEndPoint(lastCharY - 1, lastCharX - 1);
//                list.add(word);
//                System.out.println();
//                System.out.println(word);
//                word = null;
//            }
//        }
//    }
//    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
