/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0){
            return true;
        }

        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval meeting : intervals){
            if(!pq.isEmpty() && pq.peek() <= meeting.start){
                pq.poll();
            }

            pq.add(meeting.end);
        }

        return pq.size() == 1 ? true : false;
    }
}
