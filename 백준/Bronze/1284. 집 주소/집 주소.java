import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 결과값 출력 , 양 끝에 이미 여백 2가 있기 때문에.
        // 입력 0 이 나올 때 까지 계속 받음
        while (true) {
            int result = 0;
            
            String area = sc.next();
            
            if (area.equals("0")) break;
            for (int i = 0; i < area.length(); i++) {
                String s = area.substring(i, i+1);
                
                if (s.equals("1")) result += 3;
                else if (s.equals("0")) result += 5;
                else result += 4;
            }
            System.out.println(result + 1);
        }
    }
}