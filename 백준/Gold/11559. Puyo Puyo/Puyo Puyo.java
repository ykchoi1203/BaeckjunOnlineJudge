import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<12; i++) {
            String s = sc.nextLine();

            for(int j=0; j<6; j++) {
                switch(s.charAt(j)) {
                    case 'R':
                        arr[i][j] = 1;
                        break;
                    case 'G':
                        arr[i][j] = 2;
                        break;
                    case 'B':
                        arr[i][j] = 3;
                        break;
                    case 'P':
                        arr[i][j] = 4;
                        break;
                    case 'Y':
                        arr[i][j] = 5;
                        break;
                }
            }
        }

        int cnt = 0;

        while(isRemove()) {
            arr = move();
            cnt++;
        }

        System.out.println(cnt);
    }

    static int[][] arr = new int[12][6];

    public static boolean isRemove() {
        boolean[][] visited = new boolean[12][6];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean isRemove = false;
        for(int i=0; i<12; i++) {
            for(int j=0; j<6; j++) {
                if(arr[i][j] != 0 && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    Set<int[]> set = new HashSet<>();
                    visited[i][j] = true;
                    q.add(new int[] {i, j});
                    set.add(new int[] {i, j});

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        for(int[] d : dxdy) {
                            int x = d[0] + cur[0];
                            int y = d[1] + cur[1];

                            if(x >= 0 && x < 12 && y >= 0 && y < 6
                                    && arr[x][y] == arr[i][j] && !visited[x][y]) {
                                visited[x][y] = true;
                                set.add(new int[] {x, y});
                                q.add(new int[] {x, y});
                            }
                        }
                    }

                    if(set.size() >= 4) {
                        for(int[] cur : set) {
                            arr[cur[0]][cur[1]] = 0;
                        }
                        isRemove = true;
                    }
                }
            }
        }

        return isRemove;

    }

    public static int[][] move() {
        int[][] newArr = new int[12][6];

        for(int j=0; j<6; j++) {
            int idx = 11;
            for(int i=11; i>=0; i--) {
                if(arr[i][j] != 0) {
                    newArr[idx--][j] = arr[i][j];
                }
            }
        }

        return newArr;
    }

}
