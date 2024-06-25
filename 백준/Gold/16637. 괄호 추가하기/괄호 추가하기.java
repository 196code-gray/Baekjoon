import java.util.*;
import java.io.*;

class Main{
    static BufferedReader br;
    static int n, ans;
    static char[] num;
    public static void main(String[] args)throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = Integer.MIN_VALUE;
        num = new char[n];

        String s = br.readLine();
        for (int j = 0; j < s.length(); j++)
            num[j] = s.charAt(j);

        DFS(2, num[0] - '0');
        System.out.print(ans);
    }
    static void DFS(int idx, int result){
        // 모든 숫자 다 계산한 경우
        if (idx >= n){
            ans = Math.max(ans, result);
            return;
        }

        // 아직 괄호 없는 경우
        DFS(idx + 2, op(result, num[idx] - '0', num[idx -1]));

        // 괄호 넣을 수 있는 경우
        if (idx + 2 < n){
            int right = op(num[idx] -'0', num[idx + 2] - '0', num[idx +1]);
            int left = op(result, right, num[idx  -1]);
            DFS(idx + 4, left);
        }
    }
    static int op(int a, int b, char now){
        switch (now){
            case '+':
                return a + b;
            case '-':
                return a-b;
            case '*':
                return a * b;
        }
        return 0;
    }
}