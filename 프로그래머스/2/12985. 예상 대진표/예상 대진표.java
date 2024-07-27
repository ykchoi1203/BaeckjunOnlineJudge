class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = (int)(Math.log(n) / Math.log(2));
        int min = 1;
        int max = n;
        
        while(true) {
            int mid = (max + min) / 2;
            if(a <= mid && b <= mid) {
                max = mid;
                answer--;
            } else if(a > mid && b > mid) {
                min = mid;
                answer--;
            } else {
                break;
            }
        }
        
        return answer;
    }
}