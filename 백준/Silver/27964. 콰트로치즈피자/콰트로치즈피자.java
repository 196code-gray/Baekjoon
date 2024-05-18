import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] toping = br.readLine().split(" ");

        Set<String> set =new HashSet<>();
        for (int i = 0; i < toping.length; i++) {
            if (toping[i].endsWith("Cheese")) set.add(toping[i]);
        }

        System.out.println(set.size() >= 4 ? "yummy" : "sad");
    }
}