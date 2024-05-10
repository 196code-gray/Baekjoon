import java.util.*;
class Solution {
    static int cnt, len, ans = Integer.MAX_VALUE;
    static int[] pick;
    static String[] mineral;
    public int solution(int[] picks, String[] minerals) {
        pick = new int[picks.length]; mineral = new String[minerals.length];
        cnt = len = 0;
        
        for (int i = 0; i < 3; i++) {
            pick[i] = picks[i];
            if (pick[i] == 0) cnt++; // 사용 못하는 곡괭이 카운트
        }
        for (int i = 0; i < minerals.length; i++) {
            mineral[i] = minerals[i];
        }
        
        DFS(0, 0, 0); // 곡괭이, 피로도, 광물 진행
        
        
        return ans;
    }
    static void DFS(int idx, int mp, int progress){
        if (cnt == 3 || progress == mineral.length) { // 종료 조건에 해당하는경우
            ans = Math.min(ans, mp);
            return;
        }
        
        for (int i = 0; i < 3; i++){
            if (pick[i] == 0) continue;
            int m = start(i, mp, progress);
            pick[i] = pick[i] -1;
            if (pick[i] ==0) cnt++;
            DFS(i, m, progress + 5); // 현재 곡괭이, 피로도, 광물 진행
            if (pick[i] == 0) cnt--;
            pick[i] = pick[i] + 1;
        }
    }
    static int start(int idx, int m, int p){
        for (int i = p; i < p + 5; i++){
            if (i >= mineral.length) break;
            if (idx == 0) m += 1; // 다이아몬드 곡괭이
            else if (idx == 1){
                if (mineral[i].length() == 7) m += 5;
                else m += 1;
            } else {
                if (mineral[i].length() == 4) m += 5;
                else if (mineral[i].length() == 7) m+= 25;
                else m += 1;
            }
        }
        return m;
    }
}