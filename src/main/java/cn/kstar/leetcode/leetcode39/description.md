#### 39. 组合总和

给定一个**无重复元素**的数组 `candidates` 和一个目标数 `target` ，找出 `candidates` 中所有可以使数字和为 `target` 的组合。<br/>
Given a **set** of candidate numbers (`candidates`) (**without duplicates**) and a target number (`target`), find all unique combinations in candidates where the `candidate` numbers sums to `target`.

`candidates` 中的数字可以无限制重复被选取。<br/>
The **same** repeated number may be chosen from `candidates` unlimited number of times.

**说明(Note)：**

- 所有数字（包括 target）都是正整数。(All numbers (including target) will be positive integers.)
- 解集不能包含重复的组合。(The solution set must not contain duplicate combinations.)

**实例 1(Example 1)：**

```
输入(Input): candidates = [2,3,6,7], target = 7,
所求解集为(A solution set is):
[
  [7],
  [2,2,3]
]
```

**实例 2(Example 2)：**

```
输入(Input): candidates = [2,3,5], target = 8,
所求解集为(A solution set is):
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```