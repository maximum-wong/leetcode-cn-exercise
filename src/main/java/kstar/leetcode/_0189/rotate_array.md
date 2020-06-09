#### 189. 旋转数组(Rotate Array)

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。<br/>
Given an array, rotate the array to the right by k steps, where k is non-negative.

**Follow up:**

- Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
- Could you do it in-place with O(1) extra space?

**示例 1(Example 1):**

```
输入: [1,2,3,4,5,6,7] 和 k = 3
Input: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
Output: [5,6,7,1,2,3,4]
解释:
Explanation:
向右旋转 1 步: [7,1,2,3,4,5,6]
rotate 1 steps to the right: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

**示例 2(Example 1):**

```
输入: [-1,-100,3,99] 和 k = 2
Input: nums = [-1,-100,3,99], k = 2
输出: [3,99,-1,-100]
Output: [3,99,-1,-100]
解释: 
Explanation: 
向右旋转 1 步: [99,-1,-100,3]
rotate 1 steps to the right: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
rotate 2 steps to the right: [3,99,-1,-100]
```

**说明:**

- 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
- 要求使用空间复杂度为 O(1) 的 **原地** 算法。

**Constraints:**

- `1 <= nums.length <= 2 * 10^4`
- It's guaranteed that `nums[i]` fits in a 32 bit-signed integer.
- `k >= 0`