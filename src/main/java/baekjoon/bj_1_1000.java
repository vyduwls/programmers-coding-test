package baekjoon;

import java.util.Scanner;

public class bj_1_1000 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String sab = sc.nextLine();
        String[] ab = sab.split(" ");

        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        System.out.println(String.format("%.10f", a+b));

    }
}
