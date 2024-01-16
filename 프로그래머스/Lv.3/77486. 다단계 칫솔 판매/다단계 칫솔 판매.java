import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {  // 판매원, 추천인, 판매량 집계 판매원, 수량
        // 판매원에게 배분된 이익금의 총합을 계산하여(정수형으로), 입력으로 주어진 enroll에 이름이 포함된 순서에 따라 나열하면 됩니다.
        Map<String, String> name = new HashMap<>();
        Map<String, Integer> price = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            name.put(enroll[i], referral[i]);
            price.put(enroll[i], 0);
        }
        // 계산하는 부분
        for (int i = 0; i < seller.length; i++){ // ex ) 1000
            String people = seller[i];
            String s = seller[i];   // 현재 구성원
            int money = amount[i] * 100; // 현재 판매
            int a = money / 10;  // 10% 차감액  100
            int result = money - a; // 현재 가질 수 있는 값  900
            if (price.containsKey(s)) {
                price.put(s, price.get(s) + result);
                while (!name.get(s).equals("-")) {
                    if (money == 0) break;
                    s = name.get(s);
                    money /= 10;
                    a = money / 10;    // 10% 제외
                    result = money - a;   // 다음 추천인이 가질 수 있는 값
                    price.put(s, price.get(s) + result);
                }
            }
        }
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++){
            answer[i] = price.get(enroll[i]);
        }
        return answer;
    }
}