import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int weight = 0;

		for(int i : tangerine) {
			if(!map.containsKey(i)) {
				map.put(i, 0);
			}
			map.put(i, map.get(i) + 1);
		}

		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

		for(Map.Entry<Integer, Integer> entry : entryList) {
			answer++;
			weight += entry.getValue();
			if(weight >= k) {
				return answer;
			}
		}


		return answer;
    }
}