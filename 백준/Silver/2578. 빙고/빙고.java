import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] bingo = new int[5][5];
        int ans, five, own;
        ans = five = own = 0;

        for (int i = 0;  i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++){
                own = 0;
                int n = Integer.parseInt(st.nextToken());

                for (int k = 0; k < 5; k++){
                    for (int p = 0; p < 5; p++){
                        if (bingo[k][p] == n) bingo[k][p] = 0;
                    }
                }
                for (int k = 0; k < 5; k++){
                    int ab = 0; five = 0;
                    for (int p = 0; p < 5; p++){
                        if (bingo[k][p] == 0) five++;
                        if (bingo[p][k] == 0) ab++;
                    }
                    own += five/5;
                    own += ab/5;
                }

                int idx = 4;
                five = 0;
                for (int k = 0; k < 5; k++){
                    if (bingo[k][idx] == 0) five++;
                    idx--;
                }
                own += five/5;

                idx = 0;
                five = 0;
                for (int k = 0; k < 5; k++){
                    if (bingo[k][idx] == 0) five++;
                    idx++;
                }
                own += five/5;
                ans++;
                if (own > 2) {
                    System.out.println(ans);
                    return;
                };
            }
        }
    }
}