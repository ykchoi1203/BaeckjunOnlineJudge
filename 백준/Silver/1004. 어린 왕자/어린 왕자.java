import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int[] answer = new int[num];
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] arr = new int[4];
			for(int j=0; j<4; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int num2 = Integer.parseInt(bf.readLine());
			for(int j=0; j<num2; j++) {
				int[] arr2 = new int[3];
				st = new StringTokenizer(bf.readLine());
				for(int k=0; k<3; k++) {
					arr2[k] = Integer.parseInt(st.nextToken());
				}
				if(Math.pow((arr[0]-arr2[0]), 2) + Math.pow((arr[1]-arr2[1]), 2) < Math.pow(arr2[2], 2) &&
						Math.pow((arr[2]-arr2[0]), 2) + Math.pow((arr[3]-arr2[1]), 2) > Math.pow(arr2[2], 2)) {
					answer[i]++;
				} else if(Math.pow((arr[0]-arr2[0]), 2) + Math.pow((arr[1]-arr2[1]), 2) > Math.pow(arr2[2], 2) &&
						Math.pow((arr[2]-arr2[0]), 2) + Math.pow((arr[3]-arr2[1]), 2) < Math.pow(arr2[2], 2)) {
					answer[i]++;
				}
			}
		}
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
