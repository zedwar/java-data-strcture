##快速排序
  快速排序是冒泡排序的改进版，是目前已知的最快的排序方法。
  该排序算法的基本思想是：
  1.先从数列中取出一个数作为基准数。
  2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
  3．再对左右区间重复第二步，直到各区间只有一个数。
  优点：极快，数据移动少；
  缺点：不稳定
###代码难点
    需要使用递归
    在使用递归的过程中如何使用中轴点进行划分两边
    
##归并排序
    归并操作的工作原理如下：
    第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
    第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
    第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
    重复步骤3直到某一指针超出序列尾
    将另一序列剩下的所有元素直接复制到合并序列尾
##桶排序
    初始化：构造一个10*n的二维数组，一个长度为n的数组用于存储每次位排序时每个桶子里有多少个元素。
    循环操作：从低位开始（我们采用LSD的方式），将所有元素对应该位的数字存到相应的桶子里去（对应二维数组的那一列）。
        然后将所有桶子里的元素按照桶子标号从小到大取出，对于同一个桶子里的元素，先放进去的先取出，后放进去的后取出（保证排序稳定性）。
        这样原数组就按该位排序完毕了，继续下一位操作，直到最高位排序完成。
##二分查找
    在实现时，我们可以维护两个指针left和right，指针之间的范围便是我们的查找范围。查找过程如下：
        　　首先判断边界条件，left位置的值与right位置的值是否包含目标值，若包含则查找结束；
        　　通过left与right的位置找到当前范围的中点mid，即mid的值为(left+right)/2；
        　　如果mid的值便是target的值，查找结束；
        　　如果left与right已经是相邻的元素，那么证明数组中没有目标值，查找结束；
        　　如果目标值大于mid则在mid、right间继续查找，即将mid的值赋予left；
        　　反之在left与mid间继续查找，即将mid的值赋予right；