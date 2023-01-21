import java.util.*;
public class Main {
    public static void main(String[] args) {
        // a,b,c를 초로 바꿈 a = 5분 b = 1분 c = 10초
        // t를 받고 a, b, c 순으로 반복문 사용해서 나눔.
        // 뒷 자리가 0이 아니라면 -1를 출력
        Scanner scanner = new Scanner(System.in);
        // 요리시간
        int time = scanner.nextInt();
        // 출력 할 값
        int A = 0;
        int B = 0;
        int C = 0;

        if (time % 10 != 0) {
            System.out.println(-1);
            System.exit(0);
        }

        while (true) {
            if (time >= 300) {
                A += time / 300;
                time %= 300;
            }
            if (time >= 60) {
                B += time / 60;
                time %= 60;
            }
            if (time >= 10) {
                C += time / 10;
                time %= 10;
            }
            if (time == 0) {
                break;
            }
        }
        System.out.println(A +" "+ B +" "+ C);
    }
}