import java.util.*;
class Solution {
    static char[] f = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static Queue<String> q;
    public int solution(int n, String[] data) {
        q = new LinkedList<>();
        
        dfs(0);
        int ans = 0;
        while (!q.isEmpty()){
            String s = q.poll();
            int cnt = 0;
            for (int i= 0; i < data.length; i++){
            if (!possible(s, data[i])) break; // 현재 배치 불가
                cnt++; 
            }
            if (cnt == data.length) ans++; // 가능한 경우의 수
            
        }
        
        return ans;
    }
    static void dfs(int idx){
        if (idx == 8){
            String s= "";
            for (int i = 0;i < 8; i++){
                s +=  f[i];
            }
            q.offer(s);
            return;
        }
        for (int i = idx; i < 8; i++){
            char now = f[i];
            f[i] = f[idx];
            f[idx] = now;
            dfs(idx + 1);
            f[idx]= f[i];
            f[i] = now;
        }
    }
    static boolean possible(String s, String data){
        String target1 = String.valueOf(data.charAt(0)); // 부탁한 사람
        String target2 = String.valueOf(data.charAt(2)); // 상대
        char op = data.charAt(3);  // 같음 || 초과 || 미만
        int dist = Math.abs(s.indexOf(target1) - s.indexOf(target2)) -1;
        int num = data.charAt(4) - '0';
        
        switch(op){
            case '=':
                if (dist == num)
                    return true;
                break;
            case '<':
                if (dist < num) return true;
                break;
            case '>':
                if (dist > num) return true;
                break;
        }
        return false;
    }
}