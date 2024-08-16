class Solution {
    public long solution(int w, int h) {
        return (long)w * h - (w + h - gdc(w, h));
    }
    
    public int gdc(int a, int b) {
        if(b > a) {
            return gdc(b, a);
        }
        
        if(a % b == 0) return b;
        
        return gdc(b, a % b);
    }
}