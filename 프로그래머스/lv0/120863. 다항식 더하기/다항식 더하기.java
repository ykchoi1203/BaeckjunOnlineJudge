class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] arr = polynomial.split(" \\+ ");
        int[] x = new int[2];
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("x")) x[0]++;
            else if(arr[i].contains("x")) {
                x[0] += Integer.parseInt(arr[i].replace("x",""));
            } else {
                x[1] += Integer.parseInt(arr[i]);
            }
        }
        if(x[0] == 0) return Integer.toString(x[1]);
        else if(x[1] == 0) return x[0]==1 ? "x" : x[0] + "x";
        else return x[0] == 1 ? "x + " + x[1] : x[0] + "x + " + x[1];
    }
}