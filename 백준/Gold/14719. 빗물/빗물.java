import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[][] arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		st = new StringTokenizer(bf.readLine());
		int i=0;
		while (st.hasMoreElements()) {
			int k = Integer.parseInt(st.nextToken());
			for(int j=arr.length-1; j>=arr.length-k; j--) {
				arr[j][i] = 1;
			}
			i++;
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int j=arr.length-1; j>=0; j--) {
			ArrayList<Integer> al = new ArrayList<>();
			for(int k=0; k<arr[j].length; k++) {
				if(arr[j][k] == 1) {
					al.add(k);
				}
			}
			map.put(j, al);
		}
		int cnt = 0;
		for(int key : map.keySet()) {
			ArrayList<Integer> al = map.get(key);
			if(al.size()> 1) {
				for(int j=0; j<al.size()-1; j++) {
					cnt += al.get(j+1) - al.get(j) - 1;
				}
			}
		}
		System.out.println(cnt);
	}
}
