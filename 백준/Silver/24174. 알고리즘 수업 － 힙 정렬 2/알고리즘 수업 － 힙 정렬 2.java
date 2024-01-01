import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int count = 0;
	static int K = 0;
	static boolean isFinish = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] n = br.readLine().split(" ");

		int num = Integer.parseInt(n[0]);
		K = Integer.parseInt(n[1]);
		int cnt = 0;
		int temp;
		int[] arr = new int[num + 1];

		n = br.readLine().split(" ");
		for(int i=1; i<=num; i++) {
			arr[i] =  Integer.parseInt(n[i-1]);
		}

		heapSort(arr);
        
        if(count < K) {
            System.out.println("-1");
        }

		br.close();

	}

	public static void heapSort(int[] arr) {
		int n = arr.length -1;
		minHeap(arr, n);
		for(int i = n; i >= 2; i--) {
			changeArr(arr, 1, i);
			heapify(arr, 1, i-1);
		}

	}

	public static void minHeap(int[] arr, int n) {
		for(int i=n/2; i>=1; i--) {
			heapify(arr, i, n);
		}
	}

	public static void heapify(int[] arr, int k, int n) {
		int left = 2 * k;
		int right = 2 * k + 1;
		int min;

		if(right <= n) {
			if(arr[left] < arr[right]) {
				min = left;
			} else {
				min = right;
			}
		} else if (left <= n) {
			min = left;
		} else return;

		if(arr[min] < arr[k]) {
			changeArr(arr, min, k);
			heapify(arr, min, n);
		}

	}

	public static void changeArr(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
		count++;

		if(count == K) {
			StringBuilder sb = new StringBuilder();
			for(int i=1; i<arr.length; i++) {
				sb.append(arr[i]);
				sb.append(" ");
			}

			System.out.println(sb.toString().trim());
			System.exit(0);
		} 
        
	}
}
