package Lecture_8_2;

import java.io.FileInputStream;
import java.io.IOException;

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws UnsupportedFileNameException, IOException {
        new TxtInputStream("333.txt");
        //new TxtInputStream("222.test");
    }
}
