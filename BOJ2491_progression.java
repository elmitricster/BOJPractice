import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2491_progression {
	static int[] arr;

	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 1;
		int ans = 1;
		
		for (int i = 1; i < N; i++) {
			if (arr[i-1] >= arr[i])
				cnt++;
			else
				cnt = 1;
			
			if(ans < cnt)
				ans = cnt;
		}
		
		cnt = 1;
		
		for (int i = 1; i < N; i++) {
			if (arr[i-1] <= arr[i])
				cnt++;
			else
				cnt = 1;
			
			if(ans < cnt)
				ans = cnt;
		}
		
		System.out.println(ans);

	}

}
