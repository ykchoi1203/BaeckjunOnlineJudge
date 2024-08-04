import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        TreeSet<SaveFile> set = new TreeSet<>();
        int idx = 0;
        
        for(String file : files) {
            set.add(new SaveFile(file, idx));
            idx++;
        }
        
        idx = 0;
        
        for(SaveFile file : set) {
            answer[idx++] = file.fileName;
            System.out.println(file.fileName + " " + file.idx + " " + file.head + " " + file.number);
        }
        
        return answer;
    }
    
    public class SaveFile implements Comparable<SaveFile> {
        String fileName;
        String head;
        int number;
        int idx;
        
        public SaveFile(String file, int idx) {
            fileName = file;
            this.idx = idx;
            getFileNumber(file);
        }
        
        public void getFileNumber(String file) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<file.length(); i++) {
                char c = file.charAt(i);
                if(c >= '0' && c <= '9') {
                    head = sb.toString().toLowerCase();
                    sb = new StringBuilder();
                    sb.append(Character.toString(c));
                    for(int j=i+1; j< i+5 && j < file.length(); j++) {
                        c = file.charAt(j);
                        if(c >= '0' && c <= '9') {
                            sb.append(Character.toString(c));
                        } else break;
                    }
                    break;
                } else {
                    sb.append(Character.toString(c));
                }
            }
            number = Integer.parseInt(sb.toString());
        }

        @Override
        public int compareTo(SaveFile o1) {
            if(!this.head.equals(o1.head)) {
                return this.head.compareTo(o1.head);
            } 
            
            if(this.number != o1.number) {
                return this.number - o1.number;
            }
            
            return this.idx - o1.idx;
        }
    }
}