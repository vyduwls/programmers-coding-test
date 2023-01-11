package baekjoon;

import java.util.Scanner;

public class bj_1_10869 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String sab = sc.nextLine();
        String[] ab = sab.split(" ");

        Operation op = new Operation();
        op.add(ab);
        op.subtract(ab);
        op.multiply(ab);
        op.divide(ab);

    }

}

class Operation {
    public void add(String[] ab){
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        System.out.println(a+b);
    }
    public void subtract(String[] ab){
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        System.out.println(a-b);
    }
    public void multiply(String[] ab){
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        System.out.println(a*b);
    }
    public void divide(String[] ab){
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        System.out.println(a/b);
        System.out.println(a%b);
    }
}