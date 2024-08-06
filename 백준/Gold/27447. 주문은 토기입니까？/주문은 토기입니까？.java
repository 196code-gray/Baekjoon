import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] customers = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int t = Integer.parseInt(st.nextToken());
            customers[i] = t;
        }

        int togi = 0; 
        int coffee = 0;
        int servingTarget = 0; 
        int customer_idx = 0;
        boolean success = true;
        for(int t=0; t<customers[N-1]+1; t++) {
           
            if(customers[servingTarget] == t) {
                if(coffee > 0) { 
                    servingTarget++;
                    coffee--;
                } else {
                    success = false;
                    break;
                }
               
            } else if(customer_idx < N && customers[customer_idx] <= t+M) {
                
                if(togi == 0) {
                    togi++;
                } else { 
                    coffee++;
                    togi--; 
                    customer_idx++;
                }
            } else {
                togi++; 
            }

        }
        if(success) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}