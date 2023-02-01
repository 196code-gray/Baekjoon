import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // t입력 받고 s입력 받기
        int t = sc.nextInt();
        int s = sc.nextInt();
        // t의 숫자에 따라 조건문으로 아침, 점심 구분. s에 따라 밥알 구분. t의 숫자와 s의 숫가를 확인.
        if (t >= 12 && t <= 16) {
            if (s == 0) {
                System.out.println(320);
            }
            else System.out.println(280);
        }
        else System.out.println(280);
    }
}