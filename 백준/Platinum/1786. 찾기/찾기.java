import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String string = br.readLine();
		String pattern = br.readLine();

		KMP(string, pattern);
	}

	public static void KMP(String string, String pattern) {
		int[] table = makeTable(pattern);

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int cnt = 0;
		for(int i=0; i<string.length(); i++) {
			while(idx > 0 && string.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx -1];
			}
			if(pattern.charAt(idx) == string.charAt(i)) {
				if(idx == table.length-1) {
					cnt++;
					sb.append((i- idx + 1) + " ");
					idx = table[idx];
				} else {
					idx++;
				}
			}
		}

		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	public static int[] makeTable(String pattern) {
		int[] table = new int[pattern.length()];
		int idx = 0;
		for(int i=1; i<pattern.length(); i++) {
			while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx -1];
			}
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				table[i] = ++idx;
			}
		}

		return table;
	}
}
