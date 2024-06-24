import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int n;
    static long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] num, operator, now;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        operator = new int[4];
        now = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());

        DFS(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int depth) {
        if (depth == n -1) {
            int re = result();
            max = Math.max(max, re);
            min = Math.min(min, re);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                now[depth] = i;
                DFS(depth + 1);
                operator[i]++;
                now[depth] = 0;
            }
        }
    }

    static int result(){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int[] priority = {0,0,1,1};

        for (int i= 0;i < n; i++){
            s1.push(num[i]);

            if (i < n -1) {
                if (s2.isEmpty()) // 현재 빈 상태일 경우
                    s2.push(now[i]); // 현재 연산자를 넣는다
                else {
                    while (!s2.isEmpty() && priority[s2.peek()] >= priority[now[i]]) {
                        int a = s1.pop();
                        int b = s1.pop();
                        int result = calculate(b,a, s2.pop());
                        s1.push(result);
                    }
                    s2.push(now[i]);
                }
            }
        }

        while(!s2.isEmpty()){
            int a = s1.pop();
            int b = s1.pop();
            int result = calculate(b,a ,s2.pop());
            s1.push(result);
        }
        return s1.peek();
    }

    static int calculate(int a, int b, int num) {
        switch (num) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
        }
        return -1;
    }
}