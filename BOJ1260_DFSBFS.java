import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_DFSBFS {
	static int N, M, V;
	static ArrayList<Integer>[] list;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		check = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		check = new boolean[N+1];
		bfs(V);
		System.out.println();
	}
	
	static void dfs(int num) {
		if (check[num]) {
			return;
		}
		check[num] = true;
		System.out.print(num + " ");
		for (int n : list[num]) {
			if (!check[n]) {
				dfs(n);
			}
		}
	}
	
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		check[num] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");
			for (int y : list[x]) {
				if (!check[y]) {
					check[y] = true;
					q.add(y);
				}
			}
		}
	}
	
	
	/*public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		boolean check[] = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}
		
		dfs(list, check, V);
		
		Arrays.fill(check, false);
		System.out.println();
		
		bfs(list, check, V);
	}
	
	static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] check, int v) {
		if (check[v] == true)
			return;
		
		check[v] = true;
		System.out.print(v + " ");
		
		for (int i = 0; i < list.get(v).size(); i++) {
			if(!check[list.get(v).get(i)])
				dfs(list, check, list.get(v).get(i));
		}
	}
	
	static void bfs(ArrayList<ArrayList<Integer>> list, boolean[] check, int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		check[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			
			for (int i = 0; i < list.get(v).size(); i++) {
				if(!check[list.get(v).get(i)]) {
					q.add(list.get(v).get(i));
					check[list.get(v).get(i)] = true;
				}
			}	
		}
	}*/

}
