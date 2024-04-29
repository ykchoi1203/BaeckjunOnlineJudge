import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    if(k == 0) {
      System.out.println("-1");
      return;
    }
    
    int newN = n;
    
    while(Integer.bitCount(newN) > k) {
      newN++;
    }

    System.out.println(newN - n);

  }
}