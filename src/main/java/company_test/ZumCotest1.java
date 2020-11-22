package company_test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/*
* 신용 카드 번호는 총 16자리 숫자로 구성되며, 다음과 같은 형식을 가집니다.

XXXX-XXXX-XXXX-XXXX : X는 0 ~ 9 까지의 정수이며, 4자리씩 총 16개 숫자가 '-'로 연결된 형태입니다.
XXXXXXXXXXXXXXXX : X는 0 ~ 9 까지의 정수이며, 총 16개 숫자가 공백 없이 연결된 형태입니다.
또한, 신용 카드 번호는 Luhn 공식을 통해 유효성을 검사합니다. Luhn 공식은 아래와 같습니다.

가장 오른쪽부터 짝수번째 자리 숫자들에 2를 곱한 후 모두 더합니다. 이를 (1)이라고 합니다.
만약 2를 곱한 수가 두 자릿수라면 각 자릿수의 값을 더해 한 자릿수로 만든 후 더합니다.
가장 오른쪽부터 홀수번째에 있는 숫자를 모두 더하고 이를 (2)라고 합니다.
(1) + (2)가 10으로 나누어 떨어지면 유효한 번호입니다.
위에 제시된 형식 이외의 신용 카드 번호와 유효성 검사를 통과하지 못한 번호는 올바르지 않은 신용 카드 번호로 판단합니다.

신용 카드 번호들이 담긴 문자열 배열 card_numbers가 주어질 때, 각 카드 번호가 올바르면 1, 올바르지 않으면 0으로 표시한 배열을 return 하도록 solution 함수를 완성해주세요.

제한사항
card_numbers의 길이는 1 이상 10 이하입니다.
card_numbers의 원소는 신용 카드 번호를 나타내는 문자열입니다.
각 문자열은 0 ~ 9까지의 숫자와 '-'로만 구성되어 있습니다.
각 문자열의 길이는 1 이상 20 이하입니다.
입출력 예
card_num	return
["3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"]	[1, 1, 0, 0, 0, 0]
입출력 예 설명
입출력 예 #1

첫번 째 카드 번호의 경우 가장 오른쪽 부터의 순서와 각 위치의 숫자는 아래와 같습니다.

idx	16	15	14	13	12	11	10	9	8	7	6	5	4	3	2	1
number	3	2	8	5	3	7	6	4	9	9	3	4	2	4	5	3
예를 들어 오른쪽에서 10번째 숫자는 6이며, 이를 2배하면 12가 됩니다. 12의 각 자릿수 값을 더하면 3이 됩니다.

조건에 따라 짝수번째 숫자를 모두 2배해서 더하면 42가 됩니다. 또, 홀수 번째 숫자를 모두 더하면 38이 됩니다.

42 + 38 = 80이며, 이는 10으로 나누어 떨어지므로 올바른 번호입니다.

두 번째 카드 번호 또한 조건을 만족하므로 올바른 번호입니다.

세 번째, 네 번째 번호는 신용 카드 번호의 형식을 맞추지 못하므로 올바르지 않은 않은 번호입니다.
다섯 번째, 여섯 번째 번호는 신용 카드 번호의 형식은 맞추고 있으나, 유효성 검사를 만족하지 못하므로 올바르지 않은 번호입니다.
* */
public class ZumCotest1 {

    public static void main(String[] args){

        String[] var = {"3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"};

        int[] answer = new ZumCotest1().solution(var);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public int[] solution(String[] card_numbers) {
        int[] answer = new int[card_numbers.length];

        for (int i = 0; i < card_numbers.length; i++) {

            int valid = this.varCheck(card_numbers[i]);
            System.out.println("valid == "+valid);
            answer[i]= valid;
        }

        return answer;
    }

    public int varCheck (String cardNum){
        int answer = 0;

        Queue<Integer> stCardNum = new LinkedList<>();

        //홀수변수
        int oddNum = 0;
        //짝수변수
        int evenNum =0;

        //String "-"  체크
        String CardStringCnt = cardNum.replace("-","");
        if(!(CardStringCnt.length() == cardNum.length() ||
                CardStringCnt.length()+3 == cardNum.length())){
            return 0;
        }

        for (int i = 0; i <cardNum.length(); i++) {

            if("-".equals(cardNum.substring(i,i+1))){
                if(!(i==4 || i==9 || i==14)){
                    System.out.println("INDEXPF.peek() == "+i);
                    return 0;
                }

            }else{
                stCardNum.add(Integer.parseInt(cardNum.substring(i,i+1)));
            }


        }
        while (!stCardNum.isEmpty()){
            //짝수일때 계산
            System.out.println("size == "+ stCardNum.size());
            if(stCardNum.size()%2 == 0){
                System.out.println("stCardNum.peek() == "+ stCardNum.peek());
                if(stCardNum.peek()>=5){
                    evenNum+=1+(stCardNum.poll()*2)%10;
                }else{
                    evenNum+=stCardNum.poll()*2;
                }
            //홀수일 때 계산
            }else{
                System.out.println("stCardNum.peek() == "+ stCardNum.peek());
                oddNum+=stCardNum.poll();

            }
        }

        return (evenNum+oddNum)%10==0?1:0;
    }

    public static int[] solution1(String[] card_numbers) {

        List<String[]> list = stream(card_numbers)
                .map(x -> x.split(""))
                .distinct()
                .collect(Collectors.toList());

        for(String[] arr : list) {

            boolean reject = false;
            if(arr.length > 16) {
                for(int i = 1; i <= arr.length; i++) {

                    if((i) % 5 == 0 ) {
                        if(!arr[i-1].equals("-")) {
                            reject = true;
                        }
                    }
                }
                if(reject) {
                    arr[0] = "-1";
                    continue;
                }
            }

            List<String> item = stream(arr)
                    .map(x -> x.split("-"))
                    .flatMap(Arrays::stream)
                    .filter(x -> !x.equals("-"))
                    .collect(Collectors.toList());

            Collections.reverse(item);

            if(item.size() != 16)
                arr[0] = "-1";
            else {
                int one = 0;
                int two = 0;
                int total = 0;
                for(int i = 1; i <= 16; i++) {
                    if(i % 2 == 0) {
                        String number = String.valueOf(Integer.parseInt(item.get(i-1)) * 2);
                        if(number.length() > 1) {
                            String[] str = number.split("");
                            for(String s : str) {
                                one += Integer.parseInt(s);

                            }
                        } else
                            one += Integer.parseInt(item.get(i-1)) * 2;


                    } else {
                        two += Integer.parseInt(item.get(i-1));
                    }

                    total = one + two;
                }
                if(total % 10 == 0)
                    arr[0] = "-2";
                else
                    arr[0] = "-1";

            }
        }

        int[] result = new int[card_numbers.length];

        for(int i = 0; i < card_numbers.length; i++) {

            int r = Integer.parseInt(list.get(i)[0]);
            if(r == -2)
                result[i] = 1;
            else
                result[i] = 0;
        }

        return result;

    }
}
