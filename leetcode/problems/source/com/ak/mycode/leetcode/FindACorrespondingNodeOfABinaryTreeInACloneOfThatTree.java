package com.ak.mycode.leetcode;

import com.ak.mycode.tools.BinaryTreeUtil;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree extends BinaryTreeUtil {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree obj = new FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree();
        TreeNode original = addElement(input,0);
        TreeNode cloned = addElement(input,0);
        TreeNode target = getNode(original,3);
        System.out.println(target+ " Value : "+(target==null?"null":target.val));
        TreeNode result = obj.getTargetCopy(original,cloned,target);
        System.out.println(result+" Value : "+(result==null?"null":result.val));
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null || cloned==null || target==null) return null;

        if(treesAreEqual(cloned,target)) {
            return cloned;
        }
        else {
            TreeNode result = getTargetCopy(original.left,cloned.left,target);
            if(result==null) {
                result = getTargetCopy(original.right,cloned.right,target);
            }
            return result;
        }
    }

    private boolean treesAreEqual(final TreeNode cloned, final TreeNode target) {
        if(cloned==null && target==null) return true;
        if(cloned==null || target==null) return false;
        if(cloned.val.equals(target.val)) {
            return treesAreEqual(cloned.left,target.left) && treesAreEqual(cloned.right,target.right);
        }
        return false;
    }
}

//link - https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

/*
Question : -
    Given two binary trees original and cloned and given a reference to a node target in the original tree.
    The cloned tree is a copy of the original tree.
    Return a reference to the same node in the cloned tree.
    Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

Constraints : -

    The number of nodes in the tree is in the range [1, 104].
    The values of the nodes of the tree are unique.
    target node is a node from the original tree and is not null.

 */

/*
Example : -
    Input: tree = [7,4,3,null,null,6,19], target = 3
        Visualize :
            7
            ├──4
            └──3
               ├──6
               └──19
    Output: 3
    Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.

 */

//level - medium

//algorithms used - dfs

//available in lists - tree-tag

//Time Complexity - O(n)

//Space Complexity - O(1)
