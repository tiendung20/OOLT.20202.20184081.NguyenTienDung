import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Array5_6 {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Random number = new Random();
		int[] array1 = new int[1000];
		int i,n,sum=0;
		for(i=0;i<1000;i++) {
			array1[i] = number.nextInt(5000);
		}
		System.out.print("Enter the number of array elements: ");
		n = input.nextInt();
		int[] array2 = new int[n];
		for(i=0;i<n;i++) {
			String a;
			System.out.print("Enter a"+i+": ");
			if(i==0) input.nextLine();
			a = input.nextLine();
			if(a.equals("$")) array2[i] = array1[i];
			else array2[i] = Integer.parseInt(a);
			sum += array2[i];
		}
		Arrays.sort(array2);
		System.out.println("Array after sorting:\n"+Arrays.toString(array2));
		System.out.println("Sum: "+sum+"\nAverage: "+(double)sum/n);
		input.close();
	}

}
