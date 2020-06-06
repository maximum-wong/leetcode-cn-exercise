#### 45. 跳跃游戏 II(Jump Game II)

给定一个非负整数数组，你最初位于数组的第一个位置。<br/>
Given an array of non-negative integers, you are initially positioned at the first index of the array.

数组中的每个元素代表你在该位置可以跳跃的最大长度。<br/>
Each element in the array represents your maximum jump length at that position.

你的目标是使用最少的跳跃次数到达数组的最后一个位置。<br/>
Your goal is to reach the last index in the minimum number of jumps.

**示例(Example):**

```
输入(Input): [2,3,1,1,4]
输出(Output): 2
解释(Explanation): 跳到最后一个位置的最小跳跃数是 2。(The minimum number of jumps to reach the last index is 2.)
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
```

**说明(Note):**

假设你总是可以到达数组的最后一个位置。<br/>
You can assume that you can always reach the last index.