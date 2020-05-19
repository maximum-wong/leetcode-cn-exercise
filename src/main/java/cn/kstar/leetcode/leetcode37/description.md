#### 37. 解数独(Sudoku Solver)

编写一个程序，通过已填充的空格来解决数独问题。<br/>
Write a program to solve a Sudoku puzzle by filling the empty cells.

一个数独的解法需**遵循如下规则**(A sudoku solution must satisfy **all of the following rules**)：
1. 数字 1-9 在每一行只能出现一次。(Each of the digits `1-9` must occur exactly once in each row.)
2. 数字 1-9 在每一列只能出现一次。(Each of the digits `1-9` must occur exactly once in each column.)
3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。(Each of the the digits `1-9` must occur exactly once in each of the 9 `3x3` sub-boxes of the grid.

空白格用 `'.'` 表示。<br/>
Empty cells are indicated by the character `'.'`.

![](250px-Sudoku-by-L2G-20050714.svg.png)

一个数独。<br/>
A sudoku puzzle...

![](250px-Sudoku-by-L2G-20050714_solution.svg.png)

答案被标成红色。<br/>
...and its solution numbers marked in red.

**Note**:
- 给定的数独序列只包含数字 `1-9` 和字符 `'.'` 。(The given board contain only digits `1-9` and the character `'.'`.)
- 你可以假设给定的数独只有唯一解。(You may assume that the given Sudoku puzzle will have a single unique solution.)
- 给定数独永远是 `9x9` 形式的。(The given board size is always `9x9`.)