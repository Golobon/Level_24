package Lecture_3;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Вася1", 99, 99, 9);
        Cat cat2 = new Cat("Вася2", 99, 99, 6);
        Cat cat3 = new Cat("Вася3", 7, 8, 9);
        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;


        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int a = this.age;
            int a1 = anotherCat.age;
            int b = this.weight;
            int b1 = anotherCat.weight;
            int c = this.strength;
            int c1 = anotherCat.strength;

            return ((a-a1) > 0) && ((b-b1) > 0) ||
                    ((b-b1) > 0) && ((c-c1) > 0) ||
                    ((a-a1) > 0) && ((c-c1) > 0) ||
                    a-a1 == 0 && b-b1 == 0 && ((c-c1) > 0)  ||
                    c-c1 == 0 && b-b1 == 0 && ((a-a1) > 0)  ||
                    a-a1 == 0 && c-c1 == 0 && ((b-b1) > 0);
        }
    }
}
