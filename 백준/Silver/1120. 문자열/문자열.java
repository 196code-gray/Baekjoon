import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = ""; String B = "";
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken(); B = st.nextToken();

        if (A.length() < B.length()) {
            int count = 1000;
            for (int i = 0; i <= B.length() - A.length(); i++) {
                int max = 0;
                for (int j = 0; j < A.length(); j++) {
                    if (A.charAt(j) != B.charAt(j + i)) max++;
                }
                if (count > max) count = max;
            }
            System.out.println(count);
            return;
        }
        else {
            int count = 0;
            for (int i = 0; i < A.length(); i++){
                if (A.charAt(i) != B.charAt(i)) count++;
            }
            System.out.println(count);
        }
    }
}