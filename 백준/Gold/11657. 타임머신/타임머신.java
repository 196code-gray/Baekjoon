import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int start, end, time;

        public Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    static int n, m;
    static final int INF = 10_000_000;
    static long[] dist;
    static Node[] node;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        dist = new long[n + 1]; node = new Node[m + 1];
        for (int i = 1; i <= n; i++) dist[i] = INF; // 초기값

        for (int i = 0; i < m; i++){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            node[i] = new Node(s,e,t);
        }

        boolean cycle = BellmanFord(1);
        if (cycle){
            sb.append("-1");
        }
        else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) {
                    sb.append("-1").append("\n");
                } else sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
    static boolean BellmanFord(int s){
        dist[s] = 0;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < m; j++){
                Node no = node[j];
                if (dist[no.start] != INF && dist[no.end] > dist[no.start] + no.time){
                    dist[no.end] = dist[no.start] + no.time;
                }
            }
        }
            for (int j = 0; j < m; j++){
                Node no = node[j];
                if (dist[no.start] != INF && dist[no.end] > dist[no.start] + no.time){
                    return true;
                }
            }
        return false;
    }
}