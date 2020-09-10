

public class CaesarCipherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="AB";
		int n=1;
		System.out.println(new CaesarCipherTest().solution(s, n));
	}
	
	public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(a==' '){ 
                answer+=" ";
                continue;
            }
            
            int code = (int)a+n;
            String chA = String.valueOf(a);
            if(chA.matches("[A-Z]")&&code>90) code-=26;
            if(chA.matches("[a-z]")&&code>122) code-=26;
            
            char mvStr = (char)code;
            answer+=mvStr;
        }
        return answer;
    }

}
