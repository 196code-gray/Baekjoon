import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int index = s.length() -1;
        for (int i = 0; i <= index; i++){
            if (s.charAt(i) == s.charAt(index)) {
                index--;
            }
            else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}