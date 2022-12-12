class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] babble = new String[] {"aya", "ye", "woo", "ma"};

        // for(String s : babbling) {
        //     if(s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) continue;
        //     for(int i=0; i<babble.length; i++)
        //        s = s.replace(babble[i], " ");
        //     s = s.replace(" ", "");
        //     if(s.length() == 0)
        //         answer++;
        // }
        
        for(String s : babbling){
            int lastWord = 0;
            boolean isBabbling = true;
            if(s.length() == 0)
                isBabbling = false;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == 'a'){
                    if(i + 2 < s.length() && s.charAt(i+1) == 'y' && s.charAt(i+2) == 'a' && lastWord != 1){
                        lastWord = 1;
                        i += 2;
                    } else{
                        isBabbling = false;
                        break;
                    }
                } else if (s.charAt(i) == 'y'){
                    if(i + 1 < s.length() && s.charAt(i+1) == 'e' && lastWord != 2){
                        lastWord = 2;
                        i += 1;
                    } else{
                        isBabbling = false;
                        break;
                    }
                } else if (s.charAt(i) == 'w'){
                    if(i + 2 < s.length() && s.charAt(i+1) == 'o' && s.charAt(i+2) == 'o' && lastWord != 3){
                        lastWord = 3;
                        i += 2;
                    } else{
                        isBabbling = false;
                        break;
                    }
                } else if(s.charAt(i) == 'm'){
                    if(i + 1 < s.length() && s.charAt(i+1) == 'a' && lastWord != 4){
                        lastWord = 4;
                        i += 1;
                    } else{
                        isBabbling = false;
                        break;
                    }
                } else {
                    isBabbling = false;
                    break;
                }
            }
            if(isBabbling)
                answer++;
        }

        return  answer;
    }
}