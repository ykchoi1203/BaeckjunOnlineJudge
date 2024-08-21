import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<Assignment> stack = new Stack<>();
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
        int idx = 0;
        int lastEndTime = 0;
        for(int i = 0; i < plans.length; i++) {
            if(i != plans.length - 1) {
                String[] startTime = plans[i][1].split(":");
                int start = (Integer.parseInt(startTime[0]) * 60) + Integer.parseInt(startTime[1]); 
                int time = start + Integer.parseInt(plans[i][2]);
                if(lastEndTime < start) {
                    int remaining = start - lastEndTime;
                    while(remaining > 0 && !stack.isEmpty()) {
                        Assignment plan = stack.pop();
                        if(plan.remaining <= remaining) {
                            remaining -= plan.remaining;
                            answer[idx++] = plan.subject;
                        } else {
                            plan.remaining -= remaining;
                            stack.push(plan);
                            break;
                        }
                    }
                }
                lastEndTime = time;
                String[] nextStartTime = plans[i+1][1].split(":");
                int nextTime = (Integer.parseInt(nextStartTime[0]) * 60) + Integer.parseInt(nextStartTime[1]);
                if(time > nextTime) {
                    stack.push(new Assignment(plans[i][0], start, time, time - nextTime));
                } else {
                    answer[idx++] = plans[i][0];
                }
            } else {
                String[] startTime = plans[i][1].split(":");
                int start = (Integer.parseInt(startTime[0]) * 60) + Integer.parseInt(startTime[1]); 
                int time = start + Integer.parseInt(plans[i][2]);
                if(lastEndTime < start) {
                    int remaining = start - lastEndTime;
                    while(remaining > 0 && !stack.isEmpty()) {
                        Assignment plan = stack.pop();
                        if(plan.remaining <= remaining) {
                            remaining -= plan.remaining;
                            answer[idx++] = plan.subject;
                        } else {
                            plan.remaining -= remaining;
                            stack.push(plan);
                            break;
                        }
                    }
                }
                answer[idx++] = plans[i][0];
            }
        }
        
        while(!stack.isEmpty()) {
            answer[idx++] = stack.pop().subject;
        }
        
        return answer;
    }
    
    public class Assignment {
        String subject;
        int startTime;
        int endTime;
        int remaining;
        
        public Assignment(String subject, int startTime, int endTime, int remaining) {
            this.subject = subject;
            this.startTime = startTime;
            this.endTime = endTime;
            this.remaining = remaining;
        }
    }
}