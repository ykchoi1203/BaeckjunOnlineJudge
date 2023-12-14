import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> cloth = new HashMap<>();

		int answer = 1;
		
		if(clothes.length == 0) return 0;

		for(int i=0; i<clothes.length; i++) {
			if(cloth.containsKey(clothes[i][1])) {
				cloth.get(clothes[i][1]).add(clothes[i][0]);
			} else {
				cloth.put(clothes[i][1], new ArrayList<>());
				cloth.get(clothes[i][1]).add(clothes[i][0]);
			}
		}

		for(String list : cloth.keySet()) {
			answer *= (cloth.get(list).size() + 1);
		}
		
		return answer - 1;
    }
}