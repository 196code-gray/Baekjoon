import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 3001;
    static int N;
    static int[][] MAP = new int[MAX][MAX];
    static int Food = 0;
    static StringBuilder Move = new StringBuilder();
    static Pair NowFirst, NowLast;

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        settings();
        findAnswer();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        NowFirst = new Pair(N / 2, N / 2);
        NowLast = new Pair((N / 2) + 1, (N / 2) + 1);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int M = Integer.parseInt(st.nextToken());
                MAP[i][j] = MAP[i - 1][j] + MAP[i][j - 1] - MAP[i - 1][j - 1] + M;
            }
        }
    }

    static void settings() {
        while (true) {
            int NowFood = 0;
            int Dir = -1;

            if (NowFirst.first > 1) {
                int Up = MAP[NowFirst.first - 1][NowLast.second]
                        - MAP[NowFirst.first - 2][NowLast.second]
                        - MAP[NowFirst.first - 1][NowFirst.second - 1]
                        + MAP[NowFirst.first - 2][NowFirst.second - 1];

                if (Up > NowFood) {
                    NowFood = Up;
                    Dir = 0;
                }
            }

            if (NowLast.first < N) {
                int Down = MAP[NowLast.first + 1][NowLast.second]
                        - MAP[NowLast.first][NowLast.second]
                        - MAP[NowLast.first + 1][NowFirst.second - 1]
                        + MAP[NowLast.first][NowFirst.second - 1];

                if (Down > NowFood) {
                    NowFood = Down;
                    Dir = 1;
                }
            }

            if (NowFirst.second > 1) {
                int Left = MAP[NowLast.first][NowFirst.second - 1]
                        - MAP[NowFirst.first - 1][NowFirst.second - 1]
                        - MAP[NowLast.first][NowFirst.second - 2]
                        + MAP[NowFirst.first - 1][NowFirst.second - 2];

                if (Left > NowFood) {
                    NowFood = Left;
                    Dir = 2;
                }
            }

            if (NowLast.second < N) {
                int Right = MAP[NowLast.first][NowLast.second + 1]
                        - MAP[NowFirst.first - 1][NowLast.second + 1]
                        - MAP[NowLast.first][NowLast.second]
                        + MAP[NowFirst.first - 1][NowLast.second];

                if (Right > NowFood) {
                    NowFood = Right;
                    Dir = 3;
                }
            }

            if (NowFood <= 0) {
                break;
            }
            Food += NowFood;
            if (Dir == 0) {
                NowFirst.first--;
                Move.append('U');
            } else if (Dir == 1) {
                NowLast.first++;
                Move.append('D');
            } else if (Dir == 2) {
                NowFirst.second--;
                Move.append('L');
            } else if (Dir == 3) {
                NowLast.second++;
                Move.append('R');
            }
        }
    }

    static void findAnswer() {
        System.out.println(Food);
        System.out.println(Move);
    }
}