import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()) {
            int now = sc.nextInt();
            int o = 1; int k = 1;
            while (true) {
                if (o % now == 0) break;
                o = o * 10 + 1;
                o %= now;
                k++;
            }
            sb.append(k).append("\n");
        }
        System.out.println(sb);
    }
}