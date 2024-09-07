import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int minX = lock.length;
        int maxX = 0;
        int minY = lock.length;
        int maxY = 0;
        int cnt = 0;
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if(lock[i][j] == 0) {
                    cnt++;
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        int keyCnt = 0;
        
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key[i].length; j++) {
                if(key[i][j] == 1 ) keyCnt++;
            }
        }
        
        if((maxX - minX) + 1 > key.length || (maxY - minY + 1) > key.length || keyCnt < cnt) {
            return false;
        }
        
        
        for(int k=0; k<4; k++) {
            if(checkKey(lock, key, minX, maxX, minY, maxY, cnt)) {
                return true;
            }
            
            key = rotate(key);
        }
        
        return false;
    }
    
    public int[][] rotate(int[][] key) {
        int[][] newKey = new int[key.length][key[0].length];
        
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key[i].length; j++) {
                newKey[i][j] = key[j][key.length - 1 - i];
            }
        }
        
        return newKey;
    }
    
    public boolean checkKey(int[][] lock, int[][] key, int minX, int maxX, int minY, int maxY, int cnt) {
        for(int k = maxX + 1 - key.length; k <= minX; k++) {
            for(int l = maxY + 1 - key.length; l <= minY; l++) {
                boolean isTrue = true;
                loop:
                for(int i = 0; i < key.length; i++) {
                    for(int j = 0; j < key.length; j++) {
                        if(k + i < 0 || l + j < 0) {
                            continue;
                        } else if(k + i >= lock.length || l + j >= lock[0].length) {
                            break;
                        } else if(lock[k + i][l + j] == key[i][j]){
                            isTrue = false;
                            break loop;
                        }
                    }
                }
                
                if(isTrue) return true;
            }
        }
        
        return false;

    }
    
}