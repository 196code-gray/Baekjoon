import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<Integer>();
        int[] parentCnt = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            parentCnt[e]++;
        }
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++)
            if (parentCnt[i] == 0) // 선수과목에 해당하는 과목만 저장
                que.add(i);
        int[] ans = new int[N + 1];
        int hak = 1;

        while (!que.isEmpty()) {
            int size = que.size(); // 현재 학기에 해당하는 과목 수
            while (size --> 0) {
                int now = que.poll();
                ans[now] = hak;
                for (int child : arr[now])
                    if (--parentCnt[child] == 0)
                        que.add(child);
            }
            hak++;
        }
        for(int i = 1 ; i <= N ; i++)
            System.out.print(ans[i]+" ");

    }
}