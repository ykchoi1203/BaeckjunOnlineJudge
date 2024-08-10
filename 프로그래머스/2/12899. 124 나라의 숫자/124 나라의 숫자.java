class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n != 0) {
            int remain = n % 3;
            n /= 3;
            switch(remain) {
                case 0:
                    sb.append("4");
                    n--;
                    break;
                case 1:
                    sb.append("1");
                    break;
                case 2:
                    sb.append("2");
                    break;
            }
        }
        
        return sb.reverse().toString();
    }
}