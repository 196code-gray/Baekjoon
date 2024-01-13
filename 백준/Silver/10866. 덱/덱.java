import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n= Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();
        while (n --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s= st.nextToken();
            if (s.equals("push_back") || s.equals("push_front")) {
                int m = Integer.parseInt(st.nextToken());
                if (s.equals("push_front")) d.offerFirst(m);
                else d.offerLast(m);
            } else {
                if (s.equals("pop_front")) sb.append((d.isEmpty())?-1:d.pollFirst()).append("\n");
                else if (s.equals("pop_back")) sb.append((d.isEmpty())?-1:d.pollLast()).append("\n");
                else if (s.equals("size")) sb.append(d.size()).append("\n");
                else if (s.equals("empty")) sb.append((d.isEmpty())? 1 : 0).append("\n");
                else if (s.equals("front")) sb.append((d.isEmpty())? -1 : d.peekFirst()).append("\n");
                else if (s.equals("back")) sb.append((d.isEmpty())? -1 : d.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}