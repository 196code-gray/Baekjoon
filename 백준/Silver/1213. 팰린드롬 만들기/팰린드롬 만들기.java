import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c = br.readLine();
        int[] abc = new int[26];
        for (int i = 0; i < c.length();i++){
            abc[c.charAt(i) - 65]++;
        }
        int count =0; char odd = ' ';
        for (int i= 0; i < 26; i++){    // 홀수 판별
            if (abc[i] % 2 == 1){
                count++;
                odd = (char) (i + 65);
            }
        }
        if (count >= 2) {   // 홀수 문자가 2개 이상이라면 팰린드롬 불가능
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        if (count == 1){    // 홀수가 1개 있는 경우
            c ="";
            for (int i = 0;i < 26; i++){
                if (abc[i] == 0) continue;
                for (int j = 0; j < abc[i] / 2; j++){
                    c += String.valueOf((char) (i + 65));
                }
            }
            String[] now = c.split("");
            Arrays.sort(now, Collections.reverseOrder());
            c += odd;
            for (String s : now) {
                c += s;
            }
        }
        else {
            c ="";
            for (int i = 0;i < 26; i++){
                if (abc[i] == 0) continue;
                for (int j = 0; j < abc[i] / 2; j++){
                    c += String.valueOf((char) (i + 65));
                }
            }
            String[] now = c.split("");
            Arrays.sort(now, Collections.reverseOrder());
            for (String s : now) {
                c += s;
            }
        }
        System.out.println(c);
    }
}