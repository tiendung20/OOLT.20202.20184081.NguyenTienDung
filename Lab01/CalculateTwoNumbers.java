import javax.swing.JOptionPane;
public class CalculateTwoNumbers {

	public static void main(String[] args) {
		String strNum1,strNum2;
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.QUESTION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.QUESTION_MESSAGE);
		double num1,num2;
		num1 = Double.parseDouble(strNum1);
		num2 = Double.parseDouble(strNum2);
		JOptionPane.showMessageDialog(null, "Sum: "+(num1+num2)+"\n"+"Difference: "+(num1-num2)+"\n"+"Product: "+(num1*num2)+"\n"+"Quotient: "+(num1/num2), "Result", JOptionPane.INFORMATION_MESSAGE);
	}

}
