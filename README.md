### 2017-09-15 —— Java语言程序设计基础

##### 1.猜数字

```
编写一个Java应用程序，实现如下功能：

A．随机分配给客户一个1~100之间的整数。

B．用户从键盘输入自己的猜想。

C．程序返回提示：”大了”，”小了”，”猜对了”。

D．用户根据提示，再次输入猜想的数，直到猜对为止，显示”猜对了”，同时输出猜想的次数。
```



##### 2.金额的中文大写形式

```
给定一个浮点数，将其转换为金额的中文大写形式的字符串。例如，123.45表示为“壹佰贰拾叁元肆角伍分”。注意以下几种情况：

A．当金额为整数时，只表示整数部分，省略小数部分，并添加“整”字，例如123表示成“壹佰贰拾叁元整”。

B．当金额中含有连续的0时，只需写一个“零”即可。例如10005表示为“壹万零伍元整”。

C．10的省略表示。例如110表示为“壹佰壹拾元整”，而10表示为“拾元整”。

D．100表示为“壹佰元整”，1000表示为“壹仟元整”等等
```



### 2017-09-29 —— 类的封装、继承、多态和接口

##### 1.有理数四则运算

```
编写一个Java应用程序，实现两个有理数的四则运算，要求有理数用分子和分母的形式表示。结果要求用“分子/分母”的形式表示。
```



##### 2.表演最终得分

```
声明一个Average接口，其中约定求平均值的方法（参数为一个数组）；声明First、Second类实现Average接口，分别给出求平均值的方法实现。

A．类First中的功能为全部数值相加后求平均值。

B．类Second中的功能为去掉一个最高分和一个最低分，再将总分求平均值。
```



### 2017-10-27 —— 图形用户界面设计

##### 考试题

```
要求在一个界面内至少显示5道选择题，每道题4个选项。另有2个命令按钮，分别为“重新答题”（全部选项及正确答题数清空）和“提交”（计算），在按钮下方的标签内显示最终的正确的题目数。界面大致布局如下：
![img](file:///C:/TEMP/msohtmlclip1/01/clip_image001.png)
```



### 2017-11-03 —— 数据库应用设计



##### 学生信息管理系统

```
学生成绩表Student(Sno 字符串，长度9, Sname 字符串，长度10, Class 字符串，长度10, Age 整型, Sex 字符串，长度2)

实现如下功能：

A．输入若干个学生的信息到Student表；

B．修改制定学号学生的基本信息；

C．删除指定学号的学生基本信息；

D．按照性别找出所有相应的学生基本信息；

E．按照年龄段找出所有相应的学生基本信息，例如[19，21]的学生。
```



### 2017-11-24 —— 输入/输出流与文件操作



##### 文件加密

```
编写一个Java应用程序，实现将一个由英文字母、数字及其他符号构成的文件(a.txt)通过加密之后写入另外一个文件(b.txt)内。

加密算法为：如果是英文字母，则采用(字母+1) % 26的方式转换；如果是数字则采用(1234567890)的倒数的方式转换，除此之外的符号原样输出。

例如：源文件内的内容为ah0123,:Mz，则目标文件内容为bi1098,:Na
```
