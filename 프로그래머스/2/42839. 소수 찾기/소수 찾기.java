import java.util.*;
class Solution {
    static boolean[] visited = new boolean[10_000_000];  // 소수 방문
    static boolean[] s; // 현재 담겨있는 인덱스
//    static String n = "";   // 문자열 담는 객체
    static int ans = 0, num;
    public int solution(String numbers) {
        s = new boolean[numbers.length() + 1];
        visited[0] = true; visited[1] = true;
        for (int i = 0; i < numbers.length(); i++) {
            dfs(i + 1, numbers, "");
        }
        System.out.println(ans);

        return ans;
    }
    static void dfs(int depth, String numbers, String n) {
        if (depth == n.length()) {
            if (!visited[Integer.parseInt(n)] && isPrime(Integer.parseInt(n))) {    // 한번도 안들린 소수 && 소수 확인
                visited[Integer.parseInt(n)] = true;
                ans++;
            }
            return;
        }
        for (int j = 0; j < numbers.length(); j++) {
            if (!s[j]) {
                n += numbers.charAt(j);
                s[j] = true;
                dfs(depth, numbers, n);
                n = n.substring(0, n.length() -1);
                s[j] = false;
            }
        }
    }
        // 소수 판별
        static boolean isPrime(int n){
        for (int i = 2; i<= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
        }
}