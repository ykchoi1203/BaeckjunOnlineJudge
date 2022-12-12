import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(bf.readLine());

		int[][] arr = new int[num][num];
		for(int i=0; i<arr.length; i++) {
			int j = 0;
			for(char c : bf.readLine().toCharArray()) {
				arr[i][j] = c - '0';
				j++;
			}
		}
		compression(arr, 0, 0, num);
		System.out.println(sb);
	}

	public static void compression(int[][] arr, int x, int y, int size) {
		if(size == 1) {
			sb.append(arr[y][x]);
			return;
		}
		boolean isSame = true;
		int num = arr[y][x];

		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(num != arr[i][j]) {
					isSame = false;
					break;
				}
			}
			if(!isSame) break;
		}

		if(!isSame) {
			sb.append("(");
			for(int i=0; i<2;i++) {
				for(int j=0; j<2; j++) {
					compression(arr, x+j*size/2, y+i*size/2, size/2);
				}
			}
			sb.append(")");
		} else {
			sb.append(num);
		}
	}
}
