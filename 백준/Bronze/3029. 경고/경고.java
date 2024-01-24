import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(":");
        String[] wait = br.readLine().split(":");
        int[] ans = new int[3];
        if (Arrays.equals(time, wait)) {
            System.out.println("24:00:00");
            return;
        }
        ans[0] = (Integer.parseInt(wait[0]) - Integer.parseInt(time[0]));
        ans[1] = (Integer.parseInt(wait[1]) - Integer.parseInt(time[1]));
        ans[2] = (Integer.parseInt(wait[2]) - Integer.parseInt(time[2]));

        if (ans[2] < 0){
            ans[2] += 60;
            ans[1] --;
        }
        if (ans[1] < 0){
            ans[1] += 60;
            ans[0]--;
        }
        if (ans[0] < 0) ans[0] += 24;
        System.out.printf("%02d:%02d:%02d" ,ans[0],ans[1],ans[2]);
    }
}
