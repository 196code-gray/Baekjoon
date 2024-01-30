import java.io.*;
import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= t; j++) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

            long max = a[n - 1];
            long ans = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (a[i] <= max) {
                    ans += (max - a[i]);
                }
                if (a[i] > max) max = a[i];
            }
            sb.append("#" + j).append(" " + ans).append("\n");
        }
        System.out.println(sb);
	}
}