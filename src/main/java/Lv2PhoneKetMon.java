import java.util.HashMap;
import java.util.Map;

public class Lv2PhoneKetMon {

    public static void main(String[] args){

        int nums[] = {3,3,3,2,2,4};
        int answer = new Lv2PhoneKetMon().solution(nums);

        System.out.println(answer);
    }

    public int solution(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> phoneCnt = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            phoneCnt.put(nums[i],phoneCnt.containsKey(nums[i])==true ? phoneCnt.get(nums[i])+1 : 1);
        }

        answer = Math.min(nums.length/2, phoneCnt.size());
        return answer;
    }
}
