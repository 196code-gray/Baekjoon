import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int n, end, ans;
    static PriorityQueue<Station> q = new PriorityQueue<>();
    static List<Integer>[] sameStation, sameLine;
    static Map<Integer, Integer> map;
    static boolean[][] visit = new boolean[11][101];
    static StringTokenizer st;
    static class Station implements Comparable<Station> {
        int cnt, num, line;

        public Station(int cnt, int num, int line) {
            this.cnt = cnt;
            this.num = num;
            this.line = line;
        }

        @Override
        public int compareTo(Station o1){
            if (this.cnt > o1.cnt){
                return 1;
            } else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sameStation = new ArrayList[101];
        sameLine = new ArrayList[11];
        map = new HashMap<>();

        for (int i = 0; i <= 100; i++) sameStation[i] = new ArrayList<>();

        for (int i = 0; i <= 10; i++) sameLine[i] = new ArrayList<>();

        int idx = 1;
        for (int i = 1; i <= n; i++){ // 1호선 ~ N호선
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                if (!map.containsKey(num)){ // 처음 나온 역 번호일 경우
                    map.put(num, idx); // 역, 현재 번호(ex. 1번역, 4번째)
                    sameStation[idx].add(i); // idx번째에 i호선
                    sameLine[i].add(idx); // i호선에 idx역
                    idx++;
                } else {
                    sameStation[map.get(num)].add(i);
                    sameLine[i].add(map.get(num));
                }
            }
        }
        end = Integer.parseInt(br.readLine());

        BFS();
        System.out.println(ans);
    }
    static void BFS(){
        ans = -1;

        for (int i = 0; i < sameStation[map.get(0)].size(); i++){
            q.offer(new Station(0, map.get(0), sameStation[map.get(0)].get(i)));
        }

        while(!q.isEmpty()){
            Station now = q.poll();

            int cnt = now.cnt;
            int num = now.num;
            int line = now.line;

            if (map.get(end) == num){ // 목표 역 도착
                ans = cnt;
                return;
            }

            for (int i = 0; i < sameStation[num].size(); i++){
                if (!visit[sameStation[num].get(i)][num]){
                    visit[sameStation[num].get(i)][num] = true;
                    q.offer(new Station(cnt + 1, num, sameStation[num].get(i)));
                }
            }

            for (int i = 0; i < sameLine[line].size(); i++){
                if (!visit[line][sameLine[line].get(i)]){
                    visit[line][sameLine[line].get(i)] = true;
                    q.offer(new Station(cnt, sameLine[line].get(i), line));
                }
            }
        }
    }
}