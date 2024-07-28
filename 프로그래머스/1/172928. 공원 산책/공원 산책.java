class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[] {0, 0};
        
        loop:
        for(int i=0; i<park.length; i++) {
            String load = park[i];
            for(int j=0; j<load.length(); j++) {
                if(load.charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break loop;
                }
            }
        }
        
        for(String route : routes) {
            char c = route.charAt(0);
            int move = route.charAt(2) - '0';
            boolean canMove = true;
            if(c == 'E') {
                if(move + answer[1] < park[0].length()) {
                    for(int i=answer[1] + 1; i <= answer[1] + move; i++) {
                        if(park[answer[0]].charAt(i) == 'X') {
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove) {
                        answer[1] += move;
                    }
                }
            } else if(c == 'N') {
                if(answer[0] - move >= 0) {
                    for(int i=answer[0]- 1; i >= answer[0] - move; i--) {
                        if(park[i].charAt(answer[1]) == 'X') {
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove) {
                        answer[0] -= move;
                    }
                }
            } else if(c == 'W') {
                if(answer[1] - move >= 0) {
                    for(int i=answer[1] - 1; i >= answer[1] - move; i--) {
                        if(park[answer[0]].charAt(i) == 'X') {
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove) {
                        answer[1] -= move;
                    }
                }
            } else if(c == 'S') {
                if(move + answer[0] < park.length) {
                    for(int i=answer[0] + 1; i <= answer[0] + move; i++) {
                        if(park[i].charAt(answer[1]) == 'X') {
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove) {
                        answer[0] += move;
                    }
                }
            }
        }
        
        return answer;
    }
}