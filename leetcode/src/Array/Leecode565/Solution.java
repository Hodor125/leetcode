package Array.Leecode565;


public class Solution {
    public static void main(String[] args) {
        int[] arr = {5,4,0,3,1,6,2};

        System.out.println(new Solution().arrayNesting(arr));

    }

    //因为不可能重复都是一个个闭环
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if(!visited[i]){
                int start= nums[i];
                do{
                    start = nums[start];
                    count++;
                }while(start != nums[i]);
                res = Math.max(count,res);
            }
        }
        return res;
    }
}
