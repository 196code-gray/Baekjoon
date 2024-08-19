import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();

        if (x == 0) {
            System.out.println("NO");
            return;
        }

        while (x != 0) {
            if (x % 3 > 1) {
                System.out.println("NO");
                return;
            }
            x /= 3;
        }

        System.out.println("YES");
    }
}
