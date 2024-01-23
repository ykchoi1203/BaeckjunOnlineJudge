import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();


		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			long[] arr = new long[num];
			int idx = 0;
			while(st.hasMoreElements()) {
				arr[idx] = Long.parseLong(st.nextToken());
                idx++;
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
