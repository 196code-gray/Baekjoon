import java.io.*;
import java.util.*;

class Data implements Comparable<Data> {
    int num;
    int index;

    public Data(int num, int index) {
        super();
        this.num = num;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) {
        return this.num - o.num;
    }
}
    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            Data[] arr = new Data[n];

            for (int i = 0; i < n; i++) {
                arr[i] = new Data(Integer.parseInt(br.readLine()), i);
            }
            Arrays.sort(arr);
            int max = 0;

            for (int i = 0; i < n; i++) {
                if (max < arr[i].index - i) {
                    max = arr[i].index - i;
                }
            }
            System.out.println(max + 1);
        }
    }