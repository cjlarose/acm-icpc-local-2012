import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cycle {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int problems = s.nextInt();
		int results[] = new int[problems];
		int num, size, max, temp, tempMax;
		
		for(int i = 0; i < problems; i++) {
			num = s.nextInt();
			size = s.nextInt();
			max = s.nextInt();
			
			List<List<Integer>> perms = get_permutations(size);
			for (int k = 0; k < perms.size(); k++) {
				List<Integer> permutation = perms.get(k);
				temp = permutation.get(0);
				for(int j = 0; j <= permutation.size(); j++) {
					if(temp == max) {
						results[i]++;
						break;
					}
					temp = permutation.get(temp-1);
				}
			}
		}
		
		for(int i = 0; i < problems; i++) {
			System.out.println((i+1) + " " + results[i]);
		}
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
