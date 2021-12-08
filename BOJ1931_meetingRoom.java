import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931_meetingRoom {
	
	static class Meeting implements Comparable<Meeting>{
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			int value = this.end - o.end;
			if(value != 0) return value; // 종료시간이 다르면
			
			// 종료시간이 같다면 시작시간이 빠른 순서로
			return this.start - o.start; 
		}

		/*@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}*/
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		/*for (Meeting m : getSchedule(meetings)) {
			System.out.println(m);
		}*/

		System.out.println(getSchedule(meetings).size());
	}
	
	static ArrayList<Meeting> getSchedule(Meeting[] meetings) {
		ArrayList<Meeting> list = new ArrayList<Meeting>();
		
		Arrays.sort(meetings); // 종료시간 기준 오름차순 정렬
		list.add(meetings[0]); // 첫 회의 추가
		
		for (int i = 1, size = meetings.length; i < size; i++) {
			if(list.get(list.size()-1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		return list;
	}

}
