import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 기적의 매매법

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        int money = Integer.parseInt(br.readLine());
        int[] stock = new int[14];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        }


        // 준현이
        int money1 = money;
        int cnt1 = 0;
        for (int i = 0; i < 14; i++) {
            cnt1 += money1 / stock[i];
            money1 %= stock[i];
        }


        // 성민이
        int money2 = money;
        int cnt2 = 0;

        for (int i = 3; i < 14; i++) {
            // 3일 연속 가격이 상승
            if (stock[i - 3] < stock[i - 2] && stock[i - 2] < stock[i - 1] && stock[i - 1] < stock[i]) {
                money2 += (cnt2 * stock[i]);
                cnt2 = 0;
            }

            // 3일 연속 가격이 하락
            if (stock[i - 3] > stock[i - 2] && stock[i - 2] > stock[i - 1] && stock[i - 1] > stock[i]) {
                cnt2 += (money2 / stock[i]);
                money2 %= stock[i];
            }
        }

        int result1 = money1 + (stock[13] * cnt1);
        int result2 = money2 + (stock[13] * cnt2);
        if (result1 > result2) {
            System.out.println("BNP");
        } else if (result1 == result2) {
            System.out.println("SAMESAME");
        } else {
            System.out.println("TIMING");
        }

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}