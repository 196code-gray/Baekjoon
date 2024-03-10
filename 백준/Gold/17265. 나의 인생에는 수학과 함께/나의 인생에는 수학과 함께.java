import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n + 1][n + 1];
        int[][] maxDp, minDp;
        maxDp = new int[n + 1][n + 1];
        minDp = new int[n + 1][n + 1];
        int INF = 1_000_000; // 최솟값 위해 초기화

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(map[i], "0");
            Arrays.fill(minDp[i], INF); Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            for (int j = 1; j <= n; j++) {
                map[i][j] = st.nextToken();
            }
        }

        Arrays.fill(minDp[0], INF);
        Arrays.fill(map[0], "0"); Arrays.fill(maxDp[0], Integer.MIN_VALUE);
        minDp[1][1] = maxDp[1][1] = map[1][1].charAt(0) - '0';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Pattern.matches("^[0-9]*$",map[i][j])) { // 숫자일 경우
                    int now = map[i][j].charAt(0) - '0'; // 현재 값
                    if (map[i -1][j].equals("+")){
                        maxDp[i][j] = maxDp[i -1][j] + now;
                        minDp[i][j] = minDp[i -1][j] + now;
                    }
                    else if(map[i -1][j].equals("-")){
                        maxDp[i][j] = maxDp[i -1][j] - now;
                        minDp[i][j] = minDp[i -1][j] - now;
                    }
                    else if (map[i-1][j].equals("*")){
                        maxDp[i][j] = maxDp[i -1][j] * now;
                        minDp[i][j] = minDp[i -1][j] * now;
                    }
                    if (map[i][j-1].equals("+")){
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][j-1] + now); // 더 큰값
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][j-1] + now); // 더 작은값
                    }
                    else if (map[i][j-1].equals("-")){
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][j-1] - now);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][j-1] - now);
                    }
                    else if (map[i][j-1].equals("*")){
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][j-1] * now);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][j-1] * now);
                    }
                }
                else { // 연산자일 경우
                    maxDp[i][j] = Math.max(maxDp[i][j-1], maxDp[i -1][j]);
                    minDp[i][j] = Math.min(minDp[i][j -1], minDp[i-1][j]);
                }
            }
        }
        System.out.println(maxDp[n][n] + " " + minDp[n][n]);
    }
}