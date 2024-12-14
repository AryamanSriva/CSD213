import java.util.*;
public class prog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            System.out.println("Enter a number" + (i + 1) + ":");
            int currentnumber = sc.nextInt();
            if (currentnumber > max) {
                max = currentnumber;
            }
        }
        sc.close();
        System.out.println("The maximum number is:"+max);
}
}