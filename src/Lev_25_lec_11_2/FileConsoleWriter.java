package Lev_25_lec_11_2;

/*
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i <= off + len - 1 ; i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        char[] arrStr = str.toCharArray();
        for (int i = off; i <= off + len - 1 ; i++) {
            System.out.print(arrStr[i]);
        }
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (int i = 0; i < cbuf.length ; i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void close() throws IOException {
        fileWriter.close();
    }


    public static void main(String[] args) throws IOException {
        char[] ch = "Строка".toCharArray();
        FileConsoleWriter fCW = new FileConsoleWriter("111.big", true);
        fCW.write(1);
        System.out.println();
        fCW.write("Строка");
        System.out.println();
        fCW.write("Строка", 2, 2);
        System.out.println();
        fCW.write(ch, 2, 3);
        System.out.println();
        fCW.write(ch);
        fCW.close();
    }
}
