import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers and an integer k,
 find out whether there are two distinct indices i and j
 in the array such that nums[i] = nums[j]
 and the absolute difference between i and j is at most k.

 Example 1:
 Input: nums = [1,2,3,1], k = 3
 Output: true

 Example 2:
 Input: nums = [1,0,1,1], k = 1
 Output: true

 Example 3:
 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false
 */

public class ContainsDuplicate {
    public static void main (String[] args) {

        int[] testSet1 = {1, 2, 3, 1};
        int[] testSet2 = {1, 0, 1, 1};
        int[] testSet3 = {1, 2, 3, 1, 2, 3};
        int[] testSet4 = {1,2,3,4,5,6,7,8,9,9};
        boolean test1 = containsNearbyDuplicate(testSet1, 3);
        boolean test2 = containsNearbyDuplicate(testSet2, 1);
        boolean test3 = !containsNearbyDuplicate(testSet3, 2);
        boolean test4 = containsNearbyDuplicate(testSet4, 3);

        System.out.println("test 1 passed: " + test1);
        System.out.println("test 2 passed: " + test2);
        System.out.println("test 3 passed: " + test3);
        System.out.println("test 4 passed: " + test4);

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }
}
