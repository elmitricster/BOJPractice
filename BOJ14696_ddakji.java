import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14696_ddakji {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int A[] = new int[5];
			int B[] = new int[5];
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			
			if (A[4] < B[4]) {
				System.out.println("B");
			} else if (A[4] > B[4]) {
				System.out.println("A");
			} else if (A[3] < B[3]) {
				System.out.println("B");
			} else if (A[3] > B[3]) {
				System.out.println("A");
			} else if (A[2] < B[2]) {
				System.out.println("B");
			} else if (A[2] > B[2]) {
				System.out.println("A");
			} else if (A[1] < B[1]) {
				System.out.println("B");
			} else if (A[1] > B[1]) {
				System.out.println("A");
			} else
				System.out.println("D");
		}
			
	}

}
