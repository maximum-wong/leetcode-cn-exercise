#### 75. 颜色分类(Sort Colors)

给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。<br/>
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。<br/>
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

**注意:**<br/>
不能使用代码库中的排序函数来解决这道题。<br/>
**Note:** You are not suppose to use the library's sort function for this problem.

**示例(Example):**

```
输入(Input): [2,0,2,1,1,0]
输出(Output): [0,0,1,1,2,2]
```

**进阶：**

- 一个直观的解决方案是使用计数排序的两趟扫描算法。<br/>
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
- 你能想出一个仅使用常数空间的一趟扫描算法吗？

**Follow up: **

- A rather straight forward solution is a two-pass algorithm using counting sort.<br/>
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
- Could you come up with a one-pass algorithm using only constant space?