#### 57. 插入区间(Insert Interval)

给出一个无重叠的 ，按照区间起始端点排序的区间列表。<br/>
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。<br/>
You may assume that the intervals were initially sorted according to their start times.

**示例 1(Example 1):**

```
输入(Input): intervals = [[1,3],[6,9]], newInterval = [2,5]
输出(Output): [[1,5],[6,9]]
```

**示例 2(Example 2):**

```
输入(Input): intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出(Output): [[1,2],[3,10],[12,16]]
解释(Explanation): 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。(Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].)
```

**NOTE:** input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
