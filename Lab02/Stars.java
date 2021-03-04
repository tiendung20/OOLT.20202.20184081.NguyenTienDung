import java.util.Scanner;
public class Stars {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = input.nextInt();
		int i,j;
		for(i=0;i<n;i++) {
			for(j=0;j<(n-i);j++) {
				System.out.print(" ");
			}
			for(j=0;j<(i*2+1);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		input.close();
	}

}