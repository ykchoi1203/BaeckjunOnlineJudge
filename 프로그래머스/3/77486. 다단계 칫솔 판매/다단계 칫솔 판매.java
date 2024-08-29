import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Seller> map = new HashMap<>();
        int idx = 0;
        for(int i=0; i < enroll.length; i++) {
            map.put(enroll[i], new Seller(enroll[i], idx));
            if(!referral[i].equals("-")) {
                map.get(enroll[i]).addParent(map.get(referral[i]));
            }
            idx++;
        }
        
        for(int i=0; i<seller.length; i++) {
            giveMoney(amount[i] * 100, map.get(seller[i]));
        }
        
        for(String name : enroll) {
            answer[map.get(name).idx] = map.get(name).money;
        }
        
        return answer;
    }
    
    public class Seller {
        String name;
        int idx;
        Seller parent;
        int money = 0;
        
        public Seller(String name, int idx) {
            this.name = name;
            this.idx = idx;
        }
        
        public void addParent(Seller parent) {
            this.parent = parent;
        }
        
        public void addMoney(int money) {
            this.money += money;
        }
    }
    
    public void giveMoney(int money, Seller seller) {
        if(money <= 0) {
            return;
        }
        
        if(seller.parent == null) {
            seller.addMoney(money - money / 10);
            return;
        } else {
            seller.addMoney(money - money / 10);
            giveMoney(money / 10, seller.parent);
        }
    }
}