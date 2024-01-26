import java.util.*;
import java.io.*;
class Main{
    static int[] operator, num;
    static int max, min, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n]; operator = new int[4];
        max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
        for (int i= 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i= 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());

        dfs(1, num[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int depth, int re){
        if (depth == n){
            max = Math.max(re , max);
            min = Math.min(re, min);
            return;
        }
                for (int j = 0; j < 4; j++) {
                    if (operator[j] > 0){
                        operator[j]--;

                        if (j == 0) dfs(depth + 1, re + num[depth]);
                        else if (j == 1) dfs(depth + 1,  re - num[depth]);
                        else if (j == 2) dfs(depth + 1,  re * num[depth]);
                        else if (j == 3) dfs(depth+ 1, re / num[depth]);
                        operator[j]++;
                    }
                    }
                }
    }