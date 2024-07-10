import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0]))
                map.put(ticket[0], new LinkedList<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        
        for(String key : map.keySet()) {
            map.get(key).sort(Comparator.naturalOrder());
        }
        
        stack.add("ICN");
        dfs("ICN", tickets.length, 0);
        
        String[] arr = new String[answer.size()];
        int idx = 0;
        while(!answer.isEmpty()) {
            arr[idx++] = answer.pollFirst(); 
        }
        
        return arr;
    }
    
    public TreeMap<String, LinkedList<String>> map = new TreeMap<>();
    public Stack<String> stack = new Stack<>();
    public Deque<String> answer = new LinkedList<>();
    
    public void dfs(String from, int total, int count) {
        if(total == count) {
            while(!stack.isEmpty()) {
                answer.addFirst(stack.pop());
            }
            return;
        }

        if(map.containsKey(from)) {
            for (int i = 0; i < map.get(from).size(); i++) {
                String to = map.get(from).remove(i);
                stack.push(to);
                dfs(to, total, count + 1);
                if(!stack.isEmpty())
                    stack.pop();
                map.get(from).add(i, to);
                if (!answer.isEmpty())
                    return;
            }
        }
    }
}