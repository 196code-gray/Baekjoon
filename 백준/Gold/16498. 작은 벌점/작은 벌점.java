import java.util.*;
import java.io.*;

class Main {
    static int A,B,C,ans;
    static int[] A_card, B_card, C_card;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        A_card = new int[A]; B_card = new int[B]; C_card = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++)
            A_card[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++)
            B_card[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++)
            C_card[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A_card);
        Arrays.sort(B_card);
        Arrays.sort(C_card);

        for (int i = 0; i < A; i++){
            int a = A_card[i];
            int b = select(a, B_card);
            int c1= select(a, C_card);
            int c2= select(b, C_card);
            int now1 = Math.max(a, Math.max(b, c1)) - Math.min(a, Math.min(b, c1));
            int now2 = Math.max(a, Math.max(b, c2)) - Math.min(a, Math.min(b, c2));

            ans = Math.min(now1, Math.min(now2, ans));
        }
        System.out.println(ans);
    }
    private static int select(int num, int[] card){
        int s = 0;
        int e = card.length -1;
        int mid = (s + e) / 2;
        int result = card[mid];

        while(s <= e){
            mid = (s + e) / 2;
            if (card[mid] == num)
                return num;
            if (card[mid] < num)
                s = mid + 1;
            else if(card[mid] > num)
                e = mid -1;

            if (change(num, result, card[mid])) result = card[mid];
        }
        return result;
    }
    private static boolean change(int num, int result, int now) {
        return Math.abs(num - result) > Math.abs(num - now);
    }
}