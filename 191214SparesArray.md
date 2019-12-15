#稀疏数组
##如何把二维数组转化为稀疏数组
    1.遍历二维数组，得到有效数据的个数
    2.根据sum就可以创建稀疏数组
    3.将二维数组的有效数据存入到系数数组中
##稀疏数组转化为原始的二维数组
    1.先读取其的第一行，创建原始的二维数组
    2.读取后面的数据，存储到二维数组
    
###今日问题
####Idea快捷键总结
    1.Alt+回车 导入包,自动修正
    2.Alt+Insert 生成代码(如get,set方法,构造函数等)
    3.Ctrl+E或者Alt+Shift+C  最近更改的代码
    4.Ctrl+R 替换文本
    5.Ctrl+F 查找文本
    6.Ctrl+Shift+Space 自动补全代码
    7.Ctrl+X 删除行
      Ctrl+D 复制行
      Ctrl+/ 或 Ctrl+Shift+/  注释（// 或者/*...*/ ）
    8.Ctrl＋O可以选择父类的方法进行重写
    9.调试快捷键
        alt+F8 debug时选中查看值
        Alt+Shift+F9，选择 Debug
        Alt+Shift+F10，选择 Run
        Ctrl+Shift+F9，编译
####print函数之间的区别
    System.out.print("用print输出i:"+ i);
    System.out.println( "用println输出i:"+ i);
    System.out.printf("i的值为%d,j的值为%f", i,j);
####Cannot start compilation: the output path is not specified for module "Test"
    1.因为没有将配置文件一起上传
    2.在Modules设置里勾选”Inherit project compile path”
    3.设置Project中的”Project compiler output” 选择”Project的路径”+”\out”