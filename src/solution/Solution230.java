package solution;

import java.util.*;

//Given the root of a binary search tree, and an integer k, return the kth (1-in
//dexed) smallest element in the tree.
//
//
// Example 1:
//
//
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
//
//
// Example 2:
//
//
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is n.
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
//
//
//
//Follow up: If the BST is modified often (i.e., we can do insert and delete ope
//rations) and you need to find the kth smallest frequently, how would you optimiz
//e? Related Topics Binary Search Tree
// 👍 3816 👎 86


import com.sun.tracing.dtrace.ArgsAttributes;
import common.model.TreeNode;

/**
 * @author Zhijian.H
 * @since 2021/5/3 下午11:47
 */
public class Solution230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> minValList = new ArrayList<>();
        inorder(root, minValList, k);
        if (minValList.size() < k) {
            return -1;
        }
        return minValList.get(k - 1);
    }


    public void inorder(TreeNode root, List<Integer> arr, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, arr, k);
        arr.add(root.val);
        if (arr.size() >= k) {
            return;
        }
        inorder(root.right, arr, k);
    }

    public static void main(String[] args) {
        Solution230 solution = new Solution230();
        System.out.println(solution.kthSmallest(new TreeNode(4), 1));
    }
}
