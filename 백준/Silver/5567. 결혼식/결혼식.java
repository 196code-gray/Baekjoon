    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine()); int m = Integer.parseInt(br.readLine()); // 노선, 버스
            ArrayList<Integer>[] list = new ArrayList[n+1];

            for(int i =0; i <= n;i++) list[i]=new ArrayList<>();
            for (int i = 0; i < m; i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list[s].add(e);list[e].add(s);
            }
            int count = 0;
            boolean[] visited=new boolean[n+1];
            Queue<int[]>q=new LinkedList<>();
            q.offer(new int[]{1, 1});
            visited[1]=true;
            while (!q.isEmpty()){
                int[] now = q.poll();
                for(int i : list[now[0]]){
                    if(!visited[i]&&now[1]==1){
                        q.offer(new int[]{i, now[0]});
                        visited[i]=true;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }