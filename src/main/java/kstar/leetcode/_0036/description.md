#### 36. 有效的数独(Valid Sudoku)

判断一个 9x9 的数独是否有效。只需要**根据以下规则**，验证已经填入的数字是否有效即可。<br/>
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated **according to the following rules**:

1. 数字 `1-9` 在每一行只能出现一次。(Each row must contain the digits `1-9` without repetition.)
2. 数字 `1-9` 在每一列只能出现一次。(Each column must contain the digits `1-9` without repetition.)
3. 数字 `1-9` 在每一个以粗实线分隔的 `3x3` 宫内只能出现一次。(Each of the 9 `3x3` sub-boxes of the grid must contain the digits `1-9` without repetition.)

![](250px-Sudoku-by-L2G-20050714.svg.png)

上图是一个部分填充的有效的数独。<br/>
A partially filled sudoku which is valid.

数独部分空格内已填入了数字，空白格用 `'.'` 表示。<br/>
The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.

**示例 1(Example 1):**

```
输入(Input):
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出(Output): true
```

**示例 2(Example 2):**

```
输入(Input):
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出(Output): false
解释(Explanation): 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。(Same as Example 1, except with the 5 in the top left corner being )
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。( modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
```

**说明:**

- 一个有效的数独（部分已被填充）不一定是可解的。
-  只需要根据以上规则，验证已经填入的数字是否有效即可。
-  给定数独序列只包含数字 1-9 和字符 '.' 。
-  给定数独永远是 9x9 形式的。
