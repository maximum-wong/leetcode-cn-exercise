package kstar.leetcode;

/**
 * <h6>移除元素</h6>
 * 
 * <p>给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <br/>不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <br/>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。</p>
 * <pre><b>Examples:</b>
 * &nbsp;&nbsp;给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * &nbsp;&nbsp;你不需要考虑数组中超出新长度后面的元素。
 * 
 * &nbsp;&nbsp;给定 nums = [0,1,2,2,3,0,4,2], val = 2,函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * &nbsp;&nbsp;注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 * </pre>
 */
public class LeetCode27 {

    /**
     * <h6>双指针法</h6>
     * 
     * <p>使用双指针法，右指针指向的元素等于指定元素就跳过。</p>
     * @param  array
     * @param  value
     * @return int
     */
    public int removeElement(int[] array, int value) {
        // 左指针
        int index = 0;
        for (int i = 0, length = array.length; i < length; i++) {
            // 右指针所指的元素不等于指定元素
            if (array[i] != value) {
                array[index++] = array[i];
            }
        }
        return index;
    }
}
