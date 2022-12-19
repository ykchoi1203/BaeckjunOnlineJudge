class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++) {
            String[] quizSplit = quiz[i].split(" ");
            answer[i] = isCorrect(quizSplit[0], quizSplit[1], quizSplit[2], quizSplit[4]);
        }
        
        return answer;
    }
    
    public String isCorrect(String x, String cal, String y, String answer) {
        if(cal.equals("+")) {
            if(Integer.parseInt(x) + Integer.parseInt(y) == Integer.parseInt(answer)) return "O";
            else return "X";
        } else {
            if(Integer.parseInt(x) - Integer.parseInt(y) == Integer.parseInt(answer)) return "O";
            else return "X";
        }
    }
}