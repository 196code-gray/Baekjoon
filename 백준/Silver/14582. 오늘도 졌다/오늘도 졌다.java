import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String[] jmnis = sc.nextLine().split(" ");
		String[] start = sc.nextLine().split(" ");

		int score = 0;
		for (int i = 0; i < jmnis.length; i++) {
			score += Integer.parseInt(jmnis[i]);
			if (score > 0) {
				System.out.println("Yes");
				return;
			}
			score -= Integer.parseInt(start[i]);
		}
		System.out.println("No");
	}
}