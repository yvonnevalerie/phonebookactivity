package practice;

import java.util.Scanner;

public class Week3Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter valid number: ");
        int enterNum = sc.nextInt();

        try {
            int n = enterNum / 0;

        } catch (Exception e) {
            System.out.println("wow maliiiii!!");
        }
        System.out.print("Lagay ka ulit number: ");
        int number = inputNumber();

    }

    public static int inputNumber() {
        int num = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                num = sc.nextInt();

                return num;
            } catch (Exception e) {
                System.out.println("mali ka!!");
                System.out.println("Enter a number: ");
            }
        }
    }

}
