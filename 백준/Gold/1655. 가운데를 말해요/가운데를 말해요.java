import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<caseNum; i++) {
			int num = Integer.parseInt(bf.readLine());
			if(minHeap.size() == maxHeap.size()) {
				maxHeap.offer(num);
			} else {
				minHeap.offer(num);
			}
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(maxHeap.peek() > minHeap.peek()) {
					int temp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(temp);
				}
			}
			sb.append(maxHeap.peek()).append("\n");
		}

		System.out.println(sb);
	}
}
