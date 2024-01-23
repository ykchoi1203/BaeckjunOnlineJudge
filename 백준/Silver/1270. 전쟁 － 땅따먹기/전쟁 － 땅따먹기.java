import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();


		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			long[] arr = new long[num];
			for(int j=0; j<num; j++) {
				arr[j]=sc.nextLong();
			}
			sb.append(answer(arr));
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	public static String answer(long[] arr) {
		HashMap<Long, Integer> map = new HashMap<>();
		int n = arr.length/2 + 1;
		int max = 0;
		long number = -1;

		for(int i=0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 0);
			}
			map.put(arr[i], map.get(arr[i]) + 1);
			if(max < map.get(arr[i])) {
				max = map.get(arr[i]);
				number = arr[i];
			}
		}

		if(max < n) return "SYJKGW";
		else return Long.toString(number);
	}

}
