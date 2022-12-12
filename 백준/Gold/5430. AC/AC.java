import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caseNum = Integer.parseInt(bf.readLine());

		for(int i=0; i<caseNum; i++) {
			Deque<Integer> deque = new ArrayDeque<>();
			String s = bf.readLine();
			String size = bf.readLine();
			int idx = Integer.parseInt(size);
			String number = bf.readLine();
			StringTokenizer st = new StringTokenizer(number, "[,]");

			boolean reverse = true;
			boolean isError = false;

			for(int j=0; j<idx; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'R') {
					reverse = !reverse;
				} else {
					if (reverse) {
						if(deque.pollFirst() == null) {
							isError = true;
						}
					} else {
						if(deque.pollLast() == null) {
							isError = true;
						}
					}
				}
			}
			if (!isError) {
				sb.append("[");
                if(deque.size() > 0) {
                    if (reverse) {
                        sb.append(deque.pollFirst());
                        while(!deque.isEmpty()) {
                            sb.append(",");
                            sb.append(deque.pollFirst());
                        }
                    } else {
                        sb.append(deque.pollLast());
                        while(!deque.isEmpty()) {
                            sb.append(",");
                            sb.append(deque.pollLast());
                        }
                    }
                }
				sb.append("]\n");
			} else {
				sb.append("error\n");
			}
		}
		System.out.print(sb);
	}
}
