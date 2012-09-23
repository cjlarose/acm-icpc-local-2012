import java.util.Scanner;


public class sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int number_of_cases = s.nextInt();
		int a;
		int b;
		int[] sums = new int[number_of_cases];
		for (int i = 0 ; i < number_of_cases; i++) {
			a = s.nextInt();
			b = s.nextInt();
			sums[i] = a + b;
			
		}
		for (int i = 0; i < sums.length; i++)
			System.out.println(sums[i]);
	}

}
