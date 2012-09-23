import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class subsetsum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num_cases = s.nextInt();
		
		for (int j = 0; j < num_cases; j++) {
			int desired = s.nextInt();
			int num_available = s.nextInt();
			
			List<Long> available = new ArrayList<Long>();
			for (int i = 0 ; i < num_available; i ++)
				available.add(s.nextLong());
			
			List<Long> sums = possible_sums(available);
			Collections.sort(sums);
			
			//for (int n: sums)
			//	System.out.println(n);
			
			long optimal = -1L;
			int i = 0;
			while (i < sums.size()) {
				if (sums.get(i) >= desired) {
					optimal = sums.get(i);
					break;
				}
				i++;
			}
			
			if (optimal == -1)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(optimal);
		}
	}
	
	private static List<Long> possible_sums(List<Long> nums) {
		List<Long> result = new ArrayList<Long>();
		if (nums.size() == 1)
			result.add(nums.get(0));
		else { 
			result.add(nums.get(0));
			List<Long> ps = possible_sums(nums.subList(1, nums.size()));
			result.addAll(ps);
			for (int i = 0; i < ps.size(); i++)
				result.add(nums.get(0) + ps.get(i));
		}
		return result;
	}

}