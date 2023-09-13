import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            if (num <= 25) {
                System.out.println("Case #" + i + ": World Finals");
            } else if (num <= 1000) {
                System.out.println("Case #" +i + ": Round 3");
            } else if (num <= 4500) {
                System.out.println("Case #" +i + ": Round 2");
            } else System.out.println("Case #" + i + ": Round 1");
        }
    }
}