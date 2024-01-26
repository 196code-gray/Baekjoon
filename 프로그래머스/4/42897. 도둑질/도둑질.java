import java.util.*;
class Solution {
    public int solution(int[] money) {
        int[][] house = new int[2][money.length];
        house[0][0] = money[0];
        house[0][1] = money[0];
        house[1][1] = money[1];
        house[1][0] = 0;
        
        for (int i = 2; i <= money.length -1; i++){
            house[0][i] = Math.max(house[0][i-1], money[i] + house[0][i -2]);
            house[1][i] = Math.max(house[1][i -1], money[i] + house[1][i -2]);
        }
        System.out.println("이거 1부터 시작하는 총 최댓값 " + house[0][money.length -1]);
        System.out.println("이건 4까지 있는 거" + house[1][money.length -1]);
        return Math.max(house[0][money.length -2], house[1][money.length -1]);
    }
}