package baekjoon;

import java.util.Scanner;
import java.util.stream.Stream;

public class bj_1_3003 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] right_chess = {1,1,2,2,2,8};
        int[] wrong_chess = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<right_chess.length; i++){
            if(i==right_chess.length-1){
                System.out.print(right_chess[i]-wrong_chess[i]);
            }else{
                System.out.print(right_chess[i]-wrong_chess[i]+" ");
            }
        }
    }
}
