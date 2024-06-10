import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] parent, num;
    static StringBuilder sb;
    static Map<String, Integer> map;
    static int n, t;
    public static void main(String[] args) throws Exception{
         br = new BufferedReader(new InputStreamReader(System.in));
         t = Integer.parseInt(br.readLine());
         sb = new StringBuilder();

         while (t --> 0){
             n = Integer.parseInt(br.readLine());
             parent = new int[2*100_001];
             num = new int[2*100_001];
             map = new HashMap<>();

             for (int i = 1; i <= 2 * 100_000; i++){
                 parent[i] = i;
                 num[i] = 1;
             }

             int idx = 1;
             for (int i = 0; i < n; i++){
                 st = new StringTokenizer(br.readLine());
                 String f1 = st.nextToken();
                 String f2 = st.nextToken();

                 if (!map.containsKey(f1)){
                     map.put(f1, idx++);
                 }
                 if (!map.containsKey(f2)){
                     map.put(f2, idx++);
                 }

                 int num = union(map.get(f1), map.get(f2));
                 sb.append(num).append("\n");
                
             }
         }
        System.out.println(sb);
    }
    static int union(int f1, int f2){
         f1 = find(f1);
         f2 =find(f2);

        if (f1 == f2) return num[f1];

        if(f1 > f2) { // y가 부모
            parent[f1] = f2;
            num[f2]+= num[f1];
            return num[f2];
        }else{  //x가 부모
            parent[f2] = f1;
            num[f1] += num[f2];
        }
		return num[f1];
    }

    static int find(int a){
        if (parent[a] == a) return a;
        int rx = find(parent[a]);
        return rx;
    }
}