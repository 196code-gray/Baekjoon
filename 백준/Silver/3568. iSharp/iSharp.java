import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().replace(",", "").replace(";", "").split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length; i++){
            Stack<Character> stack = new Stack<>();
            char now = ' ';
            String n = "";
            for (int j = 0; j < s[i].length(); j++){
                now = s[i].charAt(j);
                if (now - 0 == 91 || now - 0 == 93 || now - 0 == 38 || now - 0 == 42){
                    if (now - 0 == 91){
                        stack.push(']');
                        stack.push('[');
                    }
                    else if (now - 0 == 93) continue;
                    else stack.push(now);
                }
                else n += String.valueOf(s[i].charAt(j));
            }
            sb.append(s[0]);
            while (!stack.isEmpty()){
                sb.append(String.valueOf(stack.pop()));
            }
            sb.append(" ").append(n).append(";").append("\n");
        }
        System.out.println(sb);
    }
}