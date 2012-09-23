import java.util.Scanner;


public class rascal {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int[] results;

		int problem, n = 0, m = 0; // n = rowNumber m = index
		
		int numProblems = s.nextInt();
		results = new int[numProblems];
		
		for(int i = 0; i < numProblems; i++) {
			problem = s.nextInt();
			n = s.nextInt();
			m = s.nextInt();
			
			results[i] = m*(n-m)+1;
		}
		
		for(int i = 0; i < numProblems; i++) {
			System.out.println((i+1) + " " + results[i]);
		}

	}

}
