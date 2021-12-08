import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158_Josephus {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		sb.append("<");
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(q.size() != 1) {
			for (int j = 0; j < K; j++) {
				if(j == K-1) {
					sb.append(q.poll() + ", ");
				} else {
					q.offer(q.poll());
				}
			}
		}
		
		sb.append(q.poll() + ">");
		System.out.println(sb);
	}

}
