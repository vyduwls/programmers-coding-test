package company_test;

public class MilitarySequence {

    public static void main(String[] args){

        long num = 10;
        long answer = new MilitarySequence().solution(num);

        System.out.println(answer);
    }

    public long solution(long k) {
        long answer = 0;
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            sum += i;
            if(sum >= k){
                idx = i;
                break;
            }
        }
        System.out.println(idx);

        return answer;
    }
}
