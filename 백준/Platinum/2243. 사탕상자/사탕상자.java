import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int n;
    static long[] tree;
    static final int Max = 1_000_000;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int treeHeight = (int) Math.ceil(Math.log(Max) / Math.log(2)); // 세그먼트 트리 높이
        int treeSize = 1 << (treeHeight + 1); // 트리 사이즈(최대 노드)
        tree = new long[treeSize];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) { // 사탕을 빼는 경우
                int candy = query(1, 0, Max, b);
                sb.append(candy).append("\n");
            } else {
                int c = Integer.parseInt(st.nextToken());
                update(1, 0, Max, b, c);
            }
        }
        System.out.print(sb);
    }
    static int query(int node, int s, int e, int cnt) {
        if (s == e) {
            update(1, 0, Max, s, -1);
            return s;
        }

        int mid = (s + e) / 2;

        if (tree[node*2] >= cnt)
            return query(node * 2, s, mid, cnt);
        return query(node * 2 + 1, mid + 1, e, (int) (cnt - tree[node * 2]));
    }

    static void update(int node, int s, int e, int cnt, int diff) {
        if(s > cnt || e < cnt) return;

        tree[node] += diff;
        if(s == e) return;

        int mid = (s + e) / 2;
        update(node * 2, s, mid, cnt, diff);
        update(node * 2 + 1, mid + 1, e, cnt, diff);
    }
}