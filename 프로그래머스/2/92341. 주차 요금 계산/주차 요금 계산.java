import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> cars = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();
        
        for(String record : records) {
            String[] split = record.split(" ");
            
            if(split[2].equals("IN")) {
                cars.put(split[1], split[0]);
            } else {
                String[] startTime = cars.get(split[1]).split(":");
                String[] endTime = split[0].split(":");
                
                int startHour = Integer.parseInt(startTime[0]);
                int startMin = Integer.parseInt(startTime[1]);
                int endHour = Integer.parseInt(endTime[0]);
                int endMin = Integer.parseInt(endTime[1]);
                
                int minute = endMin > startMin ? endMin - startMin : 60 + endMin - startMin;
                int hour = endMin >= minute ? endHour - startHour : endHour - startHour - 1;
                
                int minutes = hour * 60 + minute;
                
                if(!result.containsKey(split[1])) {
                    result.put(split[1], 0);
                }
                result.put(split[1], result.get(split[1]) + minutes);
                cars.remove(split[1]);
            }
        }
        
        if(!cars.isEmpty()) {
            for(String key : cars.keySet()) {
                String[] startTime = cars.get(key).split(":");

                int startHour = Integer.parseInt(startTime[0]);
                int startMin = Integer.parseInt(startTime[1]);
                int endHour = 23;
                int endMin = 59;

                int minute = endMin - startMin;
                int hour = endHour - startHour;

                int minutes = hour * 60 + minute;

                if(!result.containsKey(key)) {
                    result.put(key, 0);
                }
                result.put(key, result.get(key) + minutes);
            }
        }
        
        int idx = 0;
        int[] answer = new int[result.size()];
        for(String key : result.keySet()) {
            int min = result.get(key);
            
            int fee = min > fees[0] ? (fees[1] + ( (min - fees[0]) % fees[2] == 0 ? (min - fees[0]) / fees[2] : (min - fees[0]) / fees[2] + 1) * fees[3]) : fees[1];
            answer[idx++] = fee;
        }
        
        return answer;
    }
}