import java.util.Scanner;


public class meganominoes {
	
	public static void main(String[] args) {
		mega[] megas;
		int[] sums;
		int[][] results;
		Scanner s = new Scanner(System.in);
		
		int problems = s.nextInt();
		results = new int[problems][];
		
		int numMegas, numSums, temp;
		for(int i = 0; i < problems; i++) {
			numMegas = s.nextInt();
			numSums = s.nextInt();
			megas = new mega[numMegas];
			sums = new int[numSums];
			results[i] = new int[numSums];
			
			// Initialize all meganominoes
			for(int j = 0; j < numMegas; j++)
				megas[j] = new mega(s.nextInt(), s.nextInt());
			
			// Initialize all possible sums
			for(int j = 0; j < numSums; j++) {
				results[i][j] = 0;
				sums[j] = s.nextInt();
			}
				
			// For each meganomino O(n)
			for(int j = 0; j < megas.length; j++) {
				// Add it to every further meganomino O(Sum1..n)
				for(int k = j+1; k < megas.length; k++) {
					
					temp = megas[j].connects(megas[k]);
					
					if(temp == -1) continue;
					
					// Check each pair to see if their sum is in sums O(m)
					for(int l = 0; l < sums.length; l++) {
						if(temp == sums[l]) {
							results[i][l]++;
							break;
						}
					}
					
				}
				
			}
			
		}
		
		for(int i = 0; i < problems; i++) {
			for(int j = 0; j < results[i].length; j++)
				System.out.println(results[i][j]);
		}
	}
	
	public static class mega {
		public int a;
		public int b;
		
		public mega(int A, int B) {
			a = A;
			b = B;
		}
		
		public int connects(mega Other) {
			if(this.a == Other.a)
				return this.b+Other.b;
			if(this.a == Other.b)
				return this.b+Other.a;
			if(this.b == Other.b)
				return this.a+Other.a;
			if(this.b == Other.a)
				return this.a+Other.b;
			
			return -1;
			
		}
	}
	
	
}

