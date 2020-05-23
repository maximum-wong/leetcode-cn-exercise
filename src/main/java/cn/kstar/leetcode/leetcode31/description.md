#### 31. 下一个排列(Next Permutation)

实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。<br/>
Implement **next permutation**, which rearranges numbers into the lexicographically next greater permutation of numbers.

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。<br/>
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

必须原地修改，只允许使用额外常数空间。<br/>
The replacement must be **[in-place](http://en.wikipedia.org/wiki/In-place_algorithm)** and use only constant extra memory.

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。<br/>
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.<br/>
`1,2,3` → `1,3,2`<br/>
`3,2,1` → `1,2,3`<br/>
`1,1,5` → `1,5,1`<br/>

