import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 사용자로부터 N 입력 받기
        int[] use = new int[4]; // 사용중인 기기
        int[] plan = new int[100]; // 계획

        for (int i = 0; i < N; i++) {
            plan[i] = scanner.nextInt() + 1; // 계획 입력 받고 1 증가
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            boolean inUse = false;
            for (int j = 0; j < 4; j++) {
                if (plan[i] == use[j]) {
                    inUse = true;
                    break;
                }
            }
            if (inUse) continue;
            for (int j = 0; j < 4; j++) {
                if (use[j] == 0) {
                    use[j] = plan[i];
                    inUse = true;
                    break;
                }
            }
            if (inUse) {
                result++;
                continue;
            }

            int swap = 0, val = -1;
            for (int j = 0; j < 4; j++) {
                int term = 0;
                for (int k = i + 1; k < N && use[j] != plan[k]; k++) term++;
                if (term > val) {
                    swap = j;
                    val = term;
                }
            }
            result++;
            use[swap] = plan[i];
        }
        System.out.println(result); // 결과 출력
    }
}
