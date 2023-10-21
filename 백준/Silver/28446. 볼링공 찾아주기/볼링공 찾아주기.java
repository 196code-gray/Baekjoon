import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                int number = Integer.parseInt(st.nextToken());
                map.put(Integer.parseInt(st.nextToken()), number);
            } else {
                System.out.println(map.get(Integer.parseInt(st.nextToken())));
            }
        }
    }
}