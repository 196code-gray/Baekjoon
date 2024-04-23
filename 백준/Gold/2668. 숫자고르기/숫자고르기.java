import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static List<Integer> list;
    static int[] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        visit = new boolean[n + 1];
        list = new ArrayList<>();

        for (int i=1; i<= n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++){
            visit[num[i]] = true;
            dfs(i, num[i]);
            visit[num[i]] = false;
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer i : list) System.out.println(i);
    }
    static void dfs(int s, int now){
        if (s == now) list.add(s);

        if (!visit[num[now]]){
            visit[num[now]] = true;
            dfs(s, num[now]);
            visit[num[now]] = false;
        }
    }
}