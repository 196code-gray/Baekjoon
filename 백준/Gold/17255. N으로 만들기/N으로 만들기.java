import java.io.*;
import java.util.*;

public class Main {
    static char[] num;
    static Set<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = br.readLine().toCharArray();
        set = new HashSet<>();

        for (int i = 0; i < num.length; i++) {
            DFS(i, i, "" + num[i], "" + num[i]);
        }

        System.out.println(set.size());
    }
    static void DFS(int left, int right, String s, String now){
        if ( s.length() -1 == num.length -1){ // 모든 단어를 조합한 경우
            set.add(now);
            return;
        }

        if (left -1 >= 0){
            DFS(left -1, right, num[left -1] + s, now + " " + num[left -1] + s);
        }
        if (right + 1 < num.length){
            DFS(left, right + 1, s + num[right +1], now + " " + s + num[right + 1]);
        }
    }
}