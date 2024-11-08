import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int[][] shape : shapes ) {
            for(int i=0; i<=n-shape.length; i++) {
                for(int j=0; j<=m-shape[0].length; j++) {
                    int sum = 0;
                    for(int k=0; k<shape.length; k++) {
                        for(int l=0; l<shape[k].length; l++) {
                            sum += shape[k][l] * arr[i + k][j + l];
                        }
                    }
                    answer = Math.max(sum, answer);
                }
            }
        }
        
        System.out.println(answer);
        
    }
    
    static int n;
    static int m;
    static int[][] arr;
    static int answer = 0;
    static int[][][] shapes = new int[][][] 
    {{{1, 1, 1, 1}},{{1},{1},{1},{1}},{{1, 1},{1, 1}},{{1, 0, 0},{1, 1, 1}},{{1, 1},{1, 0},{1, 0}},
     {{1, 1, 1},{0, 0, 1}}, {{0, 1},{0, 1},{1, 1}},{{0, 0, 1},{1, 1, 1}},{{1, 0},{1, 0},{1, 1}},
     {{1, 1, 1},{1, 0, 0}},{{1, 1},{0, 1},{0, 1}},{{1, 0},{1, 1},{0, 1}},{{0, 1, 1},{1, 1, 0}},{{0, 1},{1, 1},{1, 0}},
     {{1, 1, 0},{0, 1, 1}},{{0, 1, 0},{1, 1, 1}},{{1, 0},{1, 1},{1, 0}},{{1, 1, 1},{0, 1, 0}},
     {{0, 1},{1, 1},{0, 1}}};
    
}