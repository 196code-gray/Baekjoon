import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, min = Integer.MAX_VALUE;
    static boolean[] check;     // 해당 치킨집 방문 여부
    static ArrayList<Node> home;    // 집 위치 저장
    static ArrayList<Node> chicken; // 치킨집 위치 저장

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        home = new ArrayList<>(); chicken = new ArrayList<>();

        for (int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) home.add(new Node(i, j));
                else if (now == 2) chicken.add(new Node(i, j));
            }
        }

        check = new boolean[chicken.size()]; // 치킨 집 개수만큼
        dfs(0,0);
        System.out.println(min);
    }
    static void dfs(int count, int idx){
        if (count == m){
            int total = 0;
            for (Node i : home) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++){
                    if (check[j]) {
                    int dist = Math.abs(i.x - chicken.get(j).x) + Math.abs(i.y - chicken.get(j).y);
                    sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(min, total);
        }
        for (int i = idx; i < chicken.size(); i++){
            if (!check[i]){
                check[i] = true;
                dfs(count + 1, i + 1);
                check[i] = false;
            }
        }
    }
}