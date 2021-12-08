import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2605_lineUP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int[] line = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 1; i <= N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 1; k <= N; k++) {
			if(line[k] == 0) {
				list.add(k);
			} else {
				list.add(k-1-line[k], k);
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
