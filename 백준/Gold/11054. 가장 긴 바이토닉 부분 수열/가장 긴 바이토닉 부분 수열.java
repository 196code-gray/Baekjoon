import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n]; int[]dp=new int[n]; int[]dp2=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i <n;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        for(int i =0;i<n;i++){
            dp[i]=1;
            for(int j =0; j <i; j++){
                if(num[i]>num[j] && dp[j]+1>dp[i]) dp[i] = dp[j]+1;
            }
        }
        for(int i =n-1;i>=0;i--){
            dp2[i]=1;
            for(int j =n-1; j >i; j--){
                if(num[i]>num[j] && dp2[j]+1>dp2[i]) dp2[i] = dp2[j]+1;
            }
        }
        int max=0;
        for(int i =0;i<n;i++){
            max=Math.max(dp[i]+dp2[i],max);
        }
        System.out.println(max-1);
    }
}