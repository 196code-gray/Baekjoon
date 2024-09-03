import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        StringTokenizer st;
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            return e2[1] - e1[1];
        }); 

        int lastEndPoint = arr[0][1]; 
        for(int i=0; i<n; ++i){
            if(arr[i][1] <= lastEndPoint){
                lastEndPoint = arr[i][1] - arr[i][0];
            }
            else{ 
                lastEndPoint -= arr[i][0];
            }
        }

        System.out.print(lastEndPoint);

    }
}