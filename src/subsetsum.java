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
			
			List<Double> available = new ArrayList<Double>();
			for (int i = 0 ; i < num_available; i ++)
				available.add(s.nextDouble());
			
			List<Double> sums = possible_sums(available);
			Collections.sort(sums);
			
			//for (int n: sums)
			//	System.out.println(n);
			
			double optimal = -1;
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
				System.out.println((int) optimal);
		}
	}
	
	private static List<Double> possible_sums(List<Double> nums) {
		List<Double> result = new ArrayList<Double>();
		if (nums.size() == 1)
			result.add(nums.get(0));
		else { 
			result.add(nums.get(0));
			List<Double> ps = possible_sums(nums.subList(1, nums.size()));
			result.addAll(ps);
			for (int i = 0; i < ps.size(); i++)
				result.add(nums.get(0) + ps.get(i));
		}
		return result;
	}

}