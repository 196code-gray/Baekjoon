import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n입력
        int n = sc.nextInt();
        // t의 숫자에 따라 조건문으로 아침, 점심 구분. s에 따라 밥알 구분. t의 숫자와 s의 숫가를 확인.
        if (n % 2 == 0) {
            System.out.println("SK");
        }
        else System.out.println("CY");
    }
}
