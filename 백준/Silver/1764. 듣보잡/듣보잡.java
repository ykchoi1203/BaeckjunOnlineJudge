import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
//		TreeMap<String, Integer> map = new TreeMap<>();
		TreeSet<String> set = new TreeSet<>();
		TreeSet<String> set1 = new TreeSet<>();
		int listenName = Integer.parseInt(st.nextToken());
		int seeName = Integer.parseInt(st.nextToken());

		for(int i=0; i<listenName; i++) {
//			map.put(bf.readLine(), 0);
			set1.add(bf.readLine());
		}

		for(int i=0; i<seeName; i++) {
			set.add(bf.readLine());
		}
        int cnt = 0;
		if(set1.size() > set.size()) {
			for(String name : set) {
				if(set1.contains(name)) {
                    cnt++;
					sb.append(name).append("\n");
				}
			}
		} else {
			for(String name : set1) {
				if(set.contains(name)) {
                    cnt++;
					sb.append(name).append("\n");
				}
			}
		}
        System.out.println(cnt);
        System.out.println(sb);

//		for(Map.Entry<String, Integer> entry : map.entrySet()) {
//			if(entry.getValue() == 1) {
//				System.out.println(entry.getKey());
//			}
//		}
	}
}
