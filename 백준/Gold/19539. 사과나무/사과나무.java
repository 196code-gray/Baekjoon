import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 수의 개수
        ArrayList<Integer> tree = new ArrayList<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int hap = 0; 
        int count = 0; 

        for(int i=0; i<N; i++){
            int water = Integer.parseInt(stringTokenizer.nextToken());
            count += water/2;
            hap += water; 
        }

        if(hap%3!=0){ 
            System.out.println("NO"); 
        } else { 
            hap = hap / 3; 
            if(count>=hap) 
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}