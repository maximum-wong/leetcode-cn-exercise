#### 48. 旋转图像(Rotate Image)

给定一个 n × n 的二维矩阵表示一个图像。<br/>
You are given an n x n 2D matrix representing an image.

将图像顺时针旋转 90 度。<br/>
Rotate the image by 90 degrees (clockwise).

**说明(Note)：**

你必须在[原地]([https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95](https://baike.baidu.com/item/原地算法))旋转图像，这意味着你需要直接修改输入的二维矩阵。**请不要**使用另一个矩阵来旋转图像。<br/>
You have to rotate the image [in-place](https://en.wikipedia.org/wiki/In-place_algorithm), which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

**示例 1(Example 1):**

```
给定 matrix(Given input matrix) = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为(rotate the input matrix in-place such that it becomes):
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```

**示例 2(Example 2):**

```
给定 matrix(Given input matrix) =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为(rotate the input matrix in-place such that it becomes):
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```