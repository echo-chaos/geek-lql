```markdown
堆内存配置：128m 256m 512m 1g 2g 4g

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -Xloggc:gc.demo.log GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX:+UseSerialGC GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX:+UseParallelGC GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX:+UseConcMarkSweepGC GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX:+UseG1GC GCLogAnalysis
```

## Serial GC

```markdown
### 128m
>> oom
>> DefNew 8次 0.06ms
>> Full GC 19 3ms+-
    
### 256m
>> DefNew 10次 1ms
>> Full GC  41次 6~8ms 
>>> 伴随 Tenured 0.00x~0.2ms  Metaspace 少量~2ms 多数0.00X
>> 共生成对象次数: 4328

### 512m
>> DefNew 17次 2~3ms 8次 0.0000xms 9次
>> 共生成对象次数: 9184

### 1g
>> DefNew 8 5~6ms
>> 共生成对象次数: 8420
 
### 2g
>> DefNew 4 1ms+-
>> 共生成对象次数:8303
    
### 4g
>> DefNew 1 0.1862903 secs
>> 共生成对象次数: 4292

```

## Parallel GC

```markdown
### 128m
>> oom
>> PSYoungGen 33 0.003 
>> Full GC + PSYoungGen + ParOldGen + Metaspace 22 1ms+- 
    
### 256m
>> oom与正常运行比例相当
>> PSYoungGen 42 不到1ms
>> Full GC + PSYoungGen + ParOldGen + Metaspace 32 1~2ms+-

### 512m
>> PSYoungGen 38 1-ms
>> Full GC + PSYoungGen + ParOldGen + Metaspace 9 3~4+-ms
>>> 10次PSYoungGen后 隔2~3次出现
>> 共生成对象次数:8578

### 1g
>> PSYoungGen 19 1~2+-
>> Full GC + PSYoungGen + ParOldGen + Metaspace 1 0.0493564 secs
>> 共生成对象次数:11285
 
### 2g
>> PSYoungGen 5 4~5+- ms
>> 共生成对象次数:9842
    
### 4g
>> PSYoungGen 1 0.0718924 secs
>> 共生成对象次数:7149
```

## CMS GC

```markdown
### 128m
>> oom
>> ParNew 12 0.00x 0.000x ms
>> Full GC + Metaspace 13 1+-ms
>> CMS 4 0.005

### 256m
>> ParNew 18 1+-ms
>> Full GC 10
>> 共生成对象次数:3836

### 512m
>> ParNew 17 2+-ms
>> 共生成对象次数:9092
    
### 1g
>> ParNew 7 3~5+-ms
>> 共生成对象次数:9076
 
### 2g
>> ParNew 8 5~6+-ms
>> 共生成对象次数:8732
    
### 4g
>> ParNew 8 6+-ms
>> 共生成对象次数:8270
```

## G1 GC

```markdown
### 128m
>> oom
>> young 36 0.003+-
>> Full GC 8 0.003
    
### 256m
>> oom 少量成功
>> young 65 0.002+-
>> 共生成对象次数:3180

### 512m
>> young 41 0.002+-
>> 共生成对象次数:8341
    
### 1g
>> young 19 0.005+
>> 共生成对象次数:10263
 
### 2g
>> young 13 0.01+-
>> 共生成对象次数:9371
    
### 4g
>> >> young 13 0.01
>> 共生成对象次数:10061
```

```markdown
### 
堆内存在128m时，都会发生oom

堆内存在256m时，Parallel GC发生oom的概率是50%，G1 GC发生oom概率达90%以上

堆内存在512m时：
>> Serial GC对象创建次数为单个gc内最多

堆内存在达1g时：
>> Parallel GC, CMS GC, G1 GC对象创建次数为单个gc内最多

随着堆内存增大，平均GC时间也随之变长

在达到单个GC对象创建数量最多堆内存时，GC次数随着堆内存变大也呈增多趋势，在到达512m/1g后开始下降

### 
堆内存在512m以下时，内存不足以支撑对象的创建容纳，出现oom
内存相同时：
>> gc时间：Serial GC > CMS GC > Parallel GC > G1 GC
>> gc次数：G1 GC > Parallel GC > CMS GC > Serial GC

>> G1 GC回收时间是最优的，回收次数最频繁
>> Serial GC回收时间是最慢的，回收次数是最少的

>> 因此可以初步认为：GC效率
>> G1 GC > Parallel GC & CMS GC > Serial GC

```



