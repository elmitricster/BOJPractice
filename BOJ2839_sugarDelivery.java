import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2839_sugarDelivery {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while (N%5 != 0) {
			N -= 3;
			if (N < 0) {
				cnt = -1;
				break;
			} else
				cnt++;
		}
		
		if (N > 0)
			cnt += N / 5;
		
		System.out.println(cnt);
	}

}
