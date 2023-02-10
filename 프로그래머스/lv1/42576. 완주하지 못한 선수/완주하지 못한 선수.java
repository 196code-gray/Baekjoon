import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList(participant));
        
        list1.sort(Comparator.naturalOrder());
        Arrays.sort(completion);
        // 완주자 길이로 없는 사람 찾기
        // 참가자 리스트에서 i에 맞는 완주자 위치 알아낸 뒤 삭제.
        for (String s : completion) {
            int index = list1.indexOf(s);
            list1.remove(index);
        }
        String result = String.valueOf(list1);
        String newresult = result
                .replace("[", "")
                .replace("]", "");
        return newresult;
    }
}