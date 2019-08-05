import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MeetingRooms {

	class Interval{
		
		int start;
		int end;
		
		public Interval(int start, int end) {
		
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String args[]) {

		int[][] intervals = {{2,7}};
		
		System.out.println(minMeetingRooms(helper(intervals)));
	}

	public static List<Interval> helper(int[][] intervals){
		
		List<Interval> ints = new LinkedList<>();
		MeetingRooms rooms = new MeetingRooms();
		
		for(int[] i : intervals){
			ints.add(rooms. new Interval(i[0],i[1]));
		}
		
		return ints;
		
	}
	public static int minMeetingRooms(List<Interval> intervals) {
		
		int res = intervals.size();
		LinkedList<Interval> merged = new LinkedList<>();
		
		Collections.sort(intervals, (a,b) -> (Integer.compare(a.start,b.start)));
		
		for(Interval i : intervals){
			
			if(merged.isEmpty() || merged.getLast().end < i.start){
				merged.add(i);

			}
			else{
				res--;
				merged.getLast().end = Math.max(merged.getLast().end, i.end);
			}
			
		}
		
		
		return res;

	}

}
