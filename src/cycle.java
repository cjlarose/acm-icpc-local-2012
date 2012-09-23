import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cycle {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		List<List<Integer>> perms = get_permutations(3);
		for (List<Integer> p: perms) {
			String str = "";
			for (Integer n: p)
				str += n;
			System.out.println(str);
		}
		
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
	
	private static List<List<Integer>> get_permutations(int n) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (n == 1) {
			List<Integer> result = new ArrayList<Integer>();
			result.add(1);
			results.add(result);
		} else {
			List<List<Integer>> sub_r = get_permutations(n-1); // [1,2],[2,1]
			for (int i = 0; i < sub_r.size(); i++) {
				List<Integer> sub_list = sub_r.get(i); // [2,1]
				for (int j = 0; j < n; j++) {
					List<Integer> result = new ArrayList<Integer>(); // [3,2,1]
					result.addAll(sub_list);
					result.add(j, n);
					results.add(result);
				}
			}
		}
		return results;
	}
	
	

}
