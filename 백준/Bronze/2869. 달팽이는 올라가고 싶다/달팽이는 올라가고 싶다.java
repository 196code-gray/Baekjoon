import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int afternoon = sc.nextInt();
        int nigth = sc.nextInt();
        int high = sc.nextInt();

        // 하루에 올라 갈 수 있는 양 high - afternoon
        // 결과 값에서 + nigth

        int day = 0;

        day = (high - afternoon) / (afternoon - nigth) + 1;

        if ((high - afternoon) % (afternoon - nigth) != 0) day++;
        System.out.println(day);
    }
}
