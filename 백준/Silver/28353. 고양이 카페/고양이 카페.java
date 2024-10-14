import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cat = scanner.nextInt();
        int maxWeight = scanner.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i<cat; i++) {
            arrayList.add(scanner.nextInt());
        }

        Collections.sort(arrayList);

        int answer = 0;

        int min = arrayList.get(0);
        int max = arrayList.get(arrayList.size()-1);

        int minIndex = 0;
        int maxIndex = arrayList.size()-1;

        while(minIndex < maxIndex) {
            int temp = min+max;

            if(temp > maxWeight) {
                max = arrayList.get(maxIndex--);
            }

            else {
                answer++;
                min = arrayList.get(minIndex++);
                max = arrayList.get(maxIndex--);
            }
        }

        System.out.println(answer);
    }
}