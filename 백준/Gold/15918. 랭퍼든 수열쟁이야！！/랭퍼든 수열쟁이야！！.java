import java.io.*;
import java.util.*;

public class Main {
    static int n, x, y;
    static int[] arr;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new int[25];      // n의 최대 12 * 2 = 24 + 1
        visited = new boolean[13];  // n의 최대 12 + 1
        cnt = 0;

        arr[x] = arr[y] = y - x - 1;    // 양쪽으로 해당 숫자 저장
        visited[y  - x - 1] = true;     // 사용된 숫자 표시
        dfs(1);     // 재귀 시작
        System.out.println(cnt);
    }
    static void dfs(int num) {
        if (num == n * 2 + 1) {     // 랭퍼드 수열의 길이만큼을 arr에 채우면
            cnt++;  // 개수를 증가시켜준다
            return;
        }
        if (arr[num] == 0) {    // 현재 아무 숫자도 저장되어 있지 않은 상태
            for (int i = 1; i <= n; i++) {  
                if (!visited[i]) {      // 해당 숫자가 사용되지 않았다면
                    if (num + i + 1 <= 2 * n && arr[num + i + 1] == 0) {    // num 개 뒤의 인덱스에도 저장이 안되어 있는지 확인
                        visited[i] = true; 
                        arr[num] = arr[num + i + 1] = i;
                        dfs(num + 1);
                        arr[num] = arr[num + i + 1] = 0;
                        visited[i] = false;
                    }
                }
            }
        }
        else dfs(num + 1);
    }
}