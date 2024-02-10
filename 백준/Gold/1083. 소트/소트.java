import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String[] numLine = bufferedReader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = n-1; i >= 0; i--){
            nums[i] = Integer.parseInt(numLine[i]);
        }

        int s = Integer.parseInt(bufferedReader.readLine());

        //sort
        int maxIndex, temp, count;

        for (int i = 0; i < n; i++) {
            maxIndex = i;
            count = 0;
            for (int j = i; j < n; j++) {
                if (count > s) {
                    break;
                }
                if (nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
                count++;
            }
            for (int j = maxIndex; j > i; j--) {
                if (s == 0) {
                    break;
                }
                temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                s--;
            }
        }

        //print
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(nums[i]).append(" ");
        }
        System.out.print(stringBuffer.toString());
    }
}