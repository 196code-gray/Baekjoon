import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 배열로 문자열 입력 받기
        String strlen = sc.next();
        // 폭발 문자열 입력 받기
        String boom = sc.next();

        Stack<Character> stack = new Stack<>();
        StringBuffer str = new StringBuffer();

        int len = boom.length();

        for (int i = 0; i < strlen.length(); i++) {
            stack.push(strlen.charAt(i));
            if (stack.size() >= boom.length()) {
                boolean boo = true;
                for (int j = 0; j < boom.length(); j++) {
                    if (stack.get(stack.size() - len + j) != boom.charAt(j)) {
                        boo = false;
                        break;
                    }
                }
                if (boo) {
                    for (int a = 0; a < len; a++) {
                        stack.pop();
                    }
                }
            }
        }
            for (char c: stack) {
                str.append(c);
            }
            if (stack.size() == 0) {
                System.out.println("FRULA");
            }
            else System.out.println(str);
    }
}