import java.io.*;
import java.util.*;

public class Main {
    public static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    public static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int month = 0;

        for(int i = 0; i < months.length; i++) {
            if(s[0].equals(months[i])) {
                month = i + 1;
                break;
            }
        }

        int day = Integer.parseInt(s[1].replaceAll(",", ""));

        int year = Integer.parseInt(s[2]);

        String[] time = s[3].split(":");

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);


        if(year % 400 == 0) {
            days[1]++;
        } else if(year % 4 == 0 && year % 100 != 0) {
            days[1]++;
        }

        int total = 0;

        for(int i = 0; i < days.length; i++) {
            total += days[i] * 60 * 24;
        }

        int sum = 0;

        for(int i = 0; i < month - 1; i++) {
            sum += days[i] * 60 * 24;
        }

        sum += (day - 1) * 60 * 24;

        sum += hour * 60;
        sum += minute;

        double answer = ((double) sum) / total * 100;

        System.out.println(answer);

    }
}
