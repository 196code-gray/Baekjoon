import java.io.*;
import java.util.*;

public class Main {
    static int B,max;
    static String A, C;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken(); B = Integer.parseInt(st.nextToken());
        arr = new int[A.length()];
        C = ""; max = Integer.parseInt(A);
        for (int i = A.length() -1; i >= 0; i--) {
            arr[i] = max % 10;
            max /= 10;
        }
        max = -1;
        visited = new boolean[A.length()];
        dfs(0);

        if (max < B) System.out.println(max);
        else System.out.println(-1);

    }
    static void dfs(int len){
        if (len == arr.length){
            if (Integer.parseInt(C) < B) {
                max = Math.max(max, Integer.parseInt(C));
            } return;
        }

        for (int n = 0; n < arr.length; n++) {
            if (len == 0 && arr[n] == 0) continue;
                if (!visited[n]) {
                    C += String.valueOf(arr[n]);
                    visited[n] = true;
                    dfs(len + 1);
                    visited[n] = false;
                    C = C.substring(0, C.length() -1);
                }
        }
    }
}