## UseSerialGC

```markdown
PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX:+UseSerialGC -Xloggc:serialgc.128.log GCLogAnalysis
正在执行...
java : Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
所在位置 行:1 字符: 1
+ java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX ...
+ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    + CategoryInfo          : NotSpecified: (Exception in th...Java heap space:String) [], RemoteException
    + FullyQualifiedErrorId : NativeCommandError
 
	at java.util.Arrays.copyOf(Arrays.java:3332)
	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
	at java.lang.StringBuilder.append(StringBuilder.java:208)
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:56)
	at GCLogAnalysis.main(GCLogAnalysis.java:25)

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms256m -Xmx256m -XX:+UseSerialGC -Xloggc:serialgc.256.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:4328

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms512m -Xmx512m -XX:+UseSerialGC -Xloggc:serialgc.512.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:9184

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms1g -Xmx1g  -XX:+UseSerialGC -Xloggc:serialgc.1g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:8420

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms2g -Xmx2g  -XX:+UseSerialGC -Xloggc:serialgc.2g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:8303

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms4g -Xmx4g  -XX:+UseSerialGC -Xloggc:serialgc.4g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:4292

PS G:\byteCode> 
```

## UseParallelGC

```markdown
PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX:+UseParallelGC -Xloggc:parallelgc.128.log GCLogAnalysis
正在执行...
java : Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
所在位置 行:1 字符: 1
+ java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX ...
+ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    + CategoryInfo          : NotSpecified: (Exception in th...Java heap space:String) [], RemoteException
    + FullyQualifiedErrorId : NativeCommandError
 
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)
	at GCLogAnalysis.main(GCLogAnalysis.java:25)

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms256m -Xmx256m -XX:+UseParallelGC -Xloggc:parallelgc.256.log GCLogAnalysis
正在执行...
java : Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
所在位置 行:1 字符: 1
+ java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms256m -Xmx256m -XX ...
+ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    + CategoryInfo          : NotSpecified: (Exception in th...Java heap space:String) [], RemoteException
    + FullyQualifiedErrorId : NativeCommandError
 
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)
	at GCLogAnalysis.main(GCLogAnalysis.java:25)

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms512m -Xmx512m -XX:+UseParallelGC -Xloggc:parallelgc.512.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:8578

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms1g -Xmx1g  -XX:+UseParallelGC -Xloggc:parallelgc.1g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:11285

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms2g -Xmx2g  -XX:+UseParallelGC -Xloggc:parallelgc.2g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:9842

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms4g -Xmx4g  -XX:+UseParallelGC -Xloggc:parallelgc.4g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:7149

PS G:\byteCode> 
```

## UseConcMarkSweepGC

```markdown
PS G:\byteCode> 
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX:+UseConcMarkSweepGC -Xloggc:cmsgc.128.log GCLogAnalysis
正在执行...
java : Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
所在位置 行:2 字符: 1
+ java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX ...
+ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    + CategoryInfo          : NotSpecified: (Exception in th...Java heap space:String) [], RemoteException
    + FullyQualifiedErrorId : NativeCommandError
 
	at java.util.Arrays.copyOf(Arrays.java:3332)
	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
	at java.lang.StringBuilder.append(StringBuilder.java:208)
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:56)
	at GCLogAnalysis.main(GCLogAnalysis.java:25)

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms256m -Xmx256m -XX:+UseConcMarkSweepGC -Xloggc:cmsgc.256.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:3836

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms512m -Xmx512m -XX:+UseConcMarkSweepGC -Xloggc:cmsgc.512.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:9092

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms1g -Xmx1g  -XX:+UseConcMarkSweepGC -Xloggc:cmsgc.1g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:9076

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms2g -Xmx2g  -XX:+UseConcMarkSweepGC -Xloggc:cmsgc.2g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:8732

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms4g -Xmx4g  -XX:+UseConcMarkSweepGC -Xloggc:cmsgc.4g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:8270

PS G:\byteCode> 
```

## UseG1GC

```markdown
PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX:+UseG1GC -Xloggc:g1gc.128.log GCLogAnalysis
正在执行...
java : Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
所在位置 行:1 字符: 1
+ java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms128m -Xmx128m -XX ...
+ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    + CategoryInfo          : NotSpecified: (Exception in th...Java heap space:String) [], RemoteException
    + FullyQualifiedErrorId : NativeCommandError
 
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)
	at GCLogAnalysis.main(GCLogAnalysis.java:25)

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms256m -Xmx256m -XX:+UseG1GC -Xloggc:g1gc.256.log GCLogAnalysis
正在执行...
java : Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
所在位置 行:1 字符: 1
+ java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms256m -Xmx256m -XX ...
+ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    + CategoryInfo          : NotSpecified: (Exception in th...Java heap space:String) [], RemoteException
    + FullyQualifiedErrorId : NativeCommandError
 
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)
	at GCLogAnalysis.main(GCLogAnalysis.java:25)

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms512m -Xmx512m -XX:+UseG1GC -Xloggc:g1gc.512.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:8341

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms1g -Xmx1g  -XX:+UseG1GC -Xloggc:g1gc.1g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:10263

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms2g -Xmx2g  -XX:+UseG1GC -Xloggc:g1gc.2g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:9371

PS G:\byteCode> java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms4g -Xmx4g  -XX:+UseG1GC -Xloggc:g1gc.4g.log GCLogAnalysis
正在执行...
执行结束!共生成对象次数:10061

PS G:\byteCode> 
```

