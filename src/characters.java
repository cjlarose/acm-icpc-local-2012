import java.util.Scanner;


public class characters {


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String[] allStrings;
		
		int numSets = s.nextInt();
		
		allStrings = new String[numSets];
		int line, repeat;
		String string;
		
		for(int i = 0; i < numSets; i++) {
			line = s.nextInt();
			repeat = s.nextInt();
			string = s.next();
			allStrings[i] = "";
			for(int j = 0; j < string.length(); j++) {
				for(int k = 0; k < repeat; k++)
					allStrings[i] += string.charAt(j);
			}
		}
		
		for(int i = 0; i < numSets; i++) {
			System.out.println((i+1) + " " + allStrings[i]);
		}


	}

}
