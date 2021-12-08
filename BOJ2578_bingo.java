import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class BOJ2578_bingo {
	private static int map[][] = new int[5][5];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 5; i++) {
			String str1[] = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(str1[j]);
			}
		}
		for (int i = 0; i < 5; i++) {
			String str1[] = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				if (checkLine(Integer.parseInt(str1[j])) >= 3) {
					System.out.println((5 * i) + (j + 1));
					return;
				}
			}
		}
		bw.flush();
	}

	private static int checkLine(int n) {
		int result = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == n)
					map[i][j] = 0;
			}
		}

		for (int i = 0; i < 5; i++) {
			boolean clearLine = true;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] > 0) {
					clearLine = false;
				}
			}
			if (clearLine)
				result++;
		}

		for (int i = 0; i < 5; i++) {
			boolean clearLine = true;
			for (int j = 0; j < 5; j++) {
				if (map[j][i] > 0) {
					clearLine = false;
				}
			}
			if (clearLine)
				result++;
		}
		for (int i = 0; i < 1; i++) {
			boolean clearLine = true;
			for (int j = 0; j < 5; j++) {
				if (map[j][j] > 0) {
					clearLine = false;
				}
			}
			if (clearLine)
				result++;
		}
		for (int i = 0; i < 1; i++) {
			boolean clearLine = true;
			for (int j = 0; j < 5; j++) {
				if (map[4 - j][j] > 0) {
					clearLine = false;
				}
			}
			if (clearLine)
				result++;
		}
		return result;
	}
}
