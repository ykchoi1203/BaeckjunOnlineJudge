import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};

        int size = Arrays.stream(gems).collect(Collectors.toSet()).size();
        
        if(size == gems.length) return new int[] {1, size};

        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        for(int i=0; i<gems.length; i++) {
            if(!map.containsKey(gems[i])) {
                map.put(gems[i], 0);
            }
            map.put(gems[i], map.get(gems[i]) + 1);

            if(map.size() == size) {
                while(map.get(gems[start]) != 1) {
                    map.put(gems[start], map.get(gems[start++]) - 1);
                }

                if(i - start < answer[1] - answer[0]) {
                    answer = new int[] {start + 1, i + 1};
                }

                if(i - start + 1 == size) return answer;

                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
        }

        return answer;
    }
}