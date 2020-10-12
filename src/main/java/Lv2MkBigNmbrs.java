import java.util.Stack;

public class Lv2MkBigNmbrs {

    /*
    어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

    예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

    문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

    제한 조건
    number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
    k는 1 이상 number의 자릿수 미만인 자연수입니다.
    * */
    public static void main(String[] args){

        String answer = new Lv2MkBigNmbrs().solution2("999999",2);

        System.out.println(answer);
    }

    public String solution(String number, int k) {

        String answer = "";

        StringBuilder cha = new StringBuilder();
        int cnt = k;

        for (int i = 0; i < number.length(); i++) {
            System.out.println("0==="+i+"/"+cnt);

            String subNum = number.substring(i,i+cnt+1);

            int index = 0;
            int maxCnt = 0;

            System.out.println("1==="+subNum);
            for (int j = 0; j < subNum.length(); j++) {

                int sub1 = Integer.parseInt(subNum.substring(j,j+1));

                if(sub1>maxCnt){
                    maxCnt = sub1;
                    index = j;
                }

                if(maxCnt == 9){
                    break;
                }

            }
            System.out.println("2==="+cha);
            cha = cha.append(subNum.substring(index,index+1));
            i += index;
            cnt = cnt-index;

            if(cnt == 0){
                cha.append(number.substring(i+1));//34223566879234
                break;
            }else if(cha.length() == number.length()-k){
                break;
            }
            System.out.println("3==="+cha);
            System.out.println("4==="+i+"/"+cnt);
        }


        return cha.toString();
    }
//43243244
    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                cnt++;
                System.out.println("cnt---"+cnt+" : "+stack.peek());
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

}
