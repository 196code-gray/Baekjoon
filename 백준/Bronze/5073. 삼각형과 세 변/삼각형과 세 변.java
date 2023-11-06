import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int max = Math.max(Math.max(one, two), three);
            if (one == 0 && two == 0 && three == 0) break;
            if (one == two && two == three) System.out.println("Equilateral");
            else if (one == two || one == three || two == three) {
                if (max >= ((one + two + three) - max)) System.out.println("Invalid");
                else System.out.println("Isosceles");
            }
            else if (one != two && two != three && one != three) {
                if (max >= ((one + two + three) - max)) System.out.println("Invalid");
                else System.out.println("Scalene");
            }
        }
    }
}