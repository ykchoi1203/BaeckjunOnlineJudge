import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int cntA = 0;
        int answer = s.length();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') cntA++;
        }

        s += s;

        for(int i = 0; i < s.length()/2; i++){
            int lastIdx = i + s.length()/2 - 1;
            int cnt = 0;
            int aCnt = 0;
            for(int j = i; j < cntA + i && j < lastIdx; j++){
                if(s.charAt(j) == 'a') {
                    aCnt++;
                    if(aCnt == cntA) break;
                } else {
                    cnt++;
                }
            }
            answer = Math.min(answer, cnt);

        }


        System.out.println(answer);
    }
}
