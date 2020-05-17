#### 33. 搜索旋转排序数组(Maximal Square)

假设按照升序排序的数组在预先未知的某个点上进行了旋转。<br/>
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

( 例如，数组 `[0,1,2,4,5,6,7]` 可能变为 `[4,5,6,7,0,1,2]` )。<br/>
(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 `-1` 。<br/>
You are given a target value to search. If found in the array return its index, otherwise return `-1`.

你可以假设数组中不存在重复的元素。<br/>
You may assume no duplicate exists in the array.

你的算法时间复杂度必须是 O(log n) 级别。<br/>
Your algorithm's runtime complexity must be in the order of O(log n).

**示例 1(Example 1):**

```
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
```

**示例 2(Example 2):**

```
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
```