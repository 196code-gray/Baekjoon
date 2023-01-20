import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 좌석의 수
        int seat = scanner.nextInt();
        // 좌석의 정보
        String seatinfo = scanner.next();  // *S*LL*S*LL* LL이 2 이상이라면 1시람이 못씀
        // 사람의 수
        int person = 1;

        for (int i = 0; i < seat; i++) {
            char a = seatinfo.charAt(i);
            if (a == 'S') {
                person++;
            }
            else if (a == 'L') {
                i++;
                person++;
            }
        }
        if (person > seat) System.out.println(seat);
        else System.out.println(person);
    }
}