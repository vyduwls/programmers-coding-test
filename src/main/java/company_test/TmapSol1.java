package company_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TmapSol1 {


    public static void main(String[] args){

        int[] days={2,-3,3,1,10,8,2,5,13,-5,3,-18};
        int k = 3;

        String answer = new TmapSol1().solution(days);

        System.out.println(answer);
    }

    public String solution(int[] days)
    {
        String answer = "";

        int[] winDay = {days[0],days[0]};
        int[] sprDay = {days[0+(days.length/4*1)],days[0+(days.length/4*1)]};
        int[] sumDay = {days[0+(days.length/4*2)],days[0+(days.length/4*2)]};
        int[] autDay = {days[0+(days.length/4*3)],days[0+(days.length/4*3)]};

        for (int i = 0; i < days.length/4; i++) {
            winDay[0] = Math.max(winDay[0] , days[i]);
            winDay[1] = Math.min(winDay[1] , days[i]);
            sprDay[0] = Math.max(sprDay[0] , days[i+days.length/4]);
            sprDay[1] = Math.min(sprDay[1] , days[i+days.length/4]);
            sumDay[0] = Math.max(sumDay[0] , days[i+(days.length/4*2)]);
            sumDay[1] = Math.min(sumDay[1] , days[i+(days.length/4*2)]);
            autDay[0] = Math.max(autDay[0] , days[i+(days.length/4*3)]);
            autDay[1] = Math.min(autDay[1] , days[i+(days.length/4*3)]);
        }

        Map<String,Integer> ans = new HashMap<>();
        ans.put("WINTER", winDay[0]-winDay[1]);
        ans.put("SPRING", sprDay[0]-sprDay[1]);
        ans.put("SUMMER", sumDay[0]-sumDay[1]);
        ans.put("AUTUMN", autDay[0]-autDay[1]);

        answer= ans.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

        return answer;
    }
}
