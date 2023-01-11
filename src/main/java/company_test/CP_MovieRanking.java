package company_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CP_MovieRanking {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] movie = {"spy","ray","spy","room","once","ray","spy","once","spy","ray","spy","room","once","ray","spy","once","spy","ray","spy","room","once","ray","spy","once","test"};
        System.out.println(Arrays.toString(new CP_MovieRanking().solution(movie)));
    }

    public String[] solution(String[] movie) {
        ArrayList<Movies> arr = new ArrayList<>();

        int total;

        String s = Arrays.toString(movie);
        s = s.substring(1, s.length()-1) + ", "; //[] 제거  //질의

        while(movie.length>0) {
            Movies m = new Movies(); //name, count 값 저장
            total = movie.length; //자르기 전 총 개수
            m.name = movie[0]; //계산 할 영화

            StringBuilder sb = new StringBuilder();
            for(String str: s.split(movie[0]+", ")) {
                sb.append(str);
            }
            s = sb.toString(); //제거된 문자열

            movie = s.split(", ");
            System.out.println("s = " + s);

            if(movie[0].equals("")) movie = new String[0]; //빈 값일 때 초기화
            m.cnt = total - movie.length;

            arr.add(m);
        }

        Collections.sort(arr);

        String[] ans = new String[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            ans[i] = arr.get(i).name;
        }

        return ans;
    }

    class Movies implements Comparable<Movies> {
        String name;
        int cnt;

        @Override
        public int compareTo(Movies m) {
            if(m.cnt>this.cnt) { //큰 값일 때
                return 1;
            } else if(this.cnt==m.cnt) { //값이 같으면 오름차순
                String[] comp = {this.name, m.name};
                Arrays.sort(comp);

                if(m.name.equals(comp[0])) {
                    return 1;
                }
            }
            return -1;
        }
    }
}