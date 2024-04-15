import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>(); int cnt = 0; int kg = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int truck = Integer.parseInt(st.nextToken());
            while (true){
                if (q.isEmpty()){
                    q.offer(truck);
                    kg += truck;
                    cnt++;
                    break;
                } else if (q.size() == M){
                    kg -= q.poll();
                } else {
                    if (kg + truck <= L){
                        q.offer(truck);
                        kg += truck;
                        cnt++;
                        break;
                    } else {
                        q.offer(0);
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt + M);
    }
}