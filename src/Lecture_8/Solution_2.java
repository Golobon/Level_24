package Lecture_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Расширяем AmigoOutputStream
*/

public class Solution_2 implements AmigoOutputStream {

    AmigoOutputStream aOS;

    public Solution_2(AmigoOutputStream aOS) {
        this.aOS = aOS;
    }

    @Override
    public void flush() throws IOException {
        aOS.flush();
    }

    @Override
    public void write(int b) throws IOException {
        aOS.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        aOS.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        aOS.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String value = bR.readLine();
        if (value.equals("Д")) {
            aOS.close();
        } else {
        }
    }

    public static void main(String[] args) throws IOException {
        Sol a = new Sol();
        new Solution_2(a).close();
    }
}
