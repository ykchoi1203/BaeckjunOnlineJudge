class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        
        loop:
        for(String[] place : places) {
            int[][] intPlace = new int[place.length][place[0].length()];
            for(int i=0; i<place.length; i++) {
                for(int j=0; j<place[i].length(); j++) {
                    char c = place[i].charAt(j);
                    switch(c) {
                        case 'P':
                            intPlace[i][j] = 2;
                            break;
                        case 'O':
                            intPlace[i][j] = 1;
                            break;
                    }
                }
            }
            
            for(int i = 0; i < intPlace.length; i++) {
                for(int j=0; j < intPlace[i].length; j++) {
                    if(intPlace[i][j] == 2) {
                        if(j + 1 < 5 && intPlace[i][j+1] == 2) {
                            answer[idx++] = 0;
                            continue loop;
                        }
                        
                        if(j + 2 < 5 && intPlace[i][j+1] == 1 && intPlace[i][j+2] == 2) {
                            answer[idx++] = 0;
                            continue loop;
                        }
                        
                        if(i + 1 < 5 && intPlace[i+1][j] == 2) {
                            answer[idx++] = 0;
                            continue loop;
                        }
                        
                        if(i + 1 < 5 && intPlace[i+1][j] == 1 && j + 1 < 5 && intPlace[i+1][j+1] == 2) {
                            answer[idx++] = 0;
                            continue loop;
                        }
                        
                        if(i + 2 < 5 && intPlace[i+1][j] == 1 && intPlace[i+2][j] == 2) {
                            answer[idx++] = 0;
                            continue loop;
                        }
                        
                        if(i - 1 >= 0 && j + 1 < 5 && (intPlace[i-1][j] == 1 || intPlace[i][j+1] == 1) && intPlace[i-1][j+1] == 2 )  {
                            answer[idx++] = 0;
                            continue loop;
                        }
                    } 
                }
            }
            answer[idx++] = 1;
        }
        
        
        
        return answer;
    }
}