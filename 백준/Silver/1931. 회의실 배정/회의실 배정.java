    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[][] time = new int[n][2];
            for (int i = 0; i < n; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                time[i][0] = s;
                time[i][1] = e;
            }
            Arrays.sort(time, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) return o1[0] - o2[0];
                    return o1[1] - o2[1];
                }
            });

            int ans = 0; int now = 0;
            for (int i = 0; i < n; i++){
                if (time[i][0] >= now) {
                    ans++;
                    now = time[i][1];
                }
            }
            System.out.println(ans);
        }
    }
