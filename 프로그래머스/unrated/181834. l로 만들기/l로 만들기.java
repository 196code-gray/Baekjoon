import java.util.*;
class Solution {
    public String solution(String myString) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<myString.length();i++){
            if (myString.charAt(i) - 108 < 0) sb.append("l");
            else sb.append(myString.charAt(i));
        }
        return sb.toString();
    }
}