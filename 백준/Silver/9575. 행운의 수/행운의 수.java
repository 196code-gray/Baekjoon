import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            int[] a = macro(br.readLine());

            br.readLine();
            int[] b = macro(br.readLine());

            br.readLine();
            int[] c = macro(br.readLine());

            Set<Integer> set = new HashSet<>();
            for (int i : a) {
                for (int j : b) {
                    for (int k : c) {
                        int sum = i + j + k;
                        if (check(sum))
                            set.add(sum);
                    }
                }
            }

            sb.append(set.size()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean check(int n) {
        while (n != 0) {
            if (n % 10 != 5 && n % 10 != 8)
                return false;
            n /= 10;
        }

        return true;
    }

    private static int[] macro(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
    }

}