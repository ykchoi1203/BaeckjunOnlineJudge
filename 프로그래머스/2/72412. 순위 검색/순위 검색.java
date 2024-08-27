import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<Integer, ArrayList<Integer>> list = new HashMap<>();

        for(int i=0; i<24; i++) {
            list.put(i, new ArrayList<>());
        }

        for(int i=0; i<info.length; i++) {
            String[] personInfo = info[i].split(" ");

            Person person = new Person(personInfo[0], personInfo[1], personInfo[2], personInfo[3], Integer.parseInt(personInfo[4]));
            list.get(person.getIdx()).add(person.score);
        }

        for(int i=0; i<list.size(); i++) {
            Collections.sort(list.get(i));
        }

        for(int i=0; i<query.length; i++) {
            String[] curQuery = query[i].split(" ");

            answer[i] = dfs(curQuery[0], curQuery[2], curQuery[4], curQuery[6], Integer.parseInt(curQuery[7]), 3, 0, list);
        }

        return answer;
    }
    
    public class Person {
        String language;
        String occupation;
        String history;
        String preference;
        int score;
        
        public Person(String language, String occupation, String history, String preference, int score) {
            this.language = language;
            this.occupation = occupation;
            this.history = history;
            this.preference = preference;
            this.score = score;
        }
        
        public int getLanguage() {
            if(language.equals("cpp")) {
                return 0;
            } else if(language.equals("java")) {
                return 1;
            }
            return 2;
        }
        
        public int getOccupation() {
            if(occupation.equals("backend")) {
                return 0;
            }
            return 1;
        }
        
        public int getHistory() {
            if(history.equals("junior")) {
                return 0;
            }
            return 1;
        }
        
        public int getPreference() {
            if(preference.equals("chicken")) {
                return 0;
            }
            
            return 1;
        }
        
        public int getIdx() {
            return getLanguage() * 8 + getOccupation() * 4 + getHistory() * 2 + getPreference();
        }
        
        public boolean isTrue(String language, String occupation, String history, String preference, int score) {
            if(!language.equals(this.language) && !language.equals("-")) {
                return false;
            }
            
            if(!occupation.equals(this.occupation) && !occupation.equals("-")) {
                return false;
            }
            
            if(!history.equals(this.history) && !history.equals("-")) {
                return false;
            }
            
            if(!preference.equals(this.preference) && !preference.equals("-")) {
                return false;
            }
            
            if(this.score < score) {
                return false;
            }
            
            return true;
        }
    }
    
    public int dfs(String language, String occupation, String history, String preference, int score, int idx, int listIdx, Map<Integer, ArrayList<Integer>> list) {
        if(idx < 0) {
            if(list.get(listIdx).isEmpty()) return 0;
            int start = 0;
            int end = list.get(listIdx).size() - 1;
            
            while(start <= end) {
                int mid =  (start + end) / 2;

                if(list.get(listIdx).get(mid) >= score) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return list.get(listIdx).size() - start;
        }

        int sum = 0;

        if(idx == 3) {
            if(language.equals("-")) {
                for(int i=0; i < 3; i++) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + 8 * i, list);
                }
            } else {
                if(language.equals("cpp")) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx, list);
                } else if(language.equals("java")) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + 8, list);
                } else {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + 16, list);
                }
            }
        }

        if(idx == 2) {
            if(occupation.equals("-")) {
                for(int i=0; i < 2; i++) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + 4 * i, list);
                }
            } else {
                if(occupation.equals("backend")) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx, list);
                } else {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + 4, list);
                }
            }
        }

        if(idx == 1) {
            if(history.equals("-")) {
                for(int i=0; i < 2; i++) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + 2 * i, list);
                }
            } else {
                if(history.equals("junior")) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx, list);
                } else {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + 2, list);
                }
            }
        }

        if(idx == 0) {
            if(preference.equals("-")) {
                for(int i=0; i < 2; i++) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + i, list);
                }
            } else {
                if(preference.equals("chicken")) {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx, list);
                } else {
                    sum += dfs(language, occupation, history, preference, score, idx-1, listIdx + 1, list);
                }
            }
        }

        return sum;
    }
}