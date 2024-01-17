import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static boolean[] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] first = new int[] {2,3,5,7};
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);

		for(int i=1; i < N; i++) {
			ArrayList<Integer> addList = new ArrayList<>();
			for(int j=0; j<list.size(); j++) {
				for(int k=1; k<10; k+=2) {
					int num = list.get(j) * 10 + k;
					if(prime(num)) {
						addList.add(num);
					}
				}
			}
			list = addList;
		}

		for(int i : list) {
			System.out.println(i);
		}



	}

	public static boolean prime(int n) {
		if(n == 2) return true;
		for(int i=3; i<=Math.sqrt(n); i+=2) {
			if(n % i == 0) return false;
 		}

		return true;
	}
}
