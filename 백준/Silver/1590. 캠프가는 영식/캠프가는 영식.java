import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int arrival = Integer.parseInt(st.nextToken());
        int time = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            if (start == arrival){
                System.out.println("0");
                return;
            }
            else {
                while(count--> 0){

                    if (start >= arrival) {
                        time = Math.min(time, start-arrival);
                        break;
                    }
                    start += mid;
                }
            }
        }
        if (time == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(time);
    }
}