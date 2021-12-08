import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309_dwarf {
	static int N = 7;
	static int [] save = new int[7];
	static int[] arr = new int[9];
	
	private static void Combination(int cnt, int startIdx) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += save[i];
			}
			if (sum == 100) {
				Arrays.sort(save);
				for (int i = 0; i < N; i++) {
					System.out.println(save[i]);
				}
				return;
			}
			return;
		}
		
		for (int i = startIdx; i < arr.length; i++) {
			save[cnt] = arr[i];
			Combination(cnt+1, i+1);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Combination(0, 0);

	}

}
