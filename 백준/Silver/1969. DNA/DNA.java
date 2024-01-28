import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        String[][] dna = new String[n][m];
        int min = 0;
        String ans = "";
        for (int i  = 0; i < n; i++) dna[i] = br.readLine().split("");

        for (int i = 0; i < m; i++){
            int a = 0; int t = 0; int g = 0; int c = 0;

            for (int j = 0; j < n; j++){
                switch (dna[j][i]){
                    case "A":
                        a++;
                        break;
                    case "T":
                        t++;
                        break;
                    case "C":
                        c++;
                        break;
                    case"G":
                        g++;
                        break;
                }
            }
            int max = Math.max(a, Math.max(t, Math.max(c, g)));
            min += (n - max);
            if (max == a) ans += "A";
            else if (max == c) ans += "C";
            else if (max == g) ans += "G";
            else if (max == t) ans += "T";
        }
        System.out.println(ans);
        System.out.println(min);
    }
}