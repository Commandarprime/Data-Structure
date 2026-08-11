class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        int n = intervals.length;
        for(int i=0; i<n; i++){
        int[] last = result.get(result.size() - 1);
        int[] current = intervals[i];
        
        if(current[0] <= last[1]){
            last[1] = Math.max(last[1],current[1]);
        }else{
            result.add(current);
        }
        }
        return result.toArray(new int[result.size()][]);
           }
}