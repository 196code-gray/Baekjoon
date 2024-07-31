import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] deadline;
    static boolean can(int time) {
        int total = 0;
        for(int i=0; i<n; ++i) {
            total += time;
            if(deadline[i] < total) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine().trim());
        deadline = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<n; ++i) {
            deadline[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(deadline);

        int e = deadline[0], s = 1;

        int mid = (s+e)/2;

        while(true) {
            if(s > e && can(mid)) break;
            mid = (s+e) / 2;

            if(can(mid)) { 
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        bw.write(mid + "\n");
        bw.flush();
    }
}