import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] second = new int[3];
        second[0] = Integer.parseInt(st.nextToken()); second[1] = Integer.parseInt(st.nextToken());
        second[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(second);
        System.out.println(second[1]);
 }}