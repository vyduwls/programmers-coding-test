package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// N진법 변환 코딩
public class CardinalConversionTest {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> ouput = new ArrayList<>();
        String chr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int convertToNum = Integer.parseInt(br.readLine());
        int nJinBub = Integer.parseInt(br.readLine());

        bw.write("바꿔야 할 숫자 : "+convertToNum);bw.newLine();
        bw.write("N진법 : "+nJinBub);bw.newLine();

        while ( convertToNum != 0){
            ouput.add(chr.charAt(convertToNum%nJinBub));
            convertToNum /= nJinBub;
        }

        Collections.reverse(ouput);

        bw.write("[");
        for (Character ch: ouput) {
            bw.write(ch);
        }
        bw.write("]");
        bw.flush();
    }

}


