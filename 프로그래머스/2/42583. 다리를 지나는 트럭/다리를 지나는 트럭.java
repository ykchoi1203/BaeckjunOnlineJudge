import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new LinkedList<>();
        
        int curWeight = 0;
        int time = 0;

        for(int truck : truck_weights) {
            time++;
            
            if(queue.isEmpty()) {
                queue.add(new Truck(truck, time + bridge_length));
                curWeight += truck;
                continue;
            }
            
            while(!queue.isEmpty() && time >= queue.peek().endTime) {
                curWeight -= queue.poll().weight;
            }
            
            if(curWeight + truck <= weight) {
                queue.add(new Truck(truck, time + bridge_length));
                curWeight += truck;
            } else {
                while(!queue.isEmpty() && curWeight + truck > weight) {
                    time = queue.peek().endTime;
                    curWeight -= queue.poll().weight;
                }
                queue.add(new Truck(truck, time + bridge_length));
                curWeight += truck;
            }   
        }
        
        while(!queue.isEmpty()) {
            time = queue.poll().endTime;
        }
        
        return time;
    }
    
    public class Truck {
        int weight;
        int endTime;
        
        public Truck(int weight, int time) {
            this.weight = weight;
            this.endTime = time;
        }
    }
}