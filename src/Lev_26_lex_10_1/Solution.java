package Lev_26_lex_10_1;

import java.io.*;

/*
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        ObjectOutputStream oOs = new ObjectOutputStream(bAOS);

        Solution sol = new Solution("111.big");
        System.out.println(sol.stream);
        oOs.writeObject(sol);

        bAOS.close();
        oOs.close();

        System.out.println(sol.fileName);

        ByteArrayInputStream bAIS = new ByteArrayInputStream(bAOS.toByteArray());
        ObjectInputStream oIS = new ObjectInputStream(bAIS);

        Solution solClone = (Solution) oIS.readObject();
        bAIS.close();
        oIS.close();

        System.out.println(solClone.fileName);

        System.out.println(solClone.stream);

    }
}