import java.io.*;
import java.util.*;

public class Main {

    static class Trie {
        Trie[] go;
        boolean output, goexist;

        public Trie() {
            go = new Trie[10];
            output = goexist = false;
        }

        boolean insert(String key) {
            if (key.isEmpty()) { // 해당 전화번호가 없는 경우
                output = true; // 끝이라는 것을 표시
                return !goexist;
            }
            int next = key.charAt(0) - '0';
            if (go[next] == null) go[next] = new Trie();
            goexist = true;
            return !output && go[next].insert(key.substring(1)); // 현재 전화번호가 접두사가 아닌 경우에 재귀
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            Trie root = new Trie();
            boolean result = true;
            for (int i = 0; i < n; i++) {
                String tel = br.readLine();
                if (result && !root.insert(tel)) result = false;
            }
            System.out.println(result ? "YES" : "NO");
        }
    }
}