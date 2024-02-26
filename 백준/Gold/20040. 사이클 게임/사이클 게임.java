import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] parent;
    static int ans;

    static int find(int u) {
        if (parent[u] == u) return u;
        else return parent[u] = find(parent[u]);
    }

    static boolean unionNode(int u, int v) {
        u = find(u);
        v = find(v);

        // 부모노드가 같으면 사이클이 생기므로 true 반환
        if (u == v) {
            return true;
        } else { // Node union
            parent[u] = v;
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int u, v;
        n = sc.nextInt();
        m = sc.nextInt();

        parent = new int[n];

        // 자기자신 부모
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Union Find
        for (int i = 1; i <= m; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            if (unionNode(u, v)) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}
