import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    list = new ArrayList<>();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int startNum = sc.nextInt();
    
    answer = new int[n+1];
    
    for(int i=0; i<=n; i++) {
      list.add(new TreeSet<>());
    }
    
    for(int i=0; i<m; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      list.get(x).add(y);
      list.get(y).add(x);
    }
      
    answer[startNum] = cnt;
    dfs(startNum);
    
    for(int i=1; i<=n; i++) {
      System.out.println(answer[i]);
    }

  }
  static int[] answer;
  static ArrayList<TreeSet<Integer>> list;
  static int cnt = 1;

  public static void dfs(int idx) {
    if(list.get(idx).isEmpty()) return;
    
    for(int nextIdx : list.get(idx)) {
      if(answer[nextIdx] == 0) {
        answer[nextIdx] = ++cnt;
        dfs(nextIdx);
      }
    }
  }
}
