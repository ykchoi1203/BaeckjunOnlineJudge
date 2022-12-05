import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int[] xMap = new int[10];
        int[] yMap = new int[10];

        for(int i=0; i<X.length(); i++){
            xMap[X.charAt(i) - '0'] += 1;
        }
        for(int i=0; i<Y.length(); i++){
            yMap[Y.charAt(i) - '0'] += 1;
        }
        int cnt = 0;

        for(int i=xMap.length-1; i>=0; i--){
            int j = (xMap[i] > yMap[i]) ? yMap[i] : xMap[i];
            if(cnt == 0 && i == 0 && j != 0)
                return "0";
            for(int k=0; k<j; k++){
                sb.append(i);
                cnt++;
            }
        }

        if(cnt == 0){
            return "-1";
        }

        return sb.toString();
    }
}