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
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i< m; i++){
            box.add(Integer.parseInt(st.nextToken()));
            if (max < box.get(i)) max = box.get(i);
        }
        box.sort(Collections.reverseOrder());
        int e = 0;
        while (true){
            if (a[0] < max) {
                System.out.println(-1);
                return;
            }
            int boxidx = 0; int aidx = 0;

            while (aidx < a.length){
                if (boxidx == box.size()) break;
                if (a[aidx] >= box.get(boxidx)) {
                    box.remove(boxidx);
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