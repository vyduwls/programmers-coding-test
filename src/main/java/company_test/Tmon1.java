package company_test;

public class Tmon1 {

    public static void main(String[] args){

        int[][] var ={{1, 28, 41, 22, 25, 79, 4}, {39, 20, 10, 17, 19, 18, 8}, {21, 4, 13, 12, 9, 29, 19},
                {58, 1, 20, 5, 8, 16, 9}, {5, 6, 15, 2, 39, 8, 29}, {39, 7, 17, 5, 4, 49, 5}, {74, 46, 8, 11, 25, 2, 11}};

        int p = 19;
        int r = 6;
        int answer = new ZumCoTest3().solution(var,p,r);

        System.out.println(answer);
    }



}
