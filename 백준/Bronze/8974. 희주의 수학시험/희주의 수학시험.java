import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[1001]; // 배열의 크기를 1001로 초기화
        int k = 1, a, b, sum = 0;

        // 입력 받기
        a = scanner.nextInt();
        b = scanner.nextInt();

        // 배열 arr를 문제의 조건대로 채우기
        for (int i = 1; i <= 1000;) {
            for (int j = 1; j <= k && i <= 1000; j++) {
                arr[i++] = k;
            }
            k++;
        }

        // a부터 b까지의 합 계산
        for (int i = a; i <= b; i++) {
            sum += arr[i];
        }

        // 결과 출력
        System.out.println(sum);
        scanner.close();
    }
}