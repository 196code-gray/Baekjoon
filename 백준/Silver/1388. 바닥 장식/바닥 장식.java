import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        // 2차원 배열 생성 (N : 세로크기) (M : 가로크기)
        char [][] room = new char[N][M];
        // room 안에 요소 입력.
        for (int i = 0; i < N; i++) {
            String a = scanner.next();
            for (int j = 0; j < M; j++) {
                room[i][j] = a.charAt(j);
            }
        }
        // 리턴 할 변수 생성
        int result = 0;

        // 반복문으로 순회
        for (int i = 0; i < N; i++) {
            int a = 0;
            for (int j = 0; j < M; j++) {
                if (room[i][j] == '|') {
                    a = 0;
                }
                else if (++a == 1) {
                    result++;
                }
            }
        }
        for (int j = 0; j < M; j++) {
            int a = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '-') {
                    a = 0;
                }
                else if (++a == 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}