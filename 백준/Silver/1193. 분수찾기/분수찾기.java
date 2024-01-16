import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;  // 대각선
        int sum = 0;    // 합
        while (true){
            if (n <= count + sum){
                if (count % 2 == 0){
                    System.out.println((n - sum) + "/" + (count - (n - sum -1)));
                    break;
                } else {
                    System.out.println((count - (n - sum - 1)) + "/" + (n - sum));
                    break;
                }
            }
            else {
                sum += count;
                count++;
            }
        }
    }
}