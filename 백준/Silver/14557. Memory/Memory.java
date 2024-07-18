import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] re = br.readLine().split(" ");
        int a = Integer.parseInt(re[0]);
        int b = Integer.parseInt(re[1]);

        int result1 = a * b / 2;
        int result2 = a * b - 1;

        System.out.println(result1 + " " + result2);
    }
}
