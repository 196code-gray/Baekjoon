import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테케
        StringBuilder ans = new StringBuilder(); // 출력값 저장
        while (t --> 0){
            String s = br.readLine();
            StringBuilder sb = new StringBuilder(s);
            String answer = "2";
            if (s.equals(sb.reverse().toString())) answer = "0"; // 팰린드롬
            else {
                int left = 0;
                int right = s.length() - 1;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        // 왼쪽, 오른쪽 각각 지워봄
                        StringBuilder delLeft = new StringBuilder(s).deleteCharAt(left);
                        StringBuilder delRight = new StringBuilder(s).deleteCharAt(right);

                        // 둘중 하나라도 성사되면 유사회문
                        if (delLeft.toString().equals(delLeft.reverse().toString()) || delRight.toString().equals(delRight.reverse().toString())) {
                            answer = "1";
                        }
                        break;
                    }
                    left++;
                    right--;
                }
            }
            ans.append(answer).append("\n");
        }
        ans.deleteCharAt(ans.length() - 1);
        System.out.println(ans);
    }
}