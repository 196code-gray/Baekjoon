import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr, now;
    static int n, m, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while (r --> 0) {
            int dist = Integer.parseInt(st.nextToken());

            turn(dist);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void turn(int num) {
        switch (num) {
            case 1:
                int j = n - 1;
                for (int i = 0; i < n / 2; i++) {
                    int[] up = Arrays.copyOf(arr[i], m);
                    int[] down = Arrays.copyOf(arr[j], m);
                    arr[i] = down;
                    arr[j--] = up;
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    for (j = 0; j < m / 2; j++) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[i][m - j - 1];
                        arr[i][m - j - 1] = temp;
                    }
                }
                break;
            case 3:
                now = new int[m][n];
                for (int i = 0; i < n; i++) {
                    for (j = 0; j < m; j++) {
                        now[j][n - 1 - i] = arr[i][j];
                    }
                }
                int N = m;
                int M = n;
                n = N; // 행 열 전환
                m = M;
                arr = new int[n][m];

                // 회전 값 넣기
                for (int i = 0; i < n; i++) {
                    for (j = 0; j < m; j++) {
                        arr[i][j] = now[i][j];
                    }
                }
                break;
            case 4:
                now = new int[m][n];
                for (int i = 0; i < n; i++) {
                    for (j = 0; j < m; j++) {
                        now[m - 1 - j][i] = arr[i][j];
                    }
                }

                N = m;
                M = n;
                n = N;
                m = M;
                arr= new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (j = 0; j < m; j++) {
                        arr[i][j] = now[i][j];
                    }
                }
                break;

            case 5:
                // 1 -> 2 -> 3 -> 4 -> 1
                now = new int[n][m];
                for (int i = 0; i < n / 2; i++) {
                    for (j = 0; j < m / 2; j++) {
                        now[i][j] = arr[i + n / 2][j];
                        now[i][j + m / 2] = arr[i][j];
                        now[i + n / 2][j + m / 2] = arr[i][j + m / 2];
                        now[i + n / 2][j] = arr[i + n / 2][j + m / 2];
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (j = 0; j < m; j++) {
                        arr[i][j] = now[i][j];
                    }
                }
                break;
            case 6:
                // 1 -> 4 -> 3 -> 2 -> 1
                now = new int[n][m];
                for (int i = 0; i < n / 2; i++) {
                    for (j = 0; j < m / 2; j++) {
                        now[i][j] = arr[i][j + m / 2];
                        now[i][j + m / 2] = arr[i + n / 2][j + m / 2];
                        now[i + n / 2][j + m / 2] = arr[i + n / 2][j];
                        now[i + n / 2][j] = arr[i][j];
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (j = 0; j < m; j++) {
                        arr[i][j] = now[i][j];
                    }
                }
                break;
        }
    }
}