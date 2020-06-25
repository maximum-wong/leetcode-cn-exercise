#### 152. 乘积最大子数组(Maximum Product Subarray)

给你一个整数数组 `nums` ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。<br/>
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

**示例 1(Example 1):**

```
输入(Input): [2,3,-2,4]
输出(Output): 6
解释(Explanation): 子数组 [2,3] 有最大乘积 6。([2,3] has the largest product 6.)
```

**示例 2(Example 2):**

```
输入(Input): [-2,0,-1]
输出(Output): 0
解释(Explanation): 结果不能为 2, 因为 [-2,-1] 不是子数组。(The result cannot be 2, because [-2,-1] is not a subarray.)
```