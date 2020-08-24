import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Lv2PhoneNumberList {

    public static void main(String[] args){

        String[] caseA = {"119", "97674223", "1","1195524421","32433333333333331"};
        boolean answer = new Lv2PhoneNumberList().solution1(caseA);

        System.out.println(answer);
    }

    //내 풀이
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            String fir = phone_book[i-1];
            String sec = phone_book[i];

            if (fir.length() <= sec.length()
            && fir.equals(sec.substring(0, fir.length()))){
                answer = false;
            }
        }
        return answer;
    }
    //다른 사람 풀이
    public boolean solution1(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {

            String fir = phone_book[i-1];
            String sec = phone_book[i];

            if (sec.startsWith(fir)){
                answer = false;
            }
        }
        return answer;
    }
}
