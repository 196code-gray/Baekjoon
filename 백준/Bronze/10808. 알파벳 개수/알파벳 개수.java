import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] abe = new int[26];
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++){
            abe[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < abe.length; i++){
            System.out.print(abe[i] + " ");
        }
    }
}