package Lecture_8_1;

public class Program {
    public static void main(String[] args) {
        String x = "C:\\Users\\Home2020\\Desktop\\Java\\2\\1.txt.part1";
        System.out.println(x.lastIndexOf(".part"));
        System.out.println(x.substring(x.lastIndexOf(".part") + 5));
    }
}
