import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken()); long m = Long.parseLong(st.nextToken());
        if (n % (m + 1) == 1) System.out.println("Can't win");
        else System.out.println("Can win");
        }
    }