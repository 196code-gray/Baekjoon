import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 개수
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            Deque<Integer> d = new ArrayDeque<>();
            String[] s = br.readLine().split(""); // 명령어 입력 받기
            int n = Integer.parseInt(br.readLine()); // 숫자 개수
            String[] num = br.readLine()
                    .replace("[", "").replace("]", "").split(",");
            boolean isTure = false;
            if (n == 0) {
                for (int i = 0; i < s.length; i++) {
                    if (s[i].equals("D")) {
                        sb.append("error").append("\n");
                        isTure = true;
                        break;
                    }
                }
                if (!isTure) sb.append("[]").append("\n");
                isTure = true;
            }
            if (isTure) continue;
            for (int i = 0; i < num.length; i++) {
                d.offer(Integer.parseInt(num[i]));
            }

            boolean change = false; // 뒤집기 여부

            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("R")) {
                    change = (change) ? false : true;
                } else {
                    if (d.isEmpty()) {
                        sb.append("error").append("\n");
                        isTure = true;
                        break;
                    }
                    if (change) d.pollLast();
                    else d.pollFirst();
                }
            }

            if (!d.isEmpty()) {
                sb.append("[");
                while (!d.isEmpty()) {
                    if (change) {
                        sb.append(d.pollLast());
                    } else sb.append(d.pollFirst());

                    if (!d.isEmpty()) sb.append(",");
                }
                sb.append("]").append("\n");
            }
            else if (!isTure && d.isEmpty()) sb.append("[]").append("\n");
        }
        System.out.println(sb);
    }
}