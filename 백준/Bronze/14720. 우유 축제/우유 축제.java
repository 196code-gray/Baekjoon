import java.util.*;
// Greedy = 최대한 이득을 볼 수 있는 방법을 생각.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 우유 가게 수
        int shop = scanner.nextInt();
        // 우유 가게 정보
        int[] shopInfo = new int[shop];
        for (int i = 0; i < shop; i++) {
            shopInfo[i] = scanner.nextInt(); // 1 2 0 2 1 2 = 3
        }

        // 마실 수 있는 우유 변수
        int drink = 0;
        int a = -1;
        //
        for (int i = 0; i < shopInfo.length; i++) {
            if (shopInfo[i] == (a +1)%3) {
                a++;
                drink++;
            }
        }
        System.out.println(drink);
    }
}