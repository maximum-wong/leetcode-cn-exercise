#### 38. 外观数列(Sudoku Solver)

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：<br/>
The count-and-say sequence is the sequence of integers with the first five terms as following:

```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```

`1` 被读作  `"one 1"`  (`"一个一"`) , 即 `11`。<br/>
`1` is read off as `"one 1"` or `11`.<br/>
`11` 被读作 `"two 1s"` (`"两个一"`）, 即 `21`。<br/>
`11` is read off as `"two 1s"` or `21`.<br/>
`21` 被读作 `"one 2"`,  `"one 1"` （`"一个二"` ,  `"一个一"`) , 即 `1211`。<br/>
`21` is read off as `"one 2`, then `one 1"` or `1211`.

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。<br/>
Given an integer n where 1 ≤ n ≤ 30, generate the n<sup>th</sup> term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

注意：整数序列中的每一项将表示为一个字符串。<br/>
Note: Each term of the sequence of integers will be represented as a string.

**示例 1(Example 1):**

```
输入(Input): 1
输出(Output): "1"
解释(Explanation)：这是一个基本样例。
This is the base case.
```

**示例 2:**

```
输入(Input): 4
输出(Output): "1211"
解释(Explanation)：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
```
