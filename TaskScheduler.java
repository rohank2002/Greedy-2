// Time Complexity :O(N)
// Space Complexity :O(1)~26characters
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int leastInterval(char[] tasks, int n) {
      if(tasks == null || tasks.length == 0) return 0;
    Map<Character,Integer> map = new HashMap<>();
        for(Character c: tasks){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        
        
        int maxfreq =-1;
        int count =0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()>maxfreq){
                maxfreq = entry.getValue();
                count =1;
            }
            else if(entry.getValue() == maxfreq){
                count++;
            }
        }
        
        
        int partition  = maxfreq-1;
        int emptySlot = partition*(n-(count-1));
        if(emptySlot<0) emptySlot =0;
        int pending = tasks.length - count*maxfreq;
        int idle = emptySlot-pending;
        
        if(idle<0)idle = 0;
        
        return tasks.length+idle;
    }
}