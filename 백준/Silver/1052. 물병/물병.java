import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = s.nextInt();

        int ans = 0;
        while (Integer.bitCount(n) > k){
            ans++;
            n++;
        }
        System.out.println(ans);
    }
}