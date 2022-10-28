package Lecture_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Исправить ошибки
*/

public class Solution_1 {
    public static void main(String[] args) throws IOException {
        try (
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");
        ) {
            if (inputStream.available() > 0) {
                //читаем весь файл одним куском
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
