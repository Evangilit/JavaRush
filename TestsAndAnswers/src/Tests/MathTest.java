package Tests;

public class MathTest {
    public static void main(String[] args) {
        System.out.println("floor");

        System.out.println(Math.floor(3.41));
        System.out.println(Math.floor(3.64));
        System.out.println(Math.floor(3.5));
        System.out.println(Math.floor(-3.41));
        System.out.println(Math.floor(-3.64));
        System.out.println(Math.floor(-3.5));

        System.out.println("round");

        System.out.println(Math.round(3.41));
        System.out.println(Math.round(3.64));
        System.out.println(Math.round(3.5));
        System.out.println(Math.round(-3.41));
        System.out.println(Math.round(-3.64));
        System.out.println(Math.round(-3.5));

        System.out.println("ceil");

        System.out.println(Math.ceil(3.41));
        System.out.println(Math.ceil(3.64));
        System.out.println(Math.ceil(3.5));
        System.out.println(Math.ceil(-3.41));
        System.out.println(Math.ceil(-3.64));
        System.out.println(Math.ceil(-3.5));

        System.out.println("sqrt");

        System.out.println(Math.sqrt(5));

        System.out.println("random");

        double d = (Math.random()*2);
        System.out.println("d = " + d + "int d = " + (int) d);
    }
}
