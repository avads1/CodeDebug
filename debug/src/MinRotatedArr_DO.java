/*

Suppose an array sorted in ascending order is rotated at 
some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0

*/

class MinRotatedArr_DO {
    public static void main (String[] args) {
        int[] a1 = {3, 4, 5, 1, 2};
        int[] a2 = {4, 5, 6, 7, 0, 1, 2};
        int[] a3 = {1, 2, 3};
        int[] a4 = {1};
        int[] a5 = {4, 5, 6, 1};

        System.out.println("Test 1 Passed: " + (findMin(a1) == 1));
        System.out.println("Test 2 Passed: " + (findMin(a2) == 0));
        System.out.println("Test 3 Passed: " + (findMin(a3) == 1));
        System.out.println("Test 4 Passed: " + (findMin(a4) == 1));
        System.out.println("Test 5 Passed: " + (findMin(a5) == 1));
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start+end) / 2;

            if (nums[mid] > nums[end])
                // search second half of array
                start = mid;
            else
                // search first half of array
                end = mid;
        }

        return nums[start];
    }

}