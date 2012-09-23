import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class chris {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for (List<Integer> i: p) {
			String p2 = "";
			for (int j = 0; j < i.size(); j++) {
				p2 += i.get(j);
			}
			System.out.println(p2);
		}
	}
	
	private static List<List<Integer>> possible_permutations(int n) {
		List<List<Integer>> results = new ArrayList<List<Integer>>(); 
		if (n == 1) {
			for (int i = 1; i <= 9; i++) {
				List<Integer> r2 = new ArrayList<Integer>();
				r2.add(i);
				results.add(r2);
			}
		} else {
			for (int i = 1; i <= 9; i++) {
				List<List<Integer>> sub_perms = possible_permutations(n-1);
				for (int j = 0; j < sub_perms.size(); j++) {
					// merge
					List<Integer> r2 = new ArrayList<Integer>();
					r2.add(i);
					for (int k =0; k < sub_perms.get(j).size(); k++) {
						r2.add(sub_perms.get(j).get(k));
					}
					results.add(r2);
				}
			}
			
			// filter stuff out
			List<List<Integer>> new_results = new ArrayList<List<Integer>>();
			for (int i = 0; i < results.size(); i++) {
				List<Integer> result = results.get(i);
				boolean remove = false;
				for (int j = 0; j < result.size(); j++) {
					if (result.get(j) > n) {
						remove = true;
						break;
					}
				}
				if (!remove)
					new_results.add(result);
			}
			return new_results;
		}
		
		return results;
		
	}
}
