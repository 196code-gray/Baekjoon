import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money =  Integer.parseInt(br.readLine());
        int[] count = new int[2]; int[] result = new int[2];
        int[] a = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) a[i] = Integer.parseInt(st.nextToken());

        result[1] = result[0] = money;
        for (int i = 0; i < 14; i++){
            if(a[i] <= result[0]){
                count[0] = (result[0] / a[i]);
                result[0] -= (result[0] / a[i]) * a[i];
            }
        }
        for (int i = 3; i < 14;i ++){
            if (a[i -2] < a[i- 1] && a[i - 3] < a[i -2]) {
                result[1] += a[i] * count[1];
                count[1] = 0;
            }
            else if (a[i -1] < a[i -2] && a[i -2] < a[i -3]){
                count[1] += result[1] / a[i];
                result[1] -= (result[1]/a[i]) * a[i];
            }
        }
        if ((result[0] + (a[13] * count[0])) == (result[1] + (a[13] * count[1]))) System.out.println("SAMESAME");
        else System.out.println((result[0] + (a[13] * count[0])) > (result[1] + (a[13] * count[1])) ? "BNP" : "TIMING");
    }
}