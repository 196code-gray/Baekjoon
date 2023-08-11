import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();
            String[] arr = str.split("-");
            int count = 0;
            int[] sum = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                String[] num = arr[i].split("[+]");
                for (int j = 0; j < num.length; j++) {
                    sum[i] += Integer.parseInt(num[j]);
                }
            }
            for (int i = 0; i < sum.length; i++) {
                if (i == 0) count = sum[i];
                else count -= sum[i];
            }
            System.out.println(count);
        }
    }