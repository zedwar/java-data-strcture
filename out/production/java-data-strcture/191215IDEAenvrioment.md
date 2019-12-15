##IDEA中五种目录类型简介
    1.Sources 一般用于标注可编译目录。只有可编译目录才能新建java类和包。在规范的maven项目结构中，顶级目录是src，需要在子目录main-java设置为Sources
    2.Tests一般用于标注可编译的单元测试目录。而单元测试目录是src-test-java，我们会设置java目录为Tests，表示该目录是作为可编译的单元测试目录。
    3.Resources一般用于标注资源文件目录。在maven项目下，资源目录是单独划分出来的，其目录为src-main-resources。
    4.Test Resources一般用于标注单元测试资源文件目录。在maven项目下，资源目录是单独划分出来的，其目录为src-test-resources。
    5.Excluded 一般用于标注排除目录。被排除的目录不会被 IntelliJ IDEA 创建索引，相当于被 IntelliJ IDEA 废弃，该目录下的代码文件是不具备代码检查和智能提示等常规代码功能

##今日问题：如何把已有项目转化为java项目
    用IDEA打开之后使用MArk directory as就可以了
    
