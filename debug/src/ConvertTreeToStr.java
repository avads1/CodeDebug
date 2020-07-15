/*
You need to construct a string consists of parenthesis and
integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()".
And you need to omit all the empty parenthesis pairs that don't
affect the one-to-one mapping relationship between the string and
the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originaly it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".

Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the
one-to-one mapping relationship between the input and the output.
*/


class ConvertTreeToStr {
    public static void main (String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);

        TreeNode t2 = new TreeNode(1);

        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.right = new TreeNode(3);

        TreeNode t4 = new TreeNode(1);
        t4.left = new TreeNode(2);
        t4.right = new TreeNode(3);
        t4.left.right = new TreeNode(4);


        System.out.println("Test 1 passed: " + tree2str(t1).equals("1(2(4))(3)"));
        System.out.println("Test 1 debug: " +tree2str(t1)+" Expected "+"1(2(4))(3)");
        System.out.println("Test 2 passed: " + tree2str(t2).equals("1"));
        System.out.println("Test 2 debug: " +tree2str(t2)+" Expected "+"1");
        System.out.println("Test 3 passed: " + tree2str(t3).equals("1(2)(3)"));
        System.out.println("Test 3 debug: " +tree2str(t3)+" Expected "+"1(2)(3)");
        System.out.println("Test 4 passed: " + tree2str(t4).equals("1(2()(4))(3)"));
        System.out.println("Test 4 debug: " +tree2str(t4)+" Expected "+"1(2()(4))(3)");

    }


    public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }

        String left = "(" + tree2str(t.left) + ")";
        String right = "(" + tree2str(t.right) + ")";
        if(t.right==null){
            right="";
        }
        return t.val + "" + left + right;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}