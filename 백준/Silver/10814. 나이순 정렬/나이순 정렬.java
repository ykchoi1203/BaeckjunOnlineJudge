import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> a.age == b.age ? a.idx - b.idx : a.age - b.age);
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            pq.add(new Person(Integer.parseInt(st.nextToken()), i, st.nextToken()));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            Person p = pq.poll();
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    public static class Person {
        public int age;
        public int idx;
        public String name;
        
        public Person(int age, int idx, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }
    }
}