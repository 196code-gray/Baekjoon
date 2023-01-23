import java.util.*;
// Greedy = 최대한 이득을 볼 수 있는 방법을 생각.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 사람의 수
        int person = scanner.nextInt();
        // 걸리는 시간
        int[] time = new int[person];
        for (int i = 0; i < time.length; i++) {
            time[i] = scanner.nextInt();
        }
        // 오름차순 정렬
        Arrays.sort(time);      // 1,2,3,3,4
        // result라는 변수 생성 후 반복문으로 걸리는 시간 더함.
        int sum = time[0]; // 1
        int result = time[0];
        for (int i = 1; i < time.length; i++) {
            sum = sum + time[i];
            result += sum;
        }
        // 출력
        System.out.println(result);
    }
}