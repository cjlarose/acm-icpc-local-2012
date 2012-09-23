import java.util.Iterator;
import java.util.Scanner;

public class cycle {

	public static void main(String[] args) {

		cycle mycycle = new cycle();

		Scanner s = new Scanner(System.in);

		int problems = s.nextInt();
		int results[] = new int[problems];
		int num, size, max, temp;

		for (int i = 0; i < problems; i++) {
			num = s.nextInt();
			size = s.nextInt();
			max = s.nextInt();

			permutation_list perms = mycycle.new permutation_list(size);
			while (perms.hasNext()) {
				int[] permutation = perms.next();
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

	private class permutation_list implements Iterator<int[]> {

		int[] current;
		boolean exhausted = false;
		boolean started = false;
		int size;

		public permutation_list(int n) {
			this.size = n;
		}

		@Override
		public boolean hasNext() {
			return !this.exhausted;
		}

		@Override
		public int[] next() {
			if (started == false) {
				this.current = new int[size];
				for (int i = 0; i < size; i++)
					this.current[i] = i + 1;
				this.started = true;
				return this.current;
			}
			
			int[] new_digits = current.clone();

			int n = new_digits.length - 1;

			int j = n - 1;
			while (current[j] > current[j + 1])
				j--;

			int k = n;
			while (current[j] > current[k])
				k--;

			int temp = new_digits[j];
			new_digits[j] = new_digits[k];
			new_digits[k] = temp;

			int r = n;
			int s = j + 1;

			while (r > s) {
				temp = new_digits[r];
				new_digits[r] = new_digits[s];
				new_digits[s] = temp;
				r--;
				s++;
			}

			int j1 = new_digits.length - 2;
			while (new_digits[j1] > new_digits[j1 + 1]) {
				if (j1 == 0) {
					this.exhausted = true;
					break;
				}
				j1--;
			}
			current = new_digits;
			return new_digits;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

}
