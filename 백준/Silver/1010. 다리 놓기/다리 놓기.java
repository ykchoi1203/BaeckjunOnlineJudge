import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(bf.readLine());
		long[] arr = new long[caseNum];
		for(int i=0; i<caseNum; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int leftPoint = Integer.parseInt(st.nextToken());
			int rightPoint = Integer.parseInt(st.nextToken());
			int max = Math.max(leftPoint, rightPoint);
			int min = Math.min(leftPoint, rightPoint);
			long answer = 1;
			int cnt = min;
			while(cnt > 0) {
				answer = answer * max / (min-cnt+1);
				max--;
				cnt--;
			}

			arr[i] = answer;
		}
		for(long i : arr) {
			System.out.println(i);
		}
	}
}