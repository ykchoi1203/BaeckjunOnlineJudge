import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        int answer = 0;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, arr[i][j]);
            }
        }

        answer = dfs(arr, 0, answer);

        System.out.println(answer);

    }

    static int[][] arr;
    static int n;

    public static int dfs(int[][] getArr, int count, int max) {
        if(count == 5) {
            return max;
        }

        int returnMax = max;

        int[][] newArr = new int[n][n];

        int newMax = max;

        for(int j=0; j<n; j++) {
            Deque<Integer> deque = new ArrayDeque<>();
            boolean isSum = false;
            for(int i=0; i<n; i++) {
                if(getArr[i][j] != 0 && isSum) {
                    deque.addLast(getArr[i][j]);
                    isSum = false;
                } else if(getArr[i][j] != 0) {
                    if(deque.isEmpty() || deque.peekLast() != getArr[i][j]) {
                        deque.addLast(getArr[i][j]);
                    } else {
                        deque.pollLast();
                        deque.addLast(getArr[i][j] * 2);
                        newMax = Math.max(newMax, getArr[i][j] * 2);
                        isSum = true;
                    }
                }
            }
            int i = 0;
            while(!deque.isEmpty()) {
                newArr[i][j] = deque.pollFirst();
                i++;
            }
        }

        boolean isSame = true;

        loop:
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(getArr[i][j] != newArr[i][j]) {
                    isSame = false;
                    break loop;
                }
            }
        }

        if(!isSame) {
            returnMax = Math.max(returnMax, dfs(newArr, count+1, newMax));
        }

        newArr = new int[n][n];

        newMax = max;

        for(int j=0; j<n; j++) {
            Deque<Integer> deque = new ArrayDeque<>();
            boolean isSum = false;
            for(int i=n-1; i>=0; i--) {
                if(getArr[i][j] != 0 && isSum) {
                    deque.addLast(getArr[i][j]);
                    isSum = false;
                } else if(getArr[i][j] != 0) {
                    if(deque.isEmpty() || deque.peekLast() != getArr[i][j]) {
                        deque.addLast(getArr[i][j]);
                    } else {
                        deque.pollLast();
                        deque.addLast(getArr[i][j] * 2);
                        newMax = Math.max(newMax, getArr[i][j] * 2);
                        isSum = true;
                    }
                }
            }

            int i = n-1;
            while(!deque.isEmpty()) {
                newArr[i][j] = deque.pollFirst();
                i--;
            }
        }

        isSame = true;

        loop:
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(getArr[i][j] != newArr[i][j]) {
                    isSame = false;
                    break loop;
                }
            }
        }

        if(!isSame) {
            returnMax = Math.max(returnMax, dfs(newArr, count+1, newMax));
        }

        newArr = new int[n][n];

        newMax = max;

        for(int i=0; i<n; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            boolean isSum = false;
            for(int j=0; j<n; j++) {
                if(getArr[i][j] != 0 && isSum) {
                    deque.addLast(getArr[i][j]);
                    isSum = false;
                } else if(getArr[i][j] != 0) {
                    if(deque.isEmpty() || deque.peekLast() != getArr[i][j]) {
                        deque.addLast(getArr[i][j]);
                    } else {
                        deque.pollLast();
                        deque.addLast(getArr[i][j] * 2);
                        newMax = Math.max(newMax, getArr[i][j] * 2);
                        isSum = true;
                    }
                }
            }
            int j = 0;
            while(!deque.isEmpty()) {
                newArr[i][j] = deque.pollFirst();
                j++;
            }
        }

        isSame = true;

        loop:
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(getArr[i][j] != newArr[i][j]) {
                    isSame = false;
                    break loop;
                }
            }
        }

        if(!isSame) {
            returnMax = Math.max(returnMax, dfs(newArr, count+1, newMax));
        }

        newArr = new int[n][n];

        newMax = max;

        for(int i=0; i<n; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            boolean isSum = false;
            for(int j=n-1; j>=0; j--) {
                if(getArr[i][j] != 0 && isSum) {
                    deque.addLast(getArr[i][j]);
                    isSum = false;
                } else if(getArr[i][j] != 0) {
                    if(deque.isEmpty() || deque.peekLast() != getArr[i][j]) {
                        deque.addLast(getArr[i][j]);
                    } else {
                        deque.pollLast();
                        deque.addLast(getArr[i][j] * 2);
                        newMax = Math.max(newMax, getArr[i][j] * 2);
                        isSum = true;
                    }
                }
            }
            int j = n-1;
            while(!deque.isEmpty()) {
                newArr[i][j] = deque.pollFirst();
                j--;
            }
        }

        isSame = true;

        loop:
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(getArr[i][j] != newArr[i][j]) {
                    isSame = false;
                    break loop;
                }
            }
        }

        if(!isSame) {
            returnMax = Math.max(returnMax, dfs(newArr, count+1, newMax));
        }

        return returnMax;
    }
}