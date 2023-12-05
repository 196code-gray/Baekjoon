import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        List<Integer>[] list = new List[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++)  {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        for (int i = 1; i <= 5; i++) {
            if (i != 1) time += 60;
            Collections.sort(list[i]);
            int j = 0;
            while (arr[i] --> 0) {
                time += list[i].get(j);
                if (j > 0) time += list[i].get(j) - list[i].get(j -1);
                j++;
            }
        }
        System.out.println(time);
    }
}