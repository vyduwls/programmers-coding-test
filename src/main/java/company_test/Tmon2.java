package company_test;

public class Tmon2 {

    public static void main(String[] args){

        int answer = new Tmon2().countBits(7);

        System.out.println(answer);
    }

    public static int countBits(int number){

        int answer = 0;

        while(number > 0) {

            int r = number % 2;
            if(r == 1) {
                answer++;
            }
            number /= 2;
        }
        return answer;

    }

}
