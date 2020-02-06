package cn.kstar.leetcode;

/**
 * <h6>删除排序数组中的重复项</h6>
 * 
 * <p>给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <br/>不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。</p>
 * <pre>
 * <b>Examples:</b>
 * 给定数组 nums = [1,1,2], 
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * </pre>
 */
public class LeetCode26 {

	/**
	 * <h6>双指针法</h6>
	 * 
	 * <p>使用双指针法，左指针和右指针指向相同的元素就跳过。
	 * <br/>不需要关心遍历完之后由于删除重复元素带来的length变化，因为左指针的位置就是数组长度。</p>
	 * @param  array
	 * @return int
	 */
	public int removeDuplicates(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		// 左指针
		int index = 0;
		for (int i = 0, length = array.length; i < length; i++) {
			// 如果右指针与左指针所指的元素不相同
			if (array[index] != array[i]) {
				index++;
				array[index] = array[i];
			}
		}
		index += 1;
		return index;
	}
}
