import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

//        if (s > (n*(1+n)/2)) {
//            Arrays.sort(a);
//            for (int i = n -1; i > 0; i--){
//                sb.append(a[i]).append(" ");
//            }
//            System.out.println(sb);
//            return;
//        }
        for (int i = 0; i < n && s > 0; i++){
                int max = a[i];
                int index = -1;

                for (int j = i + 1; j < n && j <= i+s; j++){
                    if (a[j] > max) {
                        max = a[j];
                        index = j;
                    }
                }
                if (index == -1) continue;
                s -= index - i;

                for (int j = index; j >= i + 1; j--){
                    int num = a[j];
                    a[j] = a[j -1];
                    a[j -1] = num;
                }
            }
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append(" ");
        }
        System.out.println(sb);
    }
}