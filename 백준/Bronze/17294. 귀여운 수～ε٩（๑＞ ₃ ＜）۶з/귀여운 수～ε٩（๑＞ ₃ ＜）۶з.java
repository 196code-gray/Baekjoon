import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String k = sc.next();
        sc.close();
        System.out.println(a(k));
    }

    private static String a (String k) {
        final String good = "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!";
        final String bad =  "흥칫뿡!! <(￣ ﹌ ￣)>";
        if (k.length() == 1) {
            return good;
        }else {
            char[] chArr = k.toCharArray();
            int diff = chArr[0] - chArr[1];
            for (int i = 1; i < chArr.length-1; i++) {
                if (chArr[i] - chArr[i+1] != diff) {
                    return bad;
                }
            }
            return good;
        }
    }
}