import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 일 수
        int[] solvedPerDay = new int[N];

        // 각 날짜별 문제 풀이 횟수 입력
        for (int i = 0; i < N; i++) {
            solvedPerDay[i] = sc.nextInt();
        }

        int maxStreak = 0;
        int currentStreak = 0;

        for (int i = 0; i < N; i++) {
            if (solvedPerDay[i] > 0) {
                currentStreak++;
                maxStreak = Math.max(maxStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }

        System.out.println(maxStreak);
    }
}
