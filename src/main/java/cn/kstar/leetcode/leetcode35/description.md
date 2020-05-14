#### 35. 搜索插入位置(Search Insert Position)

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

你可以假设数组中无重复元素。
You may assume no duplicates in the array.

**示例 1(Example 1):**

```
输入(Input): [1,3,5,6], 5
输出(Output): 2
```

**示例 2(Example 2):**

```
输入(Input): [1,3,5,6], 2
输出(Output): 1
```

**示例 3(Example 3):**

```
输入(Input): [1,3,5,6], 7
输出(Output): 4
```

**示例 4(Example 4):**

```
输入(Input): [1,3,5,6], 0
输出(Output): 0
```