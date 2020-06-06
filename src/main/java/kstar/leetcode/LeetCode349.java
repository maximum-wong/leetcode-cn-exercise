package kstar.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <h6>Intersection of Two Arrays</h6>
 * 
 * <p>给定两个数组，编写一个函数来计算它们的交集。
 * <br/>说明:<li>输出结果中的每个元素一定是唯一的。</li><li>我们可以不考虑输出结果的顺序。</li></p>
 * <pre><b>Examples:</b>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]; Output: [2]
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]; Output: [9,4]
 * </pre>
 */
public class LeetCode349 {

    /**
     * <h6>查表法</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
     * <p>用一个容器保存第一个数组中的不重复元素，遍历第二个数组，遇到相同的元素，存入结果集中，并返回</p>
     * @param  array1
     * @param  array2
     * @return Set<Integer>
     */
    public Set<Integer> getIntersection(int[] array1, int[] array2) {
        Set<Integer> ret = new HashSet<>();
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            return ret;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0, length = array1.length; i < length; i++) {
            Integer element = array1[i];
            set.add(element);
        }
        for (int i = 0, length = array2.length; i < length; i++) {
            Integer element = array2[i];
            if (set.contains(element)) {
                ret.add(element);
            }
        }
        return ret;
    }
}
