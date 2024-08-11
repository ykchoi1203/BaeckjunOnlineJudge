class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String[][] reps = new String[][] {{"C#", "H"}, {"D#", "I"}, {"F#", "J"}, {"G#", "K"}, {"A#", "L"}, {"B#", "M"}};
        int maxTime = 0;
        for(String[] rep : reps) {
            m = m.replaceAll(rep[0], rep[1]);
        }
        
        for(String music : musicinfos) {
            String[] info = music.split(",");
            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");
            int time = (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) * 60 + (Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]));
            
            for(String[] rep : reps) {
                info[3] = info[3].replaceAll(rep[0], rep[1]);
            }
            
            StringBuilder sb = new StringBuilder();
            
            while(sb.length() < time) {
                sb.append(info[3]);
            }
            
            if(sb.toString().substring(0, time).contains(m)) {
                if(maxTime < time) {
                    answer = info[2];
                    maxTime = time;
                }
            }
        }
        
        return answer;
    }
}