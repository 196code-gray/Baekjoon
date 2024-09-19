import java.util.*;

public class Main {
    static final int MAX = 2505;
    static ArrayList<Integer>[] Adj = new ArrayList[MAX];
    static int[] Left = new int[MAX], Right = new int[MAX];
    static boolean[] Visit = new boolean[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); 
        int K1 = sc.nextInt(); 
        int K2 = sc.nextInt(); 

        for (int i = 0; i < MAX; i++) {
            Adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < K1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            Adj[from].add(to);
        }

        Arrays.fill(Left, -1);
        Arrays.fill(Right, -1);
        int match1 = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(Visit, false);
            if (DFS(i)) {
                match1++;
            }
        }

        for (int i = 0; i <= N; i++) {
            Adj[i].clear();
        }

        for (int i = 0; i < K2; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            Adj[from].add(to);
        }

        Arrays.fill(Left, -1);
        Arrays.fill(Right, -1);
        int match2 = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(Visit, false);
            if (DFS(i)) {
                match2++;
            }
        }

        if (match1 < match2) {
            System.out.println("네 다음 힐딱이");
        } else {
            System.out.println("그만 알아보자");
        }
    }

    static boolean DFS(int from) {
        Visit[from] = true;
        for (int to : Adj[from]) {
            if (Right[to] == -1 || (!Visit[Right[to]] && DFS(Right[to]))) {
                Left[from] = to;
                Right[to] = from;
                return true;
            }
        }
        return false;
    }
}