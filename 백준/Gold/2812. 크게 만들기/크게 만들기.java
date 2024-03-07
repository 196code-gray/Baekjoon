import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k =Integer.parseInt(st.nextToken());
        String s= br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Integer>stack=new Stack<>();
        stack.push(s.charAt(0) - '0');

        for(int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() < s.charAt(i) - '0' && k > 0) { // 최근에 담은 수보다 큰수가 있을 경우
                while (!stack.isEmpty()) {
                    if (stack.peek() < s.charAt(i) - '0' && k > 0) {
                        stack.pop();
                        k--;
                    }
                    else break;
                }
            }
            stack.push(s.charAt(i) - '0');
        }
        if (k > 0){ // 앞 수가 모두 커서 빠지지 않은 경우
            while (!stack.isEmpty() && k --> 0){
                stack.pop(); // 뒤에서 하나씩 제거
            }
        }
        for (Integer i : stack) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}