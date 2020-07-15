/**

 Given two binary trees, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are
 structurally identical and the nodes have the same value.

 Example 1:

 Input:     1         1
 / \       / \
 2   3     2   3

 [1,2,3],   [1,2,3]

 Output: true


 Example 2:

 Input:     1         1
 /           \
 2             2

 [1,2],     [1,null,2]

 Output: false


 Example 3:

 Input:     1         1
 / \       / \
 2   1     1   2

 [1,2,1],   [1,1,2]

 Output: false

 */

class IsSameTree {
    public static void main (String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);

        TreeNode t4 = new TreeNode(1);
        t4.right = new TreeNode(2);

        TreeNode t5 = new TreeNode(1);
        t5.left = new TreeNode(2);
        t5.right = new TreeNode(1);

        TreeNode t6 = new TreeNode(1);
        t6.left = new TreeNode(1);
        t6.right = new TreeNode(2);

        TreeNode t7 = new TreeNode(1);

        TreeNode t8 = null;

        System.out.println("Test 1 passed: " + isSameTree(t1, t2));
        System.out.println("test 2 passed: " + !isSameTree(t3, t4));
        System.out.println("Test 3 passed: " + !isSameTree(t5, t6));
        System.out.println("Test 4 passed: " + !isSameTree(t7, t8));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if(p==null||q==null){
            return false;
        }


        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}