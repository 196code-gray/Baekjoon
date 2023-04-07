import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t --> 0) {
            int c = sc.nextInt();

            int q = c/25;
            c = c%25;
            int d = c/10;
            c = c%10;
            int n = c/5;
            c = c%5;
            int p = c;

            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}
