import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_top {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<int[]> stk = new Stack<>();
		
		for (int i = 1; i <= n; i++) {
			int top = Integer.parseInt(st.nextToken());
			while(!stk.isEmpty()) {
				if(stk.peek()[1] >= top) {
					System.out.print(stk.peek()[0] + " ");
					break;
				}
				stk.pop();
			}
			if (stk.isEmpty()) {
				System.out.print("0 ");
			}
			stk.push(new int[] {i, top});
		}
	}
}
