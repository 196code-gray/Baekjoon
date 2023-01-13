import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(fibo(input));
    }
    public static int fibo(int input) {
        if (input <= 1) return input;

        return fibo(input - 2) + fibo(input - 1);
    }
}
