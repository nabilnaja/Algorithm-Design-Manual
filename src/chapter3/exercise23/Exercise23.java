package chapter3.exercise23;

import dt.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Exercise23 {

    public static List<String> wordByPrefix(TreeNode<String> root, String prefix) {
        List<String> result = new ArrayList<>();
        if (root == null || prefix == null)
            return result;
        wordByPrefixHelper(root, result, prefix, prefix.length());
        return result;
    }

    public static void wordByPrefixHelper(TreeNode<String> root, List<String> result, String prefix, int prefixSize) {
        if (root == null)
            return;
        boolean foundNewRoot = false;
        if (prefix.equals(getPrefixFromWord(root.val, prefixSize))){
            result.add(root.val);
            foundNewRoot = true;
        }
        if (foundNewRoot || prefix.compareTo(getPrefixFromWord(root.val, prefixSize)) < 0){
            wordByPrefixHelper(root.left, result, prefix, prefix.length());
        }
        if (foundNewRoot || prefix.compareTo(getPrefixFromWord(root.val, prefixSize)) > 0){
            wordByPrefixHelper(root.right, result, prefix, prefix.length());
        }
    }

    private static String getPrefixFromWord(String prefix1, int size) {
        return prefix1.substring(0, Math.min(prefix1.length(), size));
    }
}
