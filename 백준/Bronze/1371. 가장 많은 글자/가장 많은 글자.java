import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        String str = "";
        String input;
        String many = ""; // 결과값 출력

        while ((input = br.readLine()) != null) {  // 입력값이 빈값이 아닐때.
            str += input;
        }
        int max = 0; // 많은 문자열

        for (char i = 97; i < 123; i++) {
            int count = str.length() - str.replace(String.valueOf(i), "").length(); // 입력 받은 전체 길이에서 i번에 해당하는 아스키코드 (문자열) 제거된 길이 빼줌. 그럼 count에 i에 해당하는 문자열의 갯수를 알 수 있을 것.

            if (max == count) {
                many += String.valueOf(i);
            }
            if (max < count) {
                max = count;
                many = String.valueOf(i);
            }
        }
        System.out.println(many);
    }
}