import java.util.Arrays;
import java.util.HashMap;

/*
暴力法
 */
public class twonum_1 {
    public int[] twoSum1(int[] nums, int target) throws IllegalAccessException {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i])
                    return new int[]{i ,j};
            }
        }
        throw new IllegalArgumentException("NO tow sum solution");
    }

    public int[] twoSum2(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] , i);
        }

        for (int i = 0; i < nums.length; i++) {
            int element = target - nums[i];
            if(map.containsKey(element) && map.get(element) != i){
                return new int[] {i , map.get(element)};
            }
        }
        throw new IllegalArgumentException();
    }

    public int[] twoSum3(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int element = target - nums[i];
            if(map.containsKey(element)){
                return new int[]{i, map.get(element)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) throws IllegalAccessException {
        int[] num = new int[]{1,3,4,6};
        twonum_1 demotwo = new twonum_1();
        System.out.println(Arrays.toString(demotwo.twoSum3(num,4)));

    }
}
