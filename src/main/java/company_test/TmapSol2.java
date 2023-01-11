package company_test;

import java.util.ArrayList;

public class TmapSol2 {

    public static void main(String[] args){

        int[] scores ={5,4,3,2,6};

        int answer = new TmapSol2().solution(scores);

        System.out.println(answer);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < A.length-1; i++) {
            sum+=A[i]-A[i+1]>0?1:-1;
        }

        return sum>1?sum-1:sum<-1?-(sum+1):0;
    }
}
