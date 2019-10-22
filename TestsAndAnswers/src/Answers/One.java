package Answers;

import java.util.Scanner;

public class One {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        if (n1 > n2 && n1 > n3) {
            if (n2 > n3) {
                System.out.println(n1 + " " + n2 + " " + n3);
            }
            if (n3 > n2) {
                System.out.println(n1 + " " + n3 + " " + n2);
            }
        }
        if (n2 > n1 && n2 > n3) {
            if (n1 > n3) {
                System.out.println(n2 + " " + n1 + " " + n3);
            }
            if (n3 > n1) {
                System.out.println(n2 + " " + n3 + " " + n1);
            }
        }
        if (n3 > n1 && n3 > n2) {
            if (n2 > n1) {
                System.out.println(n3 + " " + n2 + " " + n1);
            }
            if (n1 > n2) {
                System.out.println(n3 + " " + n1 + " " + n2);

            }
        }

    }
}
