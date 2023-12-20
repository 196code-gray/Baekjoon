import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n], score = new int[n + 1];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            card[i] =Integer.parseInt(st.nextToken());
            max = Math.max(card[i], max);
        }
        int[] num= new int[max + 1];
        int j=1;

        for (int i : card) {
            num[i] = j;
            j++;
        }

        for (int i : card) {
            for (int k = i*2;k<=max;k+=i){
                if (num[k] != 0) {
                    score[num[i]]++;
                    score[num[k]]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < score.length; i++) {
            sb.append(score[i]).append(" ");
        }
        System.out.println(sb);
    }
}