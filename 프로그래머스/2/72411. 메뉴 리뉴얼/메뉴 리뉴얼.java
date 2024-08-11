import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);

            for(int courseSize : course) {
                if(orderArray.length < courseSize) break;
                if(orderArray.length == courseSize) {
                    String menu = new String(orderArray);
                    if(!subMenu.add(menu)) {
                        if(!map.containsKey(menu)) {
                            map.put(menu, 1);
                        } 
                        map.put(menu, map.get(menu) + 1);
                        if(count[courseSize] < map.get(menu)) {
                            count[courseSize] = map.get(menu);
                        }
                    }
                    break;
                }
                addMenu(orderArray, courseSize, 0, "");
            }
        }
        
        TreeSet<String> set = new TreeSet<>();
        
        for(String key : map.keySet()) {
            if(map.get(key) == count[key.length()]) {
                set.add(key);
            }
        }
        
        answer = new String[set.size()];
        int idx = 0;
        for(String menu : set) {
            answer[idx++] = menu;
        }
        
        return answer;
    }
    
    Set<String> subMenu = new HashSet<>();
    TreeMap<String, Integer> map = new TreeMap<>();
    int[] count = new int[11];
    
    public void addMenu(char[] order, int course, int idx, String menu) {
        if(menu.length() == course) {
            if(!subMenu.add(menu)) {
                if(!map.containsKey(menu)) {
                    map.put(menu, 1);
                } 
                map.put(menu, map.get(menu) + 1);
                if(count[course] < map.get(menu)) {
                    count[course] = map.get(menu);
                }
            }
            return;
        }
        
        if(idx >= order.length) return;
        
        StringBuilder sb = new StringBuilder();
        sb.append(menu);
        sb.append(order[idx]);
        addMenu(order, course, idx + 1, sb.toString());
        addMenu(order, course, idx + 1, menu);
    }
}