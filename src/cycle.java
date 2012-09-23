import java.util.Scanner;

public class cycle {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int problems = s.nextInt();
		int results[] = new int[problems];
		int permutation[];
		int num, size, max, temp, tempMax;
		int first = 0;
		
		for(int i = 0; i < problems; i++) {
			num = s.nextInt();
			size = s.nextInt();
			max = s.nextInt();
			permutation = new int[size];
			
			for(int j = 0; j < size; j++) {
				permutation[j] = j;
				first += j*(10^j);
			}
			
			permutation = nextPermutation(permutation);
			while(toInt(permutation) != first) {
				temp = permutation[0];
				for(int j = 0; j <= permutation.length; j++) {
					if(temp == max)
						results[i]++;
					temp = permutation[temp];
				}
				permutation = nextPermutation(permutation);
			}
		}
		
		for(int i = 0; i < problems; i++) {
			System.out.println((i+1) + " " + results[i]);
		}
	}

	private static int toInt(int[] permutation) {
		int result = 0;
		for(int j = 0; j < permutation.length; j++) {
			result += j*(10^j);
		}
		return result;
	}

	private static int[] nextPermutation(int[] permutation) {
		int temp = toInt(permutation);
		
		temp++;
		
		while(!isPermutation(temp))
			temp++;
		String tempString = "" + temp;
		for(int i = 0; i < permutation.length; i++) {
			permutation[i] = tempString.charAt(i);
		}
		
		return permutation;
	}

	private static boolean isPermutation(int temp) {
		String tempString = "" + temp;
		
		for(int i = 0; i < tempString.length(); i++) {
			if(!tempString.contains(i + ""))
				return false;
		}
		
		return true;
	}
	
	

}
