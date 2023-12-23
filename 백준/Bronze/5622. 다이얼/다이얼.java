import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Map<Character, Integer> number = new HashMap<>();
        number.put('A', 3); number.put('B', 3); number.put('C', 3);
        number.put('D', 4); number.put('E', 4); number.put('F', 4);
        number.put('G', 5); number.put('H', 5); number.put('I', 5);
        number.put('J', 6); number.put('K', 6); number.put('L', 6);
        number.put('M', 7); number.put('N', 7); number.put('O', 7);
        number.put('P', 8); number.put('Q', 8); number.put('R', 8); number.put('S', 8);
        number.put('T', 9); number.put('U', 9); number.put('V', 9);
        number.put('W', 10); number.put('X', 10); number.put('Y', 10); number.put('Z', 10);

        int ans = 0;
        for (int i = 0;i<s.length();i++){
            ans += number.get(s.charAt(i));
        }

        System.out.println(ans);

        }
    }