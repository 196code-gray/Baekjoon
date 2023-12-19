import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ' ' || s.charAt(j) == '\n') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(s.charAt(j));
                }
                else stack.push(s.charAt(j));
            }
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
            System.out.println(sb);
        }

    }
}