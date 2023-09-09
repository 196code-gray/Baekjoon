import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] date = new int[n + 2];
        int[] time = new int[n + 1];
        int[] pay = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        for (int i = n; i > 0; i--) {
            if (time[i] + i <= n + 1) { // 퇴사 전 가능한 일정
                date[i] = Math.max(date[i + 1], date[i + time[i]] + pay[i]);
            }
            else {  // 퇴사 전 불가능한 일정
                date[i] = date[i + 1];
            }
        }
        System.out.println(date[1]);
    }
}