import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        boolean[][] visited = new boolean[101][101];
        while (n --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int down = Integer.parseInt(st.nextToken());
            for (int i = down+1; i <= down + 10; i++){
                for (int j = left+1; j <= left + 10; j++){
                    if (!visited[i][j]) {
                        ans++;
                        visited[i][j] = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}