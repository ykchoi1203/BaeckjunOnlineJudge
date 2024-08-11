import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        if(arrayA[0] == arrayB[0]) return 0;
        
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        
        for(int i=2; i<= Math.sqrt(arrayA[0]); i++) {
            if(arrayA[0] % i == 0) {
                setA.add(i);
                setA.add(arrayA[0] / i);
            }
        }
        
        setA.add(arrayA[0]);
        
        for(int i = 1; i < arrayA.length; i++) {
            Set<Integer> newSet = new HashSet<>();
            
            for(int div : setA) {
                if(arrayA[i] % div == 0) {
                    newSet.add(div);
                }
            }
            
            setA = newSet;
            
            if(setA.isEmpty()) {
                break;
            }
        }
        
        
        for(int i=2; i<= Math.sqrt(arrayB[0]); i++) {
            if(arrayB[0] % i == 0) {
                setB.add(i);
                setB.add(arrayB[0] / i);
            }
        }
        
        setB.add(arrayB[0]);
        
        for(int i = 1; i < arrayB.length; i++) {
            Set<Integer> newSet = new HashSet<>();
            
            for(int div : setB) {
                if(arrayB[i] % div == 0) {
                    newSet.add(div);
                }
            }
            
            setB = newSet;
            
            if(setB.isEmpty()) {
                break;
            }
        }
        
        for(int i = 0; i < arrayA.length; i++) {
            Set<Integer> newSet = new HashSet<>();
            
            for(int numB : setB) {
                if(arrayA[i] % numB != 0) {
                    newSet.add(numB);
                }
            }
            setB = newSet;
            if(setB.isEmpty()) break;
        }
        
        for(int i = 0; i < arrayB.length; i++) {
            Set<Integer> newSet = new HashSet<>();
            
            for(int numA : setA) {
                if(arrayB[i] % numA != 0) {
                    newSet.add(numA);
                }
            }
            setA = newSet;
            if(setA.isEmpty()) break;
        }
        
        for(int num : setA) {
            answer = Math.max(answer, num);
        }
        
        for(int num : setB) {
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
    
    
}