import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<Rec> list = new ArrayList<>();
        HashMap<String, String> name = new HashMap<>();
        
        for(String rec : record) {
            Rec cur = new Rec(rec);
            if(cur.getWorkNumber() != 1)
                name.put(cur.getUId(), cur.getNick());
            
            if(cur.getWorkNumber() == 2) {
                continue;
            } 
            
            list.add(cur);
        }
        
        answer = new String[list.size()];
        
        for(int i=0; i<answer.length; i++) {
            Rec cur = list.get(i);
            answer[i] = name.get(cur.getUId()) + cur.toString();
        } 
        
        return answer;
    }
    
    public class Rec {
        String work;
        String uId;
        String nick;
        
        public Rec(String rec) {
            String[] split = rec.split(" ");
            
            work = split[0];
            uId = split[1];
            if(split.length > 2)
                nick = split[2];
        }
        
        public String getUId() {
            return uId;
        }
        
        public String getNick() {
            return nick;
        }
        
        public int getWorkNumber() {
            if(work.equals("Enter")) {
                return 0;
            } else if(work.equals("Leave")) {
                return 1;
            } 
            return 2;
        }
        
        public String toString() {
            if(work.equals("Enter")) {
                return "님이 들어왔습니다.";
            }
            return "님이 나갔습니다.";
        }
    }
}