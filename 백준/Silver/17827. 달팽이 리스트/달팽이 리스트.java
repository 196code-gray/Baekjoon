import java.io.*;
import java.util.*;

public class Main {
	static int n,m,v;
	static int[] snailArray;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		snailArray = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			snailArray[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int k = reader.readInt();
			sb.append(getKthValue(k)+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
	private static int getKthValue(int k) {

		if(k < n) {
			return snailArray[k];
		}
		int snailLength = n-v+1; 
		k -= v-1; 
		return snailArray[k%snailLength + v-1];
	}
}
class InputReader {
	private BufferedReader br;

	public InputReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public InputReader(String filepath) {
		try {
			br = new BufferedReader(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Character> readLineIntoCharList() throws IOException {
		List<Character> l = new ArrayList<>();
		while(true) {
			int readVal = br.read();
			if(readVal == '\n' || readVal == -1) break;
			l.add((char)readVal);
		}
		return l;
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}