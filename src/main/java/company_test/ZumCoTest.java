package company_test;

import java.util.HashMap;
import java.util.Map;

public class ZumCoTest {

    public static void main(String[] args){

        int[][] var = {{1, 4}, {3, 4}, {3, 10}};

        int[] answer = new ZumCoTest().solution(var);

        System.out.println(answer[0]+"=="+answer[1]);
    }

    public int[] solution(int[][] v) {

        int[] answer = new int[]{0,0};

        Map<Integer, Integer> xIndex = new HashMap();
        Map<Integer, Integer> yIndex = new HashMap();


        for (int i = 0; i < v.length; i++) {

            int x = v[i][0];
            int y = v[i][1];

            if(xIndex.containsKey(x)){
                xIndex.put(x, xIndex.get(x)+1);
            }else{
                xIndex.put(x, 1);
            }

            if(yIndex.containsKey(y)){
                yIndex.put(y, yIndex.get(y)+1);
            }else{
                yIndex.put(y, 1);
            }

        }

        for(int i: xIndex.keySet()) {
            if(xIndex.get(i).equals(1)) {
                answer[0] =i;
            }
        }
        for(int i: yIndex.keySet()) {
            if(yIndex.get(i).equals(1)) {
                answer[1] =i;
            }
        }


        return answer;
    }
}
