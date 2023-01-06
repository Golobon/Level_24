package Lev_26_lec_10_2_2;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 's', 's', 'r', 'l', 'e'},
                {'u', 'e', 'a', 'm', 's', 'o'},
                {'l', 'e', 'm', 'm', 'm', 'v'},
                {'m', 'l', 'm', 'a', 'e', 'h'},
                {'p', 'e', 'e', 'e', 's', 'j'}
        };

        List<Word> list = detectAllWords(crossword, "same");

        for (Word w : list) {
            System.out.println(w);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> list = new ArrayList<>();

        //Получаем массив с границами - нулями
        int[][] cross2 = returnModifyArray(crossword);

        //Определяем количество циклов, равное количеству слов.
        //Это позволит осуществить поиск по каждому слову отдельно
        for (int i = 0; i < words.length; i++) {
            //каждое слово развиваем на массив букв, где
            //ch[0] - это всегда первая буква искомого слова
            char[] ch = words[i].toCharArray();
            int wordLenth = words[i].length(); //Длина слова (количество символов)
            int firstCharX;
            int firstCharY;

            for (int k = 0; k < cross2.length; k++) {
                for (int l = 0; l < cross2[k].length; l++) {
                    //Если находим букву, с которой начинается слово,
                    //начинаем поиск остальных букв
                    if (cross2[k][l] == (int) ch[0]) {
                        firstCharX = k; //Определяем координаты (строка)
                        firstCharY = l; //первой буквы (столбец)

                        //Ищем по горизонтале вправо
                        Word wHR = findWordHorizRight(cross2, ch, wordLenth, firstCharY, firstCharX);
                        if (wHR != null) list.add(wHR);

                        //Ищем по горизонтале влево
                        Word wHL = findWordHorizLeft(cross2, ch, wordLenth, firstCharY, firstCharX);
                        if (wHL != null) list.add(wHL);

                        //Ищем по вертикали вверх
                        Word wVU = findWordVertUp(cross2, ch, wordLenth, firstCharY, firstCharX);
                        if (wVU != null) list.add(wVU);

                        //Ищем по вертикали вниз
                        Word wVD = findWordVertDown(cross2, ch, wordLenth, firstCharY, firstCharX);
                        if (wVD != null) list.add(wVD);

                        //Ищем по диагонали вверх вправо
                        Word wHVUR = findWordHorVerUpRight(cross2, ch, wordLenth, firstCharY, firstCharX);
                        if (wHVUR != null) list.add(wHVUR);

                        //Ищем по диагонали вверх влево
                        Word wHVUL = findWordHorVerUpLeft(cross2, ch, wordLenth, firstCharY, firstCharX);
                        if (wHVUL != null) list.add(wHVUL);

                        //Ищем по диагонали вниз влево
                        Word wHVDL = findWordHorVerDownLeft(cross2, ch, wordLenth, firstCharY, firstCharX);
                        if (wHVDL != null) list.add(wHVDL);

                        //Ищем по диагонали вниз вправо
                        Word wHVDR = findWordHorVerDownRight(cross2, ch, wordLenth, firstCharY, firstCharX);
                        if (wHVDR != null) list.add(wHVDR);


                    }
                }
            }
        }
        return list;
    }

    public static int[][] returnModifyArray(int[][] crossword) {
        int[][] cross2 = new int[crossword.length + 2][crossword[0].length + 2];

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                cross2[i + 1][j + 1] = crossword[i][j];
            }
        }

        for (int i = 0; i < cross2.length; i++) {
            for (int j = 0; j < cross2[i].length; j++) {
                if (cross2[i][j] == 0) System.out.print("0 ");
                else System.out.print((char) cross2[i][j] + " ");
            }
            System.out.println();
        }
        return cross2;
    }

    public static Word findWordHorizRight(int[][] cross2, char[] ch, int wordLenth, int firstCharY, int firstCharX) {
        Word word = null;
        StringBuilder sB = new StringBuilder();
        sB.append(ch[0]);
        int checkWordLenth = 1; //Счетчик совпадений символов
        int k = firstCharX;
        int l = firstCharY;
        int lastCharX;
        int lastCharY;

        for (int m = 1; m < wordLenth; m++) {
            if ((l + 1) + (wordLenth - 1) <= cross2[k].length) {
                if (cross2[k][l + m] == ch[m]) {
                    sB.append((char) cross2[k][l + m]);
                    checkWordLenth = checkWordLenth + 1;
                }

                if (checkWordLenth == wordLenth) {
                    lastCharX = k;     //Определяем координаты (строка)
                    lastCharY = l + m; //последней буквы (столбец)
                    word = new Word(sB.toString());
                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                }
            }
        }
        return word;
    }

    public static Word findWordHorizLeft(int[][] cross2, char[] ch, int wordLenth, int firstCharY, int firstCharX) {
        Word word = null;
        StringBuilder sB = new StringBuilder();
        sB.append(ch[0]);
        int checkWordLenth = 1; //Счетчик совпадений символов
        int k = firstCharX;
        int l = firstCharY;
        int lastCharX;
        int lastCharY;

        for (int m = 1; m < wordLenth; m++) {
            if (l - (wordLenth - 1) > 0) {
                if (cross2[k][l - m] == ch[m]) {
                    sB.append((char) cross2[k][l - m]);
                    checkWordLenth = checkWordLenth + 1;
                }

                if (checkWordLenth == wordLenth) {
                    lastCharX = k;     //Определяем координаты (строка)
                    lastCharY = l - m; //последней буквы (столбец)
                    word = new Word(sB.toString());
                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                }
            }
        }
        return word;
    }

    public static Word findWordVertUp(int[][] cross2, char[] ch, int wordLenth, int firstCharY, int firstCharX) {
        Word word = null;
        StringBuilder sB = new StringBuilder();
        sB.append(ch[0]);
        int checkWordLenth = 1; //Счетчик совпадений символов
        int k = firstCharX;
        int l = firstCharY;
        int lastCharX;
        int lastCharY;

        for (int m = 1; m < wordLenth; m++) {
            if (k - (wordLenth - 1) > 0) {
                if (cross2[k - m][l] == ch[m]) {
                    sB.append((char) cross2[k - m][l]);
                    checkWordLenth = checkWordLenth + 1;
                }

                if (checkWordLenth == wordLenth) {
                    lastCharX = k - m;     //Определяем координаты (строка)
                    lastCharY = l;         //последней буквы (столбец)
                    word = new Word(sB.toString());
                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                }
            }
        }
        return word;
    }

    public static Word findWordVertDown(int[][] cross2, char[] ch, int wordLenth, int firstCharY, int firstCharX) {
        Word word = null;
        StringBuilder sB = new StringBuilder();
        sB.append(ch[0]);
        int checkWordLenth = 1; //Счетчик совпадений символов
        int k = firstCharX;
        int l = firstCharY;
        int lastCharX;
        int lastCharY;

        for (int m = 1; m < wordLenth; m++) {
            if ((k + 1) + (wordLenth - 1) <= cross2.length) {
                if (cross2[k + m][l] == ch[m]) {
                    sB.append((char) cross2[k + m][l]);
                    checkWordLenth = checkWordLenth + 1;
                }

                if (checkWordLenth == wordLenth) {
                    lastCharX = k + m;     //Определяем координаты (строка)
                    lastCharY = l;         //последней буквы (столбец)
                    word = new Word(sB.toString());
                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                }
            }
        }
        return word;
    }

    public static Word findWordHorVerUpRight(int[][] cross2, char[] ch, int wordLenth, int firstCharY, int firstCharX) {
        Word word = null;
        StringBuilder sB = new StringBuilder();
        sB.append(ch[0]);
        int checkWordLenth = 1; //Счетчик совпадений символов
        int k = firstCharX;
        int l = firstCharY;
        int lastCharX;
        int lastCharY;

        for (int m = 1; m < wordLenth; m++) {
            if ((l + 1) + (wordLenth - 1) <= cross2[k].length && k - (wordLenth - 1) > 0) {
                if (cross2[k - m][l + m] == ch[m]) {
                    sB.append((char) cross2[k - m][l + m]);
                    checkWordLenth = checkWordLenth + 1;
                }

                if (checkWordLenth == wordLenth) {
                    lastCharX = k - m;     //Определяем координаты (строка)
                    lastCharY = l + m; //последней буквы (столбец)
                    word = new Word(sB.toString());
                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                }
            }
        }
        return word;
    }

    public static Word findWordHorVerUpLeft(int[][] cross2, char[] ch, int wordLenth, int firstCharY, int firstCharX) {
        Word word = null;
        StringBuilder sB = new StringBuilder();
        sB.append(ch[0]);
        int checkWordLenth = 1; //Счетчик совпадений символов
        int k = firstCharX;
        int l = firstCharY;
        int lastCharX;
        int lastCharY;

        for (int m = 1; m < wordLenth; m++) {
            if (l - (wordLenth - 1) > 0 && k - (wordLenth - 1) > 0) {
                if (cross2[k - m][l - m] == ch[m]) {
                    sB.append((char) cross2[k - m][l - m]);
                    checkWordLenth = checkWordLenth + 1;
                }

                if (checkWordLenth == wordLenth) {
                    lastCharX = k - m;     //Определяем координаты (строка)
                    lastCharY = l - m; //последней буквы (столбец)
                    word = new Word(sB.toString());
                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                }
            }
        }
        return word;
    }

    public static Word findWordHorVerDownLeft(int[][] cross2, char[] ch, int wordLenth, int firstCharY, int firstCharX) {
        Word word = null;
        StringBuilder sB = new StringBuilder();
        sB.append(ch[0]);
        int checkWordLenth = 1; //Счетчик совпадений символов
        int k = firstCharX;
        int l = firstCharY;
        int lastCharX;
        int lastCharY;

        for (int m = 1; m < wordLenth; m++) {
            if (l - (wordLenth - 1) > 0 && (k + 1) + (wordLenth - 1) <= cross2.length) {
                if (cross2[k + m][l - m] == ch[m]) {
                    sB.append((char) cross2[k + m][l - m]);
                    checkWordLenth = checkWordLenth + 1;
                }

                if (checkWordLenth == wordLenth) {
                    lastCharX = k + m;     //Определяем координаты (строка)
                    lastCharY = l - m;     //последней буквы (столбец)
                    word = new Word(sB.toString());
                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                }
            }
        }
        return word;
    }

    public static Word findWordHorVerDownRight(int[][] cross2, char[] ch, int wordLenth, int firstCharY, int firstCharX) {
        Word word = null;
        StringBuilder sB = new StringBuilder();
        sB.append(ch[0]);
        int checkWordLenth = 1; //Счетчик совпадений символов
        int k = firstCharX;
        int l = firstCharY;
        int lastCharX;
        int lastCharY;

        for (int m = 1; m < wordLenth; m++) {
            if ((l + 1) + (wordLenth - 1) <= cross2[k].length && (k + 1) + (wordLenth - 1) <= cross2.length) {
                if (cross2[k + m][l + m] == ch[m]) {
                    sB.append((char) cross2[k + m][l + m]);
                    checkWordLenth = checkWordLenth + 1;
                }

                if (checkWordLenth == wordLenth) {
                    lastCharX = k + m;     //Определяем координаты (строка)
                    lastCharY = l + m;     //последней буквы (столбец)
                    word = new Word(sB.toString());
                    word.setStartPoint(firstCharY - 1, firstCharX - 1);
                    word.setEndPoint(lastCharY - 1, lastCharX - 1);
                }
            }
        }
        return word;
    }

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
