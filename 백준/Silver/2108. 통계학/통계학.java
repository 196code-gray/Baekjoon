import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        double sum = 0;
        for (int i =0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }
        System.out.println(Math.round(sum/n));
        Arrays.sort(a);
        System.out.println(a[a.length/2]);
        int[] arr = new int[8001];
        for (int i = 0; i < n; i++){
            if (a[i] < 0) arr[a[i] * (-1) + 4000]++;
            else arr[a[i]]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (count < arr[i]) count = arr[i];
        }
        ArrayList<Integer> l = new ArrayList<>();
        int sam = 0;
        for (int i = 0; i < arr.length; i++){
            if (count == arr[i]) {
                sam++;
                if(i<4001)l.add(i);
                else if(i>=4001)l.add((-1)*i+4000);
            }
        }
        Collections.sort(l);
        if (sam == 1) System.out.println(l.get(0));
        else if (sam > 1) System.out.println(l.get(1));
        System.out.println(a[n -1] - a[0]);
    }
}