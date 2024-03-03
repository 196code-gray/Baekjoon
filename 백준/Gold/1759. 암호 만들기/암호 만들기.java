import java.util.*;
import java.io.*;

public class Main {
    static int L,C;
    static StringBuilder sb = new StringBuilder();
    static String[] str, abc = {"a", "e", "i", "o", "u"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); // 길이, 주어진 문자

        str = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< C; i++){
            str[i] = st.nextToken();
        }
        Arrays.sort(str);
        dfs(0, "", 0);
        System.out.println(sb);
    }
    static void dfs(int depth, String pw, int idx){
        if (depth == L){
            String s = pw;
            for (int i = 0; i < 5; i++){
                s = s.replace(abc[i], "");
            }
            if (s.length() >= 2 && pw.length() != s.length()){
                sb.append(pw).append("\n");
            }
            return;
        }
        for (int i = idx; i < C; i++){
            dfs(depth + 1, pw + str[i], i+1);
        }
    }
}