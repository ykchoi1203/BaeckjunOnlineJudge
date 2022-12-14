import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(stringTokenizer.nextToken());
		int count = Integer.parseInt(stringTokenizer.nextToken());
		int k = 0;
		for(int i=1; i<count; i++) {
			k += i;
		}
		while(count <= 100) {
			if(num >= k && (num - k) % count == 0) {
				for(int i=0; i<count; i++) {
					System.out.print((num-k)/count + i + " ");
				}
				break;
			}
			k += count;
			count++;
		}
		if(count > 100) System.out.print("-1");
	}
}