import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        
        arr = br.readLine().split(" ");
        
        Arrays.sort(arr);
        
        gather.add('a');
        gather.add('e');
        gather.add('i');
        gather.add('o');
        gather.add('u');
        
        backTrack(0, false, 0);
        
        System.out.println(sb.toString());
        
    }
    
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static String[] arr;
    static Set<Character> gather = new HashSet<>();
    static int n;
    static int m;
    
    static void backTrack(int idx, boolean haveGather, int countConsonant) {
        if(sb2.length() == n) {
            if(!haveGather || countConsonant < 2) return;
            
            sb.append(sb2).append("\n");
            return;
        }
        
        if(idx >= m) return;
        
        for(int i=idx; i<m; i++) {
            sb2.append(arr[i]);
            
            if(gather.contains(arr[i].charAt(0))) {
                backTrack(i+1, true, countConsonant);
            } else {
                backTrack(i+1, haveGather, countConsonant+1);
            }
            sb2.deleteCharAt(sb2.length()-1);
        }
    }
}