/**

 problem : https://leetcode.com/problems/reverse-string-ii/description/

 Given a string and an integer k,
 you need to reverse the first k characters for every 2k characters
 counting from the start of the string.
 If there are less than k characters left, reverse all of them.
 If there are less than 2k but greater than or equal to k characters,
 then reverse the first k characters and left the other as original.

 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"

 */
class ReverseStr {
    public static void main (String[] args) {
        boolean test1 = reverseStr("abc", 3).equals("cba");
        boolean test2 = reverseStr("abcdefg", 2).equals("bacdfeg");
        boolean test3 = reverseStr("123456", 3).equals("321456");
        boolean test4 = reverseStr("123456789", 3).equals("321456987");
        boolean test5 = reverseStr("ab", 5).equals("ba");
        boolean test6 = reverseStr("abcd", 9).equals("ba");
        System.out.println("Test 1 passed: " + test1);
        System.out.println("Test 2 passed: " + test2);
        System.out.println("Test 3 passed: " + test3);
        System.out.println("Test 4 passed: " + test4);
        System.out.println("Test 5 Passed: " + test5);

    }

    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if(s.length()<k)
            k=k%s.length();
        System.out.println(k);
        if(k==1){
            reverseSegment(arr, 0, s.length()-1);
            return String.valueOf(arr);
        }
        for (int i = 0; i < n; i += 2 * k) {
            reverseSegment(arr, i, i + k-1);
        }

        return String.valueOf(arr);
    }

    private static void reverseSegment(char[] arr, int start, int end) {
        //System.out.println(start+" "+end);
        while (start<arr.length && end>=0 && start <= end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}