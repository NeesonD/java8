```
(Type1 param1,Type2 param2,....) -> {
    statment1;
    statment2;
    retrun statmentM;
}
```
1. 参数类型可以省略
```
(param1,param2,....) -> {
    statment1;
    statment2;
    retrun statmentM;
}
```
2. 参数只有一个时，可以省略小括号

```
param1 -> {
    statment1;
    statment2;
    return statmentM;
}

```
3. 当lambda表达式只有一行，可以省略大括号、return、和语句结尾的分号
```
param1 -> statment;
```

4. 使用Method Reference

* lambda表达式的组成部分：
* 输入参数
* 可执行语句
* 存放外部变量的空间(变量引用不可变)，该变量可以不用final修饰，编译器隐式当成final来处理


5. 方法引用语法格式：
* objectName::instanceMethod
* ClassName::staticMethod
* ClassName::instanceMethod

前两种：
```
System.out::println 相当于 x -> System.out.println(x)
Math::max 相当于 (x,y) -> Math.max(x,y)

```

后一种：
```
String::toLowerCase 相当于 x -> x.toLowerCase()

```

6. 构造引用
* ClassName::new 
```
BigDecimal::new 相当于 x -> new BigDecimal(x)
```
