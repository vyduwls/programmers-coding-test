package baekjoon;

import java.util.Scanner;

public class bj_1_1008 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String sab = sc.nextLine();
        String[] ab = sab.split(" ");

        double a = Double.parseDouble(ab[0]);
        double b = Double.parseDouble(ab[1]);
        System.out.println(String.format("%.10f", a/b));

    }
}
