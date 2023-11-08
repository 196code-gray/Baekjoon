import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static String solution(String input_string) {
        String answer = "";
        Map<Character, Boolean> map = new HashMap<>();
        Set<Character> set = new TreeSet<>();

        char[] c = input_string.toCharArray();
        char ch = ' ';
        for (char temp : c) {
            if (temp != ch) {
                if (map.containsKey(temp)) {
                    set.add(temp);
                }
                map.put(temp, true);
                ch = temp;
            }
        }

        for (char temp : set) {
            answer += temp;
        }

        return (answer.isEmpty()) ? "N" : answer;
    }