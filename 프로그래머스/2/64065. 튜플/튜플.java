import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        boolean[] isFind = new boolean[100001];
        String[] splitS = s.substring(2, s.length()-1).split("\\{");
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        answer = new int[splitS.length];
        
        for(int i = 0; i<splitS.length; i++) {
            String arrString = splitS[i];
            String[] arr = arrString.substring(0, i == splitS.length - 1 ? arrString.length() -1: arrString.length() - 2).split(",");
            ArrayList<Integer> list = new ArrayList<>();
            
            for(String num : arr) {
                list.add(Integer.parseInt(num));
            }
            
            map.put(arr.length, list);
        }
        
        for(int i = 1; i <= map.size(); i++) {
            for(int j : map.get(i)) {
                if(!isFind[j]) {
                    answer[i-1] = j;
                    isFind[j] = true;
                    break;
                }
            }
        }
        
        return answer;
    }
}