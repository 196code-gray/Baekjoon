
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String word = sc.next();
            int a = Integer.parseInt(word.substring(0, 1));
            int b = Integer.parseInt(word.substring(word.length() -1));
            System.out.println(a + b);
        }
    }
}