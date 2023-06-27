import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        // word 를 입력받기
        String word = sc.next();
        // string 을 char[] 로 변환하기
        char[] chars = word.toCharArray();
        // long 변수 선언
        long sum = 0;
        // for (char[] 길이만큼 반복)
        for (int i = 0; i < chars.length; i++) {
            sum += chars[i] - '0';
        }
        System.out.println(sum);
    }
}