#### 30. 串联所有单词的子串(Substring with Concatenation of All Words)

给定一个字符串 **s** 和一些长度相同的单词 **words**。找出 **s** 中恰好可以由 **words** 中所有单词串联形成的子串的起始位置。<br/>
You are given a string, **s**, and a list of words, **words**, that are all of the same length. Find all starting indices of substring(s) in **s** that is a concatenation of each word in **words** exactly once and without any intervening characters.

注意子串要与 **words** 中的单词完全匹配，中间不能有其他字符，但不需要考虑 **words** 中单词串联的顺序。

**示例 1(Example 1)：**

```
输入(Input)：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出(Output)：[0,9]
解释(Explanation)：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
输出的顺序不重要, [9,0] 也是有效答案。
The output order does not matter, returning [9,0] is fine too.
```

**示例 2(Example 2)：**

```
输入(Input)：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出(Output)：[]
```