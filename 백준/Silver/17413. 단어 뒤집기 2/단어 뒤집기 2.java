import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < s.length(); i++){
            if (s.charAt(i) == '<'){
                sb.append("<");
                while (true){
                    char now = s.charAt(++i);
                    if (i >= s.length()) break;
                    if (now == '>') {
                        sb.append(">");
                        break;
                    }
                    else sb.append(now);
                }
            }
            else if (s.charAt(i) == ' ') sb.append(" ");
            else {
                Stack<Character> stack = new Stack<>();
                while (true){
                    char now = s.charAt(i++);
                    if (now == ' ' || now == '<'){
                        i-= 2;
                        break;
                    }
                    else stack.push(now);
                    if (i >= s.length()) break;
                }
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}