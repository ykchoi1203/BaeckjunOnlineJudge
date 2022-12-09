import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][n];
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(-1, 0);
		map.put(0, 0);
		map.put(1, 0);
		for(int i=0; i<arr.length; i++) {
			arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(el -> Integer.parseInt(el)).toArray();
		}
		int cnt = 0;
		while(n > 1) {
			n /= 3;
			cnt++;
		}

		isSame(arr, map, 0, 0, cnt);
		for(int i=-1; i<2; i++) {
			System.out.println(map.get(i));
		}
	}
	public static void isSame(int[][] arr, HashMap<Integer, Integer> map, int i, int j, int size) {
		if(size == 0) {
			int k = arr[i][j];
			map.put(k, map.get(k) + 1);
			return;
		}
		boolean isSame = true;
		int num = arr[i][j];
		for(int k = i; k < i + Math.pow(3, size); k++) {
			for(int l = j; l < j + Math.pow(3, size); l++) {
				if(arr[k][l] != num) {
					isSame = false;
					break;
				}
			}
		}
		if(isSame) {
			map.put(num, map.get(num) + 1);
		} else {
			for(int k=i; k<i + Math.pow(3, size); k += Math.pow(3, size -1)) {
				for(int l=j; l<j + Math.pow(3, size); l += Math.pow(3, size -1)) {
					isSame(arr, map, k, l, size-1);
				}
			}
		}
	}
}