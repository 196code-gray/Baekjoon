import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(fato(input));
    }
    public static int fato(int input) {
        // 쪼개지지 않을 때
        if (input<=1) return 1;

        return fato(input - 1) * input;
    }
}