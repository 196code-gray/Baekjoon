import java.io.*;
import java.util.*;

public class Main {
    static int[] card;
    static boolean[] visit;
    static Set<String> set;
    static BufferedReader br;
    static int n, k;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        card = new int[n]; visit = new boolean[n];
        for (int i =0; i < n; i++)
            card[i] = Integer.parseInt(br.readLine());

        DFS(0, "");
        System.out.println(set.size());
    }
    static void DFS(int depth, String s){
        if (depth == k){
            set.add(s);
            return;
        }

        for (int i= 0;i < card.length;i++){
            if (visit[i]) continue;
            visit[i] = true;
            DFS(depth + 1, s + String.valueOf(card[i]));
            visit[i] = false;
        }
    }
}