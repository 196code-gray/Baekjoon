import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
                if (s.equals("pop_front")) System.out.println((d.isEmpty())?-1:d.pollFirst());
                else if (s.equals("pop_back")) System.out.println((d.isEmpty())?-1:d.pollLast());
                else if (s.equals("size")) System.out.println(d.size());
                else if (s.equals("empty")) System.out.println((d.isEmpty())? 1 : 0);
                else if (s.equals("front")) System.out.println((d.isEmpty())? -1 : d.peekFirst());
                else if (s.equals("back")) System.out.println((d.isEmpty())? -1 : d.peekLast());
            }
        }
    }
}
