package baekjoon;

import java.util.Scanner;
import java.util.stream.Stream;

public class bj_1_10430 {
    public static void main(String[] args){

        //첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
        Scanner sc = new Scanner(System.in);
        int[] abc = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println((abc[0]+abc[1])%abc[2]);
        System.out.println(((abc[0]%abc[2])+(abc[1]%abc[2]))%abc[2]);
        System.out.println((abc[0]*abc[1])%abc[2]);
        System.out.println(((abc[0]%abc[2])*(abc[1]%abc[2]))%abc[2]);
    }

}
