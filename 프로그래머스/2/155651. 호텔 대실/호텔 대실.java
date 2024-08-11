import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        
        PriorityQueue<int[]> time = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for(String[] bookTime : book_time) {
            String[] start_time = bookTime[0].split(":");
            String[] end_time = bookTime[1].split(":");
            int start = Integer.parseInt(start_time[0]) * 60 + Integer.parseInt(start_time[1]);
            int end = Integer.parseInt(end_time[0]) * 60 + Integer.parseInt(end_time[1]) + 10;
            
            while(!time.isEmpty() && time.peek()[1] <= start) {
                time.poll();
            }
            
            time.offer(new int[] {start, end});
            
            answer = Math.max(answer, time.size());
            
        }
        
        
        return answer;
    }
}