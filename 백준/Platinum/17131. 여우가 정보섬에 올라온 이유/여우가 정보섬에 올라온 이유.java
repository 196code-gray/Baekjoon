import java.io.*;
import java.util.*;

class Vec {
    int x, y;
    
    Vec(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Tree {
    int[] node;

    Tree(int size) {
        node = new int[size];
    }

    void insert(int cur, int left, int right, int index, int val) {
        if (left == right) {
            node[cur] += val;
            return;
        }
        int mid = (left + right) / 2;
        if (index <= mid) insert(cur * 2, left, mid, index, val);
        else insert(cur * 2 + 1, mid + 1, right, index, val);
        node[cur] = node[cur * 2] + node[cur * 2 + 1];
    }

    long search(int cur, int left, int right, int start, int end) {
        if (left > end || right < start) return 0;
        if (left <= start && right >= end) return node[cur];
        int mid = (start + end) / 2;
        long sum = 0;
        if (left <= mid) sum += search(cur * 2, left, right, start, mid);
        if (right > mid) sum += search(cur * 2 + 1, left, right, mid + 1, end);
        return sum;
    }
}

public class Main {
    static int N;
    static final int MOD = 1000000007;
    static Vec[] arr = new Vec[200000];
    static Tree tree = new Tree(800000);
    static List<Integer> batch_y = new ArrayList<>();

    static void compress() {
        Arrays.sort(arr, 0, N, (a, b) -> Integer.compare(a.x, b.x));
        int prev = Integer.MAX_VALUE, rank = -1;
        for (int i = 0; i < N; i++) {
            if (prev != arr[i].x) rank++;
            prev = arr[i].x;
            arr[i].x = rank;
        }
        Arrays.sort(arr, 0, N, (a, b) -> Integer.compare(b.y, a.y));
    }

    static long batchProcess() {
        long ret = 0;
        for (int y : batch_y) {
            ret = (ret + tree.search(1, 0, y - 1, 0, N - 1) * tree.search(1, y + 1, N - 1, 0, N - 1)) % MOD;
        }

        for (int y : batch_y) {
            tree.insert(1, 0, N - 1, y, 1);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arr[i] = new Vec(x, y);
        }

        compress();
        long ans = 0;
        int past_y = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (past_y != arr[i].y) {
                ans = (ans + batchProcess()) % MOD;
                batch_y.clear();
                past_y = arr[i].y;
            }
            batch_y.add(arr[i].x);
        }

        ans = (ans + batchProcess()) % MOD;
        System.out.println(ans);
    }
}