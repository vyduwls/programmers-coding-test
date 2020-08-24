import java.util.Arrays;
import java.util.Comparator;

public class Lv2LargestNumber {

    public static void main(String[] args){

        int[] caseA = {6,10,2};//{94,6, 20, 9, 52};
        String answer = new Lv2LargestNumber().solution(caseA);

        System.out.println(answer);
    }


    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1 : "+o1+"/ o2 : "+o2 +"/ o1+o2 : "+(o1+o2)+"/ o2+o1 : "+(o2+o1)+"--"+(o2+o1).compareTo(o1+o2));
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for (int i = 0; i <  arr.length; i++) {
            answer+=arr[i];
        }
        if("0".equals(arr[0])){
            answer = "0";
        }
        return answer;
    }
}
