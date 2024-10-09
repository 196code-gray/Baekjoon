import java.io.*;
import java.util.*;

public class Main {
    static int N, K, D;

    static Rule[] rules;
    static class Rule {
        int start, end, gap;

        public Rule(int start, int end, int gap) {
            this.start = start;
            this.end = end;
            this.gap = gap;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        rules = new Rule[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int gap = Integer.parseInt(st.nextToken());

            rules[i] = new Rule(start, end, gap);
        }

        System.out.println(findLastAcornBox());
    }

    private static int findLastAcornBox() { 
        int left = 0;
        int right = N;
        int minIdx = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            long acornOrder = findAcornOrder(mid); 

            if (acornOrder >= D) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
                continue;
            }

            left = mid + 1; 
        }

        return minIdx;
    }

    private static long findAcornOrder(int cur) { 
        long acornNum = 0; 

        for (Rule rule : rules) {
            if (cur < rule.start) { 
                continue;
            }

            int end = Math.min(rule.end, cur);
            acornNum += (end - rule.start) / rule.gap + 1;
        }

        return acornNum;
    }
}