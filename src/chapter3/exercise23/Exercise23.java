package chapter3.exercise23;

import dt.TreeNodeString;

import java.util.ArrayList;
import java.util.List;

public class Exercise23 {

    public static List<String> wordByPrefix(TreeNodeString root, String prefix) {
        List<String> result = new ArrayList<>();
        if (root == null || prefix == null)
            return result;
        wordByPrefix(root, result, prefix, prefix.length());
        return result;
    }

    public static void wordByPrefix(TreeNodeString root, List<String> result, String prefix, int prefixSize) {
        if (root == null)
            return;
        boolean foundNewRoot = false;
        if (prefix.equals(getPrefixFromWord(root.val, prefixSize))){
            result.add(root.val);
            foundNewRoot = true;
        }
        if (foundNewRoot || prefix.compareTo(getPrefixFromWord(root.val, prefixSize)) < 0){
            wordByPrefix(root.left, result, prefix, prefix.length());
        }
        if (foundNewRoot || prefix.compareTo(getPrefixFromWord(root.val, prefixSize)) > 0){
            wordByPrefix(root.right, result, prefix, prefix.length());
        }
    }

    private static String getPrefixFromWord(String prefix1, int size) {
        return prefix1.substring(0, Math.min(prefix1.length(), size));
    }
}
