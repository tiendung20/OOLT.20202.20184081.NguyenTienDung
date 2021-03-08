import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Two_matrices {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random number = new Random();
		int n,i,j;
		do {
			System.out.print("Enter the array size: ");
			n = Integer.parseInt(input.nextLine());
		}while(n<1);
		int a[][] = new int[n][n],b[][] = new int[n][n];
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				a[i][j] = number.nextInt(5000);
			}
		}
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				String s;
				do {
					System.out.print("Enter a[" +i+"]["+j+"]: ");
					s = input.nextLine();
					if(s.length()<1) System.out.println("Error!");
				}while(s.length()<1);
				if(s.equals("$")) b[i][j] = a[i][j];
				else b[i][j] = Integer.parseInt(s);
			}
		}
		System.out.println(Arrays.deepToString(b));
		input.close();
	}

}
