import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = 0;
        int n= Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, Collections.reverseOrder());
        int m = Integer.parseInt(br.readLine());
        Integer[] box = new Integer[m];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i< m; i++){
            box[i] = Integer.parseInt(st.nextToken());
            if (max < box[i]) max = box[i];
        }
        Arrays.sort(box, Collections.reverseOrder());
        int e = 0;
        boolean[] boxv = new boolean[m];
        while (true){
            if (a[0] < max) {
                System.out.println(-1);
                return;
            }
            int boxidx = 0; int aidx = 0;

            while (aidx < a.length){
                if (boxidx == box.length) break;
                if (a[aidx] >= box[boxidx] && !boxv[boxidx]) {
                    boxv[boxidx] = true;
                    e++;
                    aidx++;
                }
                else boxidx++;
            }

            time++;
            if (e == m) break;
        }
        System.out.println(time);
    }
}