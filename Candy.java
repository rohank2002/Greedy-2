// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
      if(ratings == null || ratings.length==0) return 0;
      int[] candy = new int[ratings.length];
      //left pass
        for(int i = 0;i<ratings.length;i++){
            candy[i]=1;
        }
        for(int i = 1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i] = 1+candy[i-1];
            }
        }
        int count =0;
        //right pass
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i] = Math.max(candy[i],1+candy[i+1]);
                
            }
        }
        
        for(int counts:candy ){
            count= count+counts;
        }
        
        return count;
    }
}