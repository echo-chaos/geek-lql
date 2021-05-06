## 源码：

```java
package org.lql.jvm;

import java.util.Random;

public class Hello {

    public static void main(String[] args) {
        byte a = 1;
        int b = new Random().nextInt(10);
        long c = 3L;
        double d = 4.0d;

        if ((a * b * c * d) % b == a) {
            System.out.println("(a * b * c * d) = " + (a * b * c * d));
        } else {
            System.out.println("(a * b * c * d) % b = " + (a * b * c * d) % b);
        }

        for (int i = 0; i < a; i++) {
            System.out.println("加法-(a + b)：" + (a + b));
            System.out.println("减法-(d - b)：" + (d - b));
            System.out.println("乘法-(c * b)：" + (c * b));
            System.out.println("除法-(d / c)：" + (d / c));
        }

    }
}

```

## 字节码：

```java
Classfile /G:/IDEA-Projects-LQL/demo-geek/demo-jvm/src/org/lql/jvm/Hello.class
  Last modified 2021-5-5; size 1429 bytes
  MD5 checksum 25630cad613d5749b7b812a1c827448c
  Compiled from "Hello.java"
public class org.lql.jvm.Hello
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #25.#50        // java/lang/Object."<init>":()V
   #2 = Class              #51            // java/util/Random
   #3 = Methodref          #2.#50         // java/util/Random."<init>":()V
   #4 = Methodref          #2.#52         // java/util/Random.nextInt:(I)I
   #5 = Long               3l
   #7 = Double             4.0d
   #9 = Fieldref           #53.#54        // java/lang/System.out:Ljava/io/PrintStream;
  #10 = Class              #55            // java/lang/StringBuilder
  #11 = Methodref          #10.#50        // java/lang/StringBuilder."<init>":()V
  #12 = String             #56            // (a * b * c * d) =
  #13 = Methodref          #10.#57        // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #14 = Methodref          #10.#58        // java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
  #15 = Methodref          #10.#59        // java/lang/StringBuilder.toString:()Ljava/lang/String;
  #16 = Methodref          #60.#61        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #17 = String             #62            // (a * b * c * d) % b =
  #18 = String             #63            // 加法-(a + b)：
  #19 = Methodref          #10.#64        // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
  #20 = String             #65            // 减法-(d - b)：
  #21 = String             #66            // 乘法-(c * b)：
  #22 = Methodref          #10.#67        // java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
  #23 = String             #68            // 除法-(d / c)：
  #24 = Class              #69            // org/lql/jvm/Hello
  #25 = Class              #70            // java/lang/Object
  #26 = Utf8               <init>
  #27 = Utf8               ()V
  #28 = Utf8               Code
  #29 = Utf8               LineNumberTable
  #30 = Utf8               LocalVariableTable
  #31 = Utf8               this
  #32 = Utf8               Lorg/lql/jvm/Hello;
  #33 = Utf8               main
  #34 = Utf8               ([Ljava/lang/String;)V
  #35 = Utf8               i
  #36 = Utf8               I
  #37 = Utf8               args
  #38 = Utf8               [Ljava/lang/String;
  #39 = Utf8               a
  #40 = Utf8               B
  #41 = Utf8               b
  #42 = Utf8               c
  #43 = Utf8               J
  #44 = Utf8               d
  #45 = Utf8               D
  #46 = Utf8               StackMapTable
  #47 = Class              #38            // "[Ljava/lang/String;"
  #48 = Utf8               SourceFile
  #49 = Utf8               Hello.java
  #50 = NameAndType        #26:#27        // "<init>":()V
  #51 = Utf8               java/util/Random
  #52 = NameAndType        #71:#72        // nextInt:(I)I
  #53 = Class              #73            // java/lang/System
  #54 = NameAndType        #74:#75        // out:Ljava/io/PrintStream;
  #55 = Utf8               java/lang/StringBuilder
  #56 = Utf8               (a * b * c * d) =
  #57 = NameAndType        #76:#77        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #58 = NameAndType        #76:#78        // append:(D)Ljava/lang/StringBuilder;
  #59 = NameAndType        #79:#80        // toString:()Ljava/lang/String;
  #60 = Class              #81            // java/io/PrintStream
  #61 = NameAndType        #82:#83        // println:(Ljava/lang/String;)V
  #62 = Utf8               (a * b * c * d) % b =
  #63 = Utf8               加法-(a + b)：
  #64 = NameAndType        #76:#84        // append:(I)Ljava/lang/StringBuilder;
  #65 = Utf8               减法-(d - b)：
  #66 = Utf8               乘法-(c * b)：
  #67 = NameAndType        #76:#85        // append:(J)Ljava/lang/StringBuilder;
  #68 = Utf8               除法-(d / c)：
  #69 = Utf8               org/lql/jvm/Hello
  #70 = Utf8               java/lang/Object
  #71 = Utf8               nextInt
  #72 = Utf8               (I)I
  #73 = Utf8               java/lang/System
  #74 = Utf8               out
  #75 = Utf8               Ljava/io/PrintStream;
  #76 = Utf8               append
  #77 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #78 = Utf8               (D)Ljava/lang/StringBuilder;
  #79 = Utf8               toString
  #80 = Utf8               ()Ljava/lang/String;
  #81 = Utf8               java/io/PrintStream
  #82 = Utf8               println
  #83 = Utf8               (Ljava/lang/String;)V
  #84 = Utf8               (I)Ljava/lang/StringBuilder;
  #85 = Utf8               (J)Ljava/lang/StringBuilder;
{
  public org.lql.jvm.Hello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 5: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lorg/lql/jvm/Hello;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=6, locals=8, args_size=1
         0: iconst_1
         1: istore_1
         2: new           #2                  // class java/util/Random
         5: dup
         6: invokespecial #3                  // Method java/util/Random."<init>":()V
         9: bipush        10
        11: invokevirtual #4                  // Method java/util/Random.nextInt:(I)I
        14: istore_2
        15: ldc2_w        #5                  // long 3l
        18: lstore_3
        19: ldc2_w        #7                  // double 4.0d
        22: dstore        5
        24: iload_1
        25: iload_2
        26: imul
        27: i2l
        28: lload_3
        29: lmul
        30: l2d
        31: dload         5
        33: dmul
        34: iload_2
        35: i2d
        36: drem
        37: iload_1
        38: i2d
        39: dcmpl
        40: ifne          80
        43: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
        46: new           #10                 // class java/lang/StringBuilder
        49: dup
        50: invokespecial #11                 // Method java/lang/StringBuilder."<init>":()V
        53: ldc           #12                 // String (a * b * c * d) =
        55: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        58: iload_1
        59: iload_2
        60: imul
        61: i2l
        62: lload_3
        63: lmul
        64: l2d
        65: dload         5
        67: dmul
        68: invokevirtual #14                 // Method java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        71: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        74: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        77: goto          117
        80: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
        83: new           #10                 // class java/lang/StringBuilder
        86: dup
        87: invokespecial #11                 // Method java/lang/StringBuilder."<init>":()V
        90: ldc           #17                 // String (a * b * c * d) % b =
        92: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        95: iload_1
        96: iload_2
        97: imul
        98: i2l
        99: lload_3
       100: lmul
       101: l2d
       102: dload         5
       104: dmul
       105: iload_2
       106: i2d
       107: drem
       108: invokevirtual #14                 // Method java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
       111: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
       114: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       117: iconst_0
       118: istore        7
       120: iload         7
       122: iload_1
       123: if_icmpge     245
       126: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
       129: new           #10                 // class java/lang/StringBuilder
       132: dup
       133: invokespecial #11                 // Method java/lang/StringBuilder."<init>":()V
       136: ldc           #18                 // String 加法-(a + b)：
       138: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
       141: iload_1
       142: iload_2
       143: iadd
       144: invokevirtual #19                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
       147: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
       150: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       153: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
       156: new           #10                 // class java/lang/StringBuilder
       159: dup
       160: invokespecial #11                 // Method java/lang/StringBuilder."<init>":()V
       163: ldc           #20                 // String 减法-(d - b)：
       165: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
       168: dload         5
       170: iload_2
       171: i2d
       172: dsub
       173: invokevirtual #14                 // Method java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
       176: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
       179: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       182: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
       185: new           #10                 // class java/lang/StringBuilder
       188: dup
       189: invokespecial #11                 // Method java/lang/StringBuilder."<init>":()V
       192: ldc           #21                 // String 乘法-(c * b)：
       194: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
       197: lload_3
       198: iload_2
       199: i2l
       200: lmul
       201: invokevirtual #22                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
       204: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
       207: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       210: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
       213: new           #10                 // class java/lang/StringBuilder
       216: dup
       217: invokespecial #11                 // Method java/lang/StringBuilder."<init>":()V
       220: ldc           #23                 // String 除法-(d / c)：
       222: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
       225: dload         5
       227: lload_3
       228: l2d
       229: ddiv
       230: invokevirtual #14                 // Method java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
       233: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
       236: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       239: iinc          7, 1
       242: goto          120
       245: return
      LineNumberTable:
        line 8: 0
        line 9: 2
        line 10: 15
        line 11: 19
        line 13: 24
        line 14: 43
        line 16: 80
        line 19: 117
        line 20: 126
        line 21: 153
        line 22: 182
        line 23: 210
        line 19: 239
        line 26: 245
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
          120     125     7     i   I
            0     246     0  args   [Ljava/lang/String;
            2     244     1     a   B
           15     231     2     b   I
           19     227     3     c   J
           24     222     5     d   D
      StackMapTable: number_of_entries = 4
        frame_type = 255 /* full_frame */
          offset_delta = 80
          locals = [ class "[Ljava/lang/String;", int, int, long, double ]
          stack = []
        frame_type = 36 /* same */
        frame_type = 252 /* append */
          offset_delta = 2
          locals = [ int ]
        frame_type = 250 /* chop */
          offset_delta = 124
}
SourceFile: "Hello.java"
```

## 解释：

```java
 public org.lql.jvm.Hello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1			## 栈容量为1，本地变量个数为1，参数为一个
         0: aload_0								  ## 加载本地0角标变量
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 5: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lorg/lql/jvm/Hello;
```

## 太多了。。