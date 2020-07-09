package kstar.leetcode_cn.leetcode._0345;

/**
 * <h6>双指针法</h6>
 */
public class Solution {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            if (isVowel(array[left]) && isVowel(array[right])) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            } else if (isVowel(array[left])) {
                right--;
            } else if (isVowel(array[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return new String(array);
    }

    private boolean isVowel(char ch) {
        if (ch == 'A' || ch == 'O' || ch == 'E' || ch == 'I' || ch == 'U' 
                || ch == 'a' || ch == 'o' || ch == 'e'|| ch == 'i' || ch == 'u') {
            return true;
        }
        return false;
    }
}
