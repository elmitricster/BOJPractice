import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158_ant {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int q = Integer.parseInt(st.nextToken()); // 컬럼
		int p = Integer.parseInt(st.nextToken()); // 로우
		int t = Integer.parseInt(br.readLine()); // 시간
		
		int x = (q+t) % (2*w);
		int y = (p+t) % (2*h);
		
		x = w - Math.abs(w - x);
		y = h - Math.abs(h - y);
		
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	}
}


