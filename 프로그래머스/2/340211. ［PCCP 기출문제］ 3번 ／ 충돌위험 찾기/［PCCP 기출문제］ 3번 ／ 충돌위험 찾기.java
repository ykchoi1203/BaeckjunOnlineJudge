import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        int[][] robotsIdx = new int[routes.length][2];
        int[][] map = new int[101][101];
        int[] curRoutes = new int[routes.length];
        Set<Integer> finish = new HashSet<>();

        for (int i = 0; i < routes.length; i++) {
            robotsIdx[i][0] = points[routes[i][0]-1][0];
            robotsIdx[i][1] = points[routes[i][0]-1][1];
            map[robotsIdx[i][0]][robotsIdx[i][1]]++;
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] > 1)
                    answer++;
            }
        }

        while (finish.size() < routes.length) {
            for (int i = 0; i < routes.length; i++) {
                if (!finish.contains(i)) {
                    if (curRoutes[i] == routes[i].length-1) {
                        finish.add(i);
                        continue;
                    }

                    if (robotsIdx[i][0] != points[routes[i][curRoutes[i] + 1]-1][0]) {
                        if (robotsIdx[i][0] > points[routes[i][curRoutes[i] + 1]-1][0]) {
                            robotsIdx[i][0]--;
                        } else {
                            robotsIdx[i][0]++;
                        }
                        
                        if (robotsIdx[i][0] == points[routes[i][curRoutes[i] + 1]-1][0] && robotsIdx[i][1] == points[routes[i][curRoutes[i] + 1]-1][1]) {
                            curRoutes[i]++;
                        }
                    } else {
                        if (robotsIdx[i][1] > points[routes[i][curRoutes[i] + 1]-1][1]) {
                            robotsIdx[i][1]--;
                        } else {
                            robotsIdx[i][1]++;
                        }

                        if (robotsIdx[i][1] == points[routes[i][curRoutes[i] + 1]-1][1]) {
                            curRoutes[i]++;
                        }

                    }
                }
            }

            Set<Idx> set = new HashSet<>();
            Set<Idx> isAdd = new HashSet<>();
            int j = 0;
            for(int[] idx : robotsIdx) {
                if(finish.contains(j)) {
                    j++;
                    continue;
                }
                if(!set.add(new Idx(idx[0], idx[1]))) {
                    if(isAdd.add(new Idx(idx[0], idx[1]))) {
                       answer++;
                    }
                }
                j++;
            }
        }
        
        return answer;
    }
    
    
    public class Idx implements Comparable<Idx> {
        int x;
        int y;

        public Idx(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * 101 + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Idx) {
                Idx idx = (Idx) obj;
                return x == idx.x && y == idx.y;
            }

            return false;
        }

        @Override
        public int compareTo(Idx o) {
            if(x == o.x && y == o.y) {
                return 0;
            } else if(x != o.x) {
                return x - o.x;
            } else {
                return y - o.y;
            }
        }
    }
}