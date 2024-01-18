import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    static int l, c;
    static String result;
    static String[] code;
    static boolean[] visited;
    static StringBuilder sb;
    static Set<Character> vowel = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
        code = new String[c]; visited = new boolean[c];
        vowel.add('a'); vowel.add('e'); vowel.add('i'); vowel.add('o'); vowel.add('u');
        result = "";
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) code[i] = st.nextToken();
        Arrays.sort(code);
        sb = new StringBuilder();
        dfs(0, 0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int s, int e) {
        if (depth == l){
            int count = 0;
            for (int i = 0; i < result.length(); i++){
                if (vowel.contains(result.charAt(i))) count++;
            }
            if (l - count >= 2 && count >= 1) sb.append(result).append("\n");
            return;
        }

        for (int i = e; i < c; i++){
            if (!visited[i]){
                result += code[i];
                visited[i] = true;
                dfs(depth + 1, s + 1, i + 1);
                visited[i] = false;
                result = result.substring(0, s);
            }
        }
    }
}