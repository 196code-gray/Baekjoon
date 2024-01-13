class Solution {
    public static int solution(int[] money) {
        int[] start = new int[money.length], end = new int[money.length];
        start[0] = end[0] = 0;
        for (int i = 1; i < money.length; i++) start[i] = money[i -1];
        for (int i = 1; i <= money.length-1; i++) end[i] = money[i];

        for (int i= 2; i < money.length; i++){
            start[i] = Math.max(start[i] + start[i - 2], start[i - 1]);
            end[i] = Math.max(end[i] + end[i - 2], end[i - 1]);
        }

        return (start[money.length -1] > end[money.length -1]) ? start[money.length -1] : end[money.length -1];
    }
}