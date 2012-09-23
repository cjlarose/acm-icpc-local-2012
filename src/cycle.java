import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class cycle {

	private Map<Integer, List<int[]>> map;

	public static void main(String[] args) {

		cycle mycycle = new cycle();
		mycycle.map = new HashMap<Integer, List<int[]>>();

		Scanner s = new Scanner(System.in);

		int problems = s.nextInt();
		int results[] = new int[problems];
		int num, size, max, temp, tempMax;

		for (int i = 0; i < problems; i++) {
			num = s.nextInt();
			size = s.nextInt();
			max = s.nextInt();

			List<int[]> perms = mycycle.get_permutations(size);
			for (int k = 0; k < perms.size(); k++) {
				int[] permutation = perms.get(k);
				temp = permutation[0];
				for (int j = 0; j <= permutation.length; j++) {
					if (temp == max) {
						results[i]++;
						break;
					}
					temp = permutation[temp - 1];
				}
			}
		}

		for (int i = 0; i < problems; i++) {
			System.out.println((i + 1) + " " + results[i]);
		}
	}

	private List<int[]> get_permutations(int n) {
		if (map.containsKey(n))
			return map.get(n);

		List<int[]> results = new ArrayList<int[]>();
		if (n == 1) {
			results.add(new int[] { 1 });
		} else {

			List<int[]> sub_r = get_permutations(n - 1); // [1,2],[2,1]
			for (int i = 0; i < sub_r.size(); i++) {
				int[] sub_list = sub_r.get(i); // [2,1]
				for (int j = 0; j < n; j++) {
					int[] result = new int[n]; // [3,2,1]
					for (int k = 0; k < j; k++) {
						result[k] = sub_list[k];
					}
					result[j] = n;
					for (int k = j + 1; k < n; k++) {
						result[k] = sub_list[k - 1];
					}
					results.add(result);
				}
			}

		}
		map.put(n, results);
		return results;
	}

}
