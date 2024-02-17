import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]arr=new int[n];
        int[]dp=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
        dp[0]=arr[0];
        int ans = arr[0];
        for (int i = 1; i<n;i++){
            for(int j = 0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]+=arr[i];
            ans=Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}