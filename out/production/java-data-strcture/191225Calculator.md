#####昨日代码总结（使用数组来搭建栈）
    1.isFull使用一个辅助变量来跟随
    2.isEmpty同样使用上面的方法就可以得到结论
    3.push使用赋值语句即可
    4.pop使用取数据
    5.list使用两个参数同时使用即可
#计算器解法思路
##对栈的更改
    1.添加符号的计算级别，如果下一个的计算级别比栈中存的计算级别高，则直接进行计算
    2.添加判断是否为计算符的函数
    3.添加计算方法
##主要程序
    1.定义计算公式
    2.构建两个相同的栈
    3.定义辅助变量，两个数，索引值，符号值，结果值，保存扫描的值，以及用于粘合两个数的参数
    4.扫描计算公式，判断是数字还是计算符，数字考虑下一个是否为计算符，
    5.如果是计算符，需要判断是否与栈中的上一个符号谁的等级高，如果这个等级高，直接进行计算
    6.最后，只需要迭代计算结果即可