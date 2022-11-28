import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        ArrayList<Integer> reserveAl = new ArrayList<>(Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList()));
        ArrayList<Integer> lostAl = new ArrayList<>(Arrays.stream(lost).boxed().sorted().collect(Collectors.toList()));
        for(int i=0; i<lostAl.size(); i++) {
            if(!reserveAl.isEmpty()) {
                if (reserveAl.contains(lostAl.get(i))) {
                    reserveAl.remove(reserveAl.indexOf(lostAl.get(i)));
                    lostAl.remove(i);
                    i--;
                }
            }
        }
        for(int i=0; i<lostAl.size();i++) {
            // if(!reserveAl.isEmpty()) {
                if (reserveAl.contains(lostAl.get(i) - 1)) {
                    reserveAl.remove(reserveAl.indexOf(lostAl.get(i) - 1));
                    lostAl.remove(i);
                    i--;
                } else if (reserveAl.contains(lostAl.get(i) + 1)) {
                    reserveAl.remove(reserveAl.indexOf(lostAl.get(i) + 1));
                    lostAl.remove(i);
                    i--;
                }
            // } else break;
        }

        return answer - lostAl.size();
    }
}