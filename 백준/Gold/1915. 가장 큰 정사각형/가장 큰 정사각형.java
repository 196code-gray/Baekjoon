import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());int m =Integer.parseInt(st.nextToken());
        String[][]arr=new String[n][m];int[][] dp =new int[n+1][m+1];
        for(int i =0;i<n;i++) arr[i]=br.readLine().split("");
        int ans =0;
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(arr[i-1][j-1].equals("0")) continue;
                dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                ans =Math.max(ans, dp[i][j]*dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}