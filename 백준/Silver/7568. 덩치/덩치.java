import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] people = new int[n][3];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int kg = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());
            people[i][0] = kg; people[i][1] = cm;
            people[i][2] = i;
        }
        Arrays.sort(people, ((o1, o2) -> o2[0] - o1[0]));
        int rank = 0;
//        int[][] max = new int[1][2];
        int[] ans = new int[n];
//        max[0][0] = people[0][0]; max[0][1] = people[0][1];
        for (int i = 0; i < n; i++) {
            rank = 1;
            for (int j = 0; j < n; j++) {
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    ans[people[i][2]] = rank++;

                } else if (people[j][0] >= people[i][0] || people[j][1] >= people[i][1]) {
                    ans[people[i][2]] = rank;
                }
//                else {
//                    ans[people[i][2]] = i + 1;
//                    rank++;
//                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }
}