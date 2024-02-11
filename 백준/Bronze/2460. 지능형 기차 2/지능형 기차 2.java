import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int train = 0; int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        train += Integer.parseInt(st.nextToken());
        for (int i = 1; i <= 9; i++){
            st = new StringTokenizer(br.readLine());
            if (train > max) max = train;
            train -= Integer.parseInt(st.nextToken());
            train += Integer.parseInt(st.nextToken());
        }
        System.out.println(max);
    }
}