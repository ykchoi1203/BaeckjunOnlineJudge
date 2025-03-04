import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[m];
        int[] count = new int[101];
        int[] idx = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < m; i++) {
            if(set.contains(arr[i])) {
                count[arr[i]]++;
                continue;
            } else {
                if(set.size() < n) {
                    set.add(arr[i]);
                    count[arr[i]]++;
                    idx[arr[i]] = i;
                } else {
                    int min = Integer.MAX_VALUE;
                    Set<Integer> list = new HashSet<>();
                    for(int k : set) {
                        if(count[k] < min) {
                            min = count[k];
                            list.clear();
                            list.add(k);
                        } else if(count[k] == min) {
                            list.add(k);
                        }
                    }

                    if(list.size() == 1) {
                        int remove = list.iterator().next();
                        set.remove(remove);
                        count[remove] = 0;
                        idx[remove] = i;
                    } else {
                        int last = i;
                        int remove = 0;
                        for(int k : list) {
                            if(last > idx[k]) {
                                last = idx[k];
                                remove = k;
                            }
                        }

                        set.remove(remove);
                        count[remove] = 0;
                        idx[remove] = last;
                    }

                    set.add(arr[i]);
                    idx[arr[i]] = i;
                    count[arr[i]]++;
                }
            }


        }

        TreeSet<Integer> answer = new TreeSet<>(set);

        for(Integer key : answer) {
            System.out.print(key + " ");
        }

    }

}
