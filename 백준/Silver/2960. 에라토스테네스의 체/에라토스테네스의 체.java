import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int delete = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 2; i <= n; i++){
            if(!visited[i]){
                for (int j = i; j <= n; j += i) {
                    if (!visited[j]) {
                        visited[j] = true;
                        delete++;
                        if (delete == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}