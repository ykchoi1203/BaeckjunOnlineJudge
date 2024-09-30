import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();
        
        for(int i=1; i<=n; i++) {
            String name = br.readLine();
            
            map.put(i, name);
            nameMap.put(name, i);
        }
        
        for(int i=0; i<m; i++) {
            String name = br.readLine();
            
            if(nameMap.containsKey(name)) {
                System.out.println(nameMap.get(name));
            } else {
                boolean isTrue = true;
                for(char c : name.toCharArray()) {
                    if(c < '0' || c > '9') {
                        isTrue = false;
                        break;
                    }
                }

                if(isTrue)
                    System.out.println(map.get(Integer.parseInt(name)));
            }
        }
    }
}