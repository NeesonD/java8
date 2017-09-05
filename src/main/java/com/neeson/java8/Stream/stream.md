### 流介绍
1. Stream是元素的集合（可以当做是高级版本的Iterator）
2. 可以支持顺序和并行的对原Stream进行汇聚的操作

###  Stream的基本操作
* 创建流
* 转换Stream，每次转换原有的Stream对象不改变，返回一个新的Stream对象
* 对Stream进行聚合(Reduce)操作

###  创建Stream
* 通过Stream接口的静态工厂方法
* 通过Collection接口的默认方法

**使用Stream静态方法来创建Stream**
1. of方法(单一参数和变长)
```
Stream<Integer> integer = Stream.of(1,2,3);
Stream<String> string = Stream.of("1");
```
2. generator(无限长度)
```
Stream.generate(new Supplier<Double>() {
       public Double get(){
            return Math.randow();
       }
})

Stream.generate(() -> Math.randow());
Stream.generate(Math::randow);
```
3. iterate(无限长度)
```
Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
```

**通过Collection子类获取Stream**

### 转换Stream

1. distinct: 去重
2. filter:过滤
3. map:元素类型的转换
4. flatMap: 转换前的元素和之后的元素都在一个Stream里面
5. peek:生成一个包含原Stream的所有元素的新Stream，同时提供一个消费函数
6. limit:获取前N个元素
7. skip: 返回一个丢弃原Stream的前N个元素组成的Stream

### 汇聚（Reduce）

* 汇聚操作接受一个元素序列为输入，反复使用某个合并操作 ，把序列中的元素合并成一个汇总的结果

* 可变汇聚：把输入的元素累积到一个可变容器中
* 其他汇聚：除去可变汇聚剩下的

**可变汇聚**

* 生成一个新的collection

**其他汇聚**
* reduce
```
ints.stream().reduce((sum,item) -> sum+item).get();
```
* count 获取Stream中元素的个数
* allMatch 是不是Stream中的所有元素都满足给定的匹配条件
* anyMatch Stream中是否存在任何一个元素满足匹配条件
* findFirst 返回Stream中的第一个元素，如果为空，返回空Optional
* noneMatch 是不是Stream中元素都不满足给定的匹配条件
* max和min 使用给定的比较器（Operator），返回Stream中最大|最小值
