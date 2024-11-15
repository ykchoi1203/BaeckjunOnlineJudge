import java.util.*;
class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int n = target.length;
        int m = target[0].length;
        
        int[][] copyBeginning = new int[n][m];
        
        clone(copyBeginning, beginning);
        
        int answer1 = 0;
        for(int i=0; i<n; i++) {
            if(copyBeginning[i][0] != target[i][0]) {
                for(int k=0; k<m; k++) {
                    copyBeginning[i][k] = copyBeginning[i][k] == 0 ? 1 : 0;
                }
                answer1++;
            }
        }
        
        loop:
        for(int j=0; j<m; j++) {
            if(copyBeginning[0][j] != target[0][j]) {
                for(int k=0; k<n; k++) {
                    copyBeginning[k][j] = copyBeginning[k][j] == 0 ? 1 : 0;
                }
                answer1++;
            }
        }
        
        if(!isSame(copyBeginning, target)) {
            answer1 = Integer.MAX_VALUE;
        }
        
        copyBeginning = new int[n][m];
        
        clone(copyBeginning, beginning);
        
        int answer3 = 0;
        for(int i=0; i<n; i++) {
            if(copyBeginning[i][0] == target[i][0]) {
                for(int k=0; k<m; k++) {
                    copyBeginning[i][k] = copyBeginning[i][k] == 0 ? 1 : 0;
                }
                answer3++;
            }
        }
        
        loop:
        for(int j=0; j<m; j++) {
            if(copyBeginning[0][j] != target[0][j]) {
                for(int k=0; k<n; k++) {
                    copyBeginning[k][j] = copyBeginning[k][j] == 0 ? 1 : 0;
                }
                answer3++;
            }
        }
        
        if(!isSame(copyBeginning, target)) {
            answer3 = Integer.MAX_VALUE;
        }
        
        copyBeginning = new int[n][m];
        
        clone(copyBeginning, beginning);
        
        int answer4 = 0;
        for(int j=0; j<m; j++) {
            if(copyBeginning[0][j] == target[0][j]) {
                for(int k=0; k<n; k++) {
                    copyBeginning[k][j] = copyBeginning[k][j] == 0 ? 1 : 0;
                }
                answer4++;
            }
        }
        
        loop:
        for(int i=0; i<n; i++) {
            if(copyBeginning[i][0] != target[i][0]) {
                for(int k=0; k<m; k++) {
                    copyBeginning[i][k] = copyBeginning[i][k] == 0 ? 1 : 0;
                }
                answer4++;
            }
        }
        
        if(!isSame(copyBeginning, target)) {
            answer4 = Integer.MAX_VALUE;
        }
        
        int answer2 = 0;
        loop:
        for(int j=0; j<m; j++) {
            if(beginning[0][j] != target[0][j]) {
                for(int k=0; k<n; k++) {
                    beginning[k][j] = beginning[k][j] == 0 ? 1 : 0;
                }
                answer2++;
            }
        }
        
        loop:
        for(int i=0; i<n; i++) {
            if(beginning[i][0] != target[i][0]) {
                for(int k=0; k<m; k++) {
                    beginning[i][k] = beginning[i][k] == 0 ? 1 : 0;
                }
                answer2++;
            }
        }
        
        if(!isSame(beginning, target)) {
            answer2 = Integer.MAX_VALUE;
        }
   
        if(answer1 == Integer.MAX_VALUE && answer2 == Integer.MAX_VALUE && answer3 == Integer.MAX_VALUE && answer4 == Integer.MAX_VALUE) {
            return -1;
        }
        
        return Math.min(answer1, Math.min(answer2, Math.min(answer3, answer4)));
        
    }
    
    public boolean isSame(int[][] beginning, int[][] target) {
        for(int i=0; i<target.length; i++) {
            for(int j=0; j<target[i].length; j++) {
                if(beginning[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
    
    public void clone(int[][] copyBeginning, int[][] beginning) {
        for(int i=0; i<beginning.length; i++) {
            copyBeginning[i] = beginning[i].clone();    
        }

    }
}