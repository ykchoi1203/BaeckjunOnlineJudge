import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int min = 11;
	static ArrayList<int[]> arrayList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(sb.readLine());
		char[][] arr = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		int[] RIdx = new int[2];
		int[] BIdx = new int[2];
		for(int i=0; i<arr.length; i++) {
			String s = sb.readLine();
			for(int j=0; j<s.length(); j++) {
				arr[i][j] = s.charAt(j);
				if(s.charAt(j) == 'R') {
					RIdx[0] = i;
					RIdx[1] = j;
				} else if(s.charAt(j)=='B') {
					BIdx[0] = i;
					BIdx[1] = j;
				}
			}
		}
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		visited[RIdx[0]][RIdx[1]] = true;
		go(arr, RIdx, BIdx, 0);
		System.out.println(min == 11 ? -1 : min);
	}

	public static void go(char[][] arr, int[] RIdx, int[] BIdx, int cnt) {

		int rY = RIdx[0];
		int rX = RIdx[1];
		int bY = BIdx[0];
		int bX = BIdx[1];
		arrayList.add(new int[] {rX, rY, bX, bY});
		if(arrayList.size() > 2) {
			int[] arr1 = arrayList.get(arrayList.size()-1);
			int[] arr2 = arrayList.get(arrayList.size()-3);
			boolean isTrue = false;
			for(int j=0; j<4; j++) {
				if(arr1[j] != arr2[j]) {
					isTrue = true;
					break;
				}
			}
			if(!isTrue){
				arrayList.remove(arrayList.size()-1);
				return;
			}
		}
		cnt++;
		if(cnt > 10) {
			arrayList.remove(arrayList.size()-1);
			return;
		}
		boolean isCorrectDrop = false;
		boolean isDrop = false;
		int k = 0;
		int j = 0;
		if(rX > bX) {
			while (arr[BIdx[0]][BIdx[1] - 1] == 'O' || arr[BIdx[0]][BIdx[1] - 1] == '.' || arr[BIdx[0]][BIdx[1] - 1] == 'R' || arr[BIdx[0]][BIdx[1] - 1] == 'B') {
				BIdx[1] -= 1;
				if (arr[BIdx[0]][BIdx[1]] == 'O') {
					isDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) k++;
			}
			if (k > 0) BIdx[1]++;
			while ((arr[RIdx[0]][RIdx[1] - 1] == 'O' || arr[RIdx[0]][RIdx[1] - 1] == '.' || arr[RIdx[0]][RIdx[1] - 1] == 'B' || arr[RIdx[0]][RIdx[1] - 1] == 'R')) {
				RIdx[1] -= 1;
				if (arr[RIdx[0]][RIdx[1]] == 'O') {
					isCorrectDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) {
					j++;
				}
			}
			if (j > 0) RIdx[1]++;
		} else {
			while ((arr[RIdx[0]][RIdx[1] - 1] == 'O' || arr[RIdx[0]][RIdx[1] - 1] == '.' || arr[RIdx[0]][RIdx[1] - 1] == 'B' || arr[RIdx[0]][RIdx[1] - 1] == 'R')) {
				RIdx[1] -= 1;
				if (arr[RIdx[0]][RIdx[1]] == 'O') {
					isCorrectDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) {
					j++;
				}
			}
			if (j > 0) RIdx[1]++;
			while (arr[BIdx[0]][BIdx[1] - 1] == 'O' || arr[BIdx[0]][BIdx[1] - 1] == '.' || arr[BIdx[0]][BIdx[1] - 1] == 'R' || arr[BIdx[0]][BIdx[1] - 1] == 'B') {
				BIdx[1] -= 1;
				if (arr[BIdx[0]][BIdx[1]] == 'O') {
					isDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) k++;
			}
			if (k > 0) BIdx[1]++;
		}
		if(isCorrectDrop && !isDrop) {
			if(cnt < min) min = cnt;
			arrayList.remove(arrayList.size()-1);
			return;
		}
		if(!isDrop && (RIdx[0] != rY || RIdx[1] != rX || BIdx[0] != bY || BIdx[1] != bX)) go(arr, RIdx, BIdx, cnt);
		isCorrectDrop = false;
		isDrop = false;
		RIdx[0] = rY;
		RIdx[1] = rX;
		BIdx[0] = bY;
		BIdx[1] = bX;
		k=0;
		j=0;
		if(rX < bX) {
			while (arr[BIdx[0]][BIdx[1] + 1] == 'O' || arr[BIdx[0]][BIdx[1] + 1] == '.' || arr[BIdx[0]][BIdx[1] + 1] == 'R' || arr[BIdx[0]][BIdx[1] + 1] == 'B') {
				BIdx[1] += 1;
				if (arr[BIdx[0]][BIdx[1]] == 'O') {
					isDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) k++;
			}
			if (k > 0) BIdx[1]--;
			while ((arr[RIdx[0]][RIdx[1] + 1] == 'O' || arr[RIdx[0]][RIdx[1] + 1] == '.' || arr[RIdx[0]][RIdx[1] + 1] == 'B' || arr[RIdx[0]][RIdx[1] + 1] == 'R')) {
				RIdx[1] += 1;
				if (arr[RIdx[0]][RIdx[1]] == 'O') {
					isCorrectDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) {
					j++;
				}
			}
			if (j > 0) RIdx[1]--;
		} else {
			while ((arr[RIdx[0]][RIdx[1] + 1] == 'O' || arr[RIdx[0]][RIdx[1] + 1] == '.' || arr[RIdx[0]][RIdx[1] + 1] == 'B' || arr[RIdx[0]][RIdx[1] + 1] == 'R')) {
				RIdx[1] += 1;
				if (arr[RIdx[0]][RIdx[1]] == 'O') {
					isCorrectDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) {
					j++;
				}
			}
			if (j > 0) RIdx[1]--;
			while (arr[BIdx[0]][BIdx[1] + 1] == 'O' || arr[BIdx[0]][BIdx[1] + 1] == '.' || arr[BIdx[0]][BIdx[1] + 1] == 'R' || arr[BIdx[0]][BIdx[1] + 1] == 'B') {
				BIdx[1] += 1;
				if (arr[BIdx[0]][BIdx[1]] == 'O') {
					isDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) k++;
			}
			if (k > 0) BIdx[1]--;
		}
		if(isCorrectDrop && !isDrop) {
			if(cnt < min) min = cnt;
			arrayList.remove(arrayList.size()-1);
			return;
		}

		if(!isDrop && (RIdx[0] != rY || RIdx[1] != rX || BIdx[0] != bY || BIdx[1] != bX)) go(arr, RIdx, BIdx, cnt);
		isCorrectDrop = false;
		isDrop = false;
		RIdx[0] = rY;
		RIdx[1] = rX;
		BIdx[0] = bY;
		BIdx[1] = bX;
		j=0;
		k=0;
		if(rY > bY) {
			while (arr[BIdx[0] - 1][BIdx[1]] == 'O' || arr[BIdx[0] - 1][BIdx[1]] == '.' || arr[BIdx[0] - 1][BIdx[1]] == 'R' || arr[BIdx[0] - 1][BIdx[1]] == 'B') {
				BIdx[0] -= 1;
				if (arr[BIdx[0]][BIdx[1]] == 'O') {
					isDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) k++;
			}
			if (k > 0) BIdx[0]++;
			while ((arr[RIdx[0] - 1][RIdx[1]] == 'O' || arr[RIdx[0] - 1][RIdx[1]] == '.' || arr[RIdx[0] - 1][RIdx[1]] == 'B' || arr[RIdx[0] - 1][RIdx[1]] == 'R')) {
				RIdx[0] -= 1;
				if (arr[RIdx[0]][RIdx[1]] == 'O') {
					isCorrectDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) {
					j++;
				}
			}
			if (j > 0) RIdx[0]++;
		} else {
			while ((arr[RIdx[0] - 1][RIdx[1]] == 'O' || arr[RIdx[0] - 1][RIdx[1]] == '.' || arr[RIdx[0] - 1][RIdx[1]] == 'B' || arr[RIdx[0] - 1][RIdx[1]] == 'R')) {
				RIdx[0] -= 1;
				if (arr[RIdx[0]][RIdx[1]] == 'O') {
					isCorrectDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) {
					j++;
				}
			}
			if (j > 0) RIdx[0]++;
			while (arr[BIdx[0] - 1][BIdx[1]] == 'O' || arr[BIdx[0] - 1][BIdx[1]] == '.' || arr[BIdx[0] - 1][BIdx[1]] == 'R' || arr[BIdx[0] - 1][BIdx[1]] == 'B') {
				BIdx[0] -= 1;
				if (arr[BIdx[0]][BIdx[1]] == 'O') {
					isDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) k++;
			}
			if (k > 0) BIdx[0]++;
		}
		if(isCorrectDrop && !isDrop) {
			if(cnt < min) min = cnt;
			arrayList.remove(arrayList.size()-1);
			return;
		}

		if(!isDrop && (RIdx[0] != rY || RIdx[1] != rX || BIdx[0] != bY || BIdx[1] != bX)) go(arr, RIdx, BIdx, cnt);
		isCorrectDrop = false;
		isDrop = false;
		RIdx[0] = rY;
		RIdx[1] = rX;
		BIdx[0] = bY;
		BIdx[1] = bX;
		j=0;
		k=0;
		if(rY < bY) {
			while (arr[BIdx[0] + 1][BIdx[1]] == 'O' || arr[BIdx[0] + 1][BIdx[1]] == '.' || arr[BIdx[0] + 1][BIdx[1]] == 'R' || arr[BIdx[0] + 1][BIdx[1]] == 'B') {
				BIdx[0] += 1;
				if (arr[BIdx[0]][BIdx[1]] == 'O') {
					isDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) k++;
			}
			if (k > 0) BIdx[0]--;

			while ((arr[RIdx[0] + 1][RIdx[1]] == 'O' || arr[RIdx[0] + 1][RIdx[1]] == '.' || arr[RIdx[0] + 1][RIdx[1]] == 'B' || arr[RIdx[0] + 1][RIdx[1]] == 'R')) {
				RIdx[0] += 1;
				if (arr[RIdx[0]][RIdx[1]] == 'O') {
					isCorrectDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) {
					j++;
				}
			}
			if (j > 0) RIdx[0]--;
		} else {
			while ((arr[RIdx[0] + 1][RIdx[1]] == 'O' || arr[RIdx[0] + 1][RIdx[1]] == '.' || arr[RIdx[0] + 1][RIdx[1]] == 'B' || arr[RIdx[0] + 1][RIdx[1]] == 'R')) {
				RIdx[0] += 1;
				if (arr[RIdx[0]][RIdx[1]] == 'O') {
					isCorrectDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) {
					j++;
				}
			}
			if (j > 0) RIdx[0]--;
			while (arr[BIdx[0] + 1][BIdx[1]] == 'O' || arr[BIdx[0] + 1][BIdx[1]] == '.' || arr[BIdx[0] + 1][BIdx[1]] == 'R' || arr[BIdx[0] + 1][BIdx[1]] == 'B') {
				BIdx[0] += 1;
				if (arr[BIdx[0]][BIdx[1]] == 'O') {
					isDrop = true;
				} else if (BIdx[0] == RIdx[0] && BIdx[1] == RIdx[1]) k++;
			}
			if (k > 0) BIdx[0]--;
		}
		if(isCorrectDrop && !isDrop) {
			if(cnt < min) min = cnt;
			arrayList.remove(arrayList.size()-1);
			return;
		}

		if(!isDrop && (RIdx[0] != rY || RIdx[1] != rX || BIdx[0] != bY || BIdx[1] != bX)) go(arr, RIdx, BIdx, cnt);
		arrayList.remove(arrayList.size()-1);
	}
}
