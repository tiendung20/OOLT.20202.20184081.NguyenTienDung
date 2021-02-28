import java.util.Scanner;
public class LinearSolve {

	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		int select;
		double a,b,a11,a12,a21,a22,b1,b2,D,D1,D2;
		do {
			System.out.println("-----MeNu-----");
			System.out.println("1.The first-degree equation with one variable\n2.The system of first-degree equations with two variables");
			System.out.println("3.The second-degree equation with one variable\n4.Exit");
			System.out.print("Select: ");
			select = Input.nextInt();
			switch(select) {
			case 1:
				do {
					System.out.print("Equation ax + b = 0\nEnter a!=0: ");
					a = Input.nextDouble();
					if(a==0) System.out.println("a != 0");
				}while(a==0);
				System.out.print("Enter b: ");
				b = Input.nextDouble();
				System.out.println("Result: x = "+(-b/a));
				break;
			case 2:
				System.out.print("a11*x1+a12*x2=b1\na21*x1+a22*x2=b2\nEnter a11: ");
				a11 = Input.nextDouble();
				System.out.print("Enter a12: ");
				a12 = Input.nextDouble();
				System.out.print("Enter a21: ");
				a21 = Input.nextDouble();
				System.out.print("Enter a22: ");
				a22 = Input.nextDouble();
				System.out.print("Enter b1: ");
				b1 = Input.nextDouble();
				System.out.print("Enter b2: ");
				b2 = Input.nextDouble();
				D = a11*a22-a21*a12;
				D1 = b1*a22-b2*a12;
				D2 = a11*b2-a21*b1;
				if(D!=0) System.out.println("Result: x1 = "+(D1/D)+" and x2 = "+(D2/D));
				if(D==0) {
					if(D1==0&&D2==0) System.out.println("Infinitely many solutions!");
					else System.out.println("No solution!");
				}
				break;
			case 3:
				System.out.print("ax^2+bx+c=0\nEnter a: ");
				a = Input.nextDouble();
				System.out.print("Enter b: ");
				b = Input.nextDouble();
				System.out.print("Enter c: ");
				b1 = Input.nextDouble();
				b2 = Math.pow(b, 2) - 4*a*b1;
				if(b2==0) System.out.println("Result: x = "+(-b/(2*a)));
				else if(b2>0) System.out.println("Result: x = "+((-b+Math.sqrt(b2))/(2*a)) + " or x = "+((-b-Math.sqrt(b2))/(2*a)));
				else System.out.println("No solution!");
				break;
			}
		}while(select>0&&select<4);
		Input.close();
	}

}
