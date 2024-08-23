class Solution {
    public int solution(String name) {
        int answer = 0;
        
        if(name.length() == 1) {
            return Math.min(26 - (name.charAt(0) - 'A'), name.charAt(0) - 'A');
        }
        
        int[] dir = new int[name.length()];
        int[] reverse = new int[name.length() + 1];
        
        for(int i=0; i<name.length(); i++) {
            dir[i] += Math.min(26 - (name.charAt(i) - 'A'), name.charAt(i) - 'A');
            if(i != 0) dir[i] += dir[i-1];
            reverse[name.length() - 1 - i] += Math.min(26 - (name.charAt(name.length() - 1 - i) - 'A'), name.charAt(name.length() - 1 - i) - 'A');
            if(i != 0) reverse[name.length() - 1 - i] += reverse[name.length() - i];
        }
        
        answer = dir[dir.length-1] + dir.length - 1;
        
        for(int i=0; i<name.length(); i++) {
            int sum = 0;
            int start = i;
            int end = i;
            while(start >= 0 && name.charAt(start) == 'A') {
                start--;
            }
            if(start < 0) start = 0;
            
            while(end < name.length() && name.charAt(end) == 'A') {
                end++;
            }
            
            if(start != end) {
                answer = Math.min(answer , Math.min(dir[start] + (start * 2) + reverse[end] + dir.length - end, reverse[end] + (dir.length - end) * 2 + dir[start] + start));
            }
        }
        
        return answer;
    }
}