import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, M;
    static char[][] arr;
    static int[][] dp;
    static boolean[][] visited;
    static int[][] directions = { {0, -1}, {1, -1}, {-1, -1} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and M
        String[] input = br.readLine().trim().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().trim().toCharArray();
        }

       
        int[] rabbitPos = findRabbitStart();
        int ri = rabbitPos[0], rj = rabbitPos[1];
        visited[ri][rj] = true;

        List<Integer> sideDoors = new ArrayList<>();

        
        for (int j = rj + 1; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == '#') continue; 

                int mostCarrotSpot = 0;
                boolean flag = false; 

                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (isInBounds(ni, nj) && visited[ni][nj]) { 
                        mostCarrotSpot = Math.max(mostCarrotSpot, dp[ni][nj]);
                        flag = true;
                    }
                }

                if (!flag) continue; 

                visited[i][j] = true; 

                if (arr[i][j] == 'C') {
                    dp[i][j] = mostCarrotSpot + 1; 
                } else if (arr[i][j] == '.') {
                    dp[i][j] = mostCarrotSpot;
                } else if (arr[i][j] == 'O') { 
                    dp[i][j] = mostCarrotSpot;
                    sideDoors.add(mostCarrotSpot);
                }
            }
        }

        
        if (!sideDoors.isEmpty()) {
            System.out.println(sideDoors.stream().max(Integer::compareTo).get());
        } else {
            System.out.println(-1);
        }
    }

   
    private static int[] findRabbitStart() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'R') {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

 
    private static boolean isInBounds(int ni, int nj) {
        return ni >= 0 && ni < N && nj >= 0 && nj < M;
    }
}