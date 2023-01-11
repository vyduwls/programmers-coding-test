package baekjoon;

import java.util.Scanner;
import java.util.stream.Stream;

public class bj_1_2588 {
    public static void main(String[] args){

        //첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int[] b = Stream.of(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        for (int i=b.length-1; i>=0;i--){
                System.out.println(a*(b[i]));
                answer = answer + a*(b[i]*(int)Math.pow(10,2-i));
        }
        System.out.println(answer);
    }
}
