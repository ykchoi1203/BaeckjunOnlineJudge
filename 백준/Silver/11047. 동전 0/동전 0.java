import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int cnt = 0;
		int money = Integer.parseInt(s[1]);
		int[] coins = new int[Integer.parseInt(s[0])];

		for(int i=0; i<coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for(int i=coins.length-1; i>=0; i--) {
			if(coins[i] <= money) {
				cnt += money / coins[i];
				money -= coins[i] * (money / coins[i]);
			}
		}

		System.out.println(cnt);
	}
}
