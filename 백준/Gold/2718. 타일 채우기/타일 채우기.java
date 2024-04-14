import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            long n = Long.parseLong(br.readLine());

            System.out.println(new int[]{1, 5, 11, 36, 95, 281,
                    781, 2245, 6336, 18061, 51205, 145601, 413351, 1174500, 3335651, 9475901,
                    26915305, 76455961, 217172736, 616891945, 1752296281}[(int) (n - 1)]);
        }
    }
}