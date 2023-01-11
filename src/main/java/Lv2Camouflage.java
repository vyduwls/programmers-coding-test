import java.util.HashMap;
import java.util.Map;

public class Lv2Camouflage {

    /*
    * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

종류	이름
얼굴	동그란 안경, 검정 선글라스
상의	파란색 티셔츠
하의	청바지
겉옷	긴 코트
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
같은 이름을 가진 의상은 존재하지 않습니다.
clothes의 모든 원소는 문자열로 이루어져 있습니다.
모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
스파이는 하루에 최소 한 개의 의상은 입습니다.
입출력 예
clothes	return
[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
[[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
입출력 예 설명
예제 #1
headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.

1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses
예제 #2
face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.

1. crow_mask
2. blue_sunglasses
3. smoky_makeup
    * */
    int answer = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[][] s={{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = new Lv2Camouflage().solution(s);
        System.out.println(answer);
    }

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String,Integer> clothMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String cloth = clothes[i][1];
            clothMap.put(cloth, clothMap.containsKey(cloth)?clothMap.get(cloth).intValue()+1:1);
        }

        int[] clothNum = new int[clothes.length];
        boolean[] visited = new boolean[clothes.length];
        int cnt = 0;
        int leng = 1;

        for ( String key : clothMap.keySet() ) {
            for (int i = 0; i < clothMap.get(key).intValue(); i++) {
                clothNum[cnt] = leng;
                System.out.println("clothNum[cnt]=="+clothNum[cnt]);
                cnt++;
            }
            leng++;
        }

        for(int r = 1; r <= clothNum.length ; r++) {
            System.out.println("\n" + clothNum.length + "개 중에 " + r  + "개 뽑음");
            comb2(clothNum, visited, 0, r);
        }

        return answer;
    }

    //2. 재귀를 이용해 구현
    static void comb2(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb2(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb2(arr, visited, depth + 1, r);
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
