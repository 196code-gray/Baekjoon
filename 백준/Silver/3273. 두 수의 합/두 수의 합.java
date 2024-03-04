import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]num=new int[n];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++)num[i]=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(br.readLine());
        int ans=0;
        int s=0; int e=n-1;
        Arrays.sort(num);
        while (s<e){
            if(num[s]+num[e]== x){
                ans++;
                s++;e--;
            }
            else if(num[s]+num[e]<x) s++;
            else e--;
        }
        System.out.println(ans);
    }
}