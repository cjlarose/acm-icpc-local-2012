import java.util.Scanner;

public class phone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numValues = scan.nextInt();
		
		String[] names = new String[numValues];
		String[] nameRev = new String[numValues];

		for (int n = 0; n < numValues;n++){
			names[n] = scan.next();
		}
		
		
		for(int n = 0; n < numValues;n++){
			names[n] = names[n].toUpperCase();
			
			nameRev[n] = "";
			for (int i = 0; i < names[n].length();i++){
				nameRev[n] += names[n].charAt((names[n].length()-1) - i);
			}
		}
		
		for (int n = 0; n < numValues;n++){
			
			if (toNumber(names[n]).equals(toNumber(nameRev[n])))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		
	}
	
	private static String toNumber(String s) {
		String result = "";
		for (int i =0; i < s.length(); i ++){
			if("ABC".indexOf("" + s.charAt(i)) > -1)
				result += "" + 2;
			if("DEF".indexOf("" + s.charAt(i)) > -1)
				result += "" + 3;
			if("GHI".indexOf("" + s.charAt(i)) > -1)
				result += "" + 4;
			if("JKL".indexOf("" + s.charAt(i)) > -1)
				result += "" + 5;
			if("MNO".indexOf("" + s.charAt(i)) > -1)
				result += "" + 6;
			if("PQRS".indexOf("" + s.charAt(i)) > -1)
				result += "" + 7;
			if("TUV".indexOf("" + s.charAt(i)) > -1)
				result += "" + 8;
			if("WXYZ".indexOf("" + s.charAt(i)) > -1)
				result += "" + 9;
		}
		return result;
	}

}
