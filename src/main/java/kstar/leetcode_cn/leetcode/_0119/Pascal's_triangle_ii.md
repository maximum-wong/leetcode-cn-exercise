#### 杨辉三角 II(Pascal's Triangle II)

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。<br/>
Given a non-negative index k where k ≤ 33, return the k<sup>th</sup> index row of the Pascal's triangle.

Note that the row index starts from 0.

![pascal triangle](PascalTriangleAnimated2.gif)

<small>在杨辉三角中，每个数是它左上方和右上方的数的和。</small><br/>
<small>In Pascal's triangle, each number is the sum of the two numbers directly above it.</small>

**示例(Example):**

```
输入(Input): 3
输出(Output): [1,3,3,1]
```

**进阶(Follow up)：**

你可以优化你的算法到 O(k) 空间复杂度吗？<br/>
Could you optimize your algorithm to use only O(k) extra space?