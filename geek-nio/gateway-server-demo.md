```markdown
### java -Xms1g -Xmx1g  -jar .\gateway-server-0.0.1-SNAPSHOT.jar
```

| Count | RPS   | Max    | Min    | Avg      |
| ----- | ----- | ------ | ------ | -------- |
| 50    | 13.1  | 4219ms | 2011ms | 3573.7ms |
| 100   | 25.7  | 4249ms | 2020ms | 3743.8ms |
| 200   | 50.6  | 4318ms | 2009ms | 3803.4ms |
| 500   | 124.8 | 4674ms | 2014ms | 3867.7ms |
| 1000  | 223.8 | 4928ms | 2022ms | 4042.1ms |

```markdown
### java -Xms4g -Xmx4g  -jar .\gateway-server-0.0.1-SNAPSHOT.jar
```

| Count | RPS   | Max    | Min    | Avg      |
| ----- | ----- | ------ | ------ | -------- |
| 50    | 5.7   | 4217ms | 2004ms | 3583.2ms |
| 100   | 25.6  | 4227ms | 2012ms | 3697.9ms |
| 200   | 51.1  | 4156ms | 2006ms | 3569.5ms |
| 500   | 121.7 | 4354ms | 2016ms | 3864.1ms |
| 1000  | 224   | 5854ms | 2004ms | 4219ms   |

```markdown
### 相同启动堆内存参数下：
压测并发量越大，对应的RPS值也随之增大
同数量级并发量下，请求响应时间没有较明显差距，
提高并发数量级下，请求响应时间差值较大

### 不同启动堆内存参数下：
压测并发量对应的RPS值差别不大，对应响应时间差距较为明显

### 
在有足够的内存空间下，并发请求量越大，RPS值越大
内存空间偏小时，到达一定压测并发量便会压测失败	
>> 不配置启动参数、使用idea直接启动进行压测，在我的电脑上压测的并发量只能在20左右，在多便会压测失败

### 对百度的压测结果
>> sb -u http://www.baidu.com -c 100 -N 30
RPS: 217 (requests/second)
Max: 8647ms
Min: 35ms
Avg: 438.1ms

>> sb -u http://www.baidu.com -c 500 -N 30
RPS: 177.1 (requests/second)
Max: 1191ms
Min: 238ms
Avg: 727.1ms

>> sb -u http://www.baidu.com -c 1000 -N 30
RPS: 132.9 (requests/second)
Max: 1564ms
Min: 397ms
Avg: 1041.5ms

*** 目测是随着压测并发量的增大而RPS值变小，平均响应时间变小(压测次数太少也不确定)

*** 等我在熟悉熟悉压测用例，再多测些数据再确定确定吧
```















```markdown
### java -Xms1g -Xmx1g  -jar .\gateway-server-0.0.1-SNAPSHOT.jar

### 并发量 50
PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 50 -N 30
Starting at 2021/5/18 0:57:38
[Press C to stop the test]
415     (RPS: 11.4)
---------------Finished!----------------
Finished at 2021/5/18 0:58:15 (took 00:00:36.5729389)
Status 303:    415

RPS: 13.1 (requests/second)
Max: 4219ms
Min: 2011ms
Avg: 3573.7ms

  50%   below 4076ms
  60%   below 4086ms
  70%   below 4094ms
  80%   below 4102ms
  90%   below 4109ms
  95%   below 4113ms
  98%   below 4153ms
  99%   below 4181ms
99.9%   below 4219ms
440     (RPS: 12)9)

### 并发量 100

PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 100 -N 30
Starting at 2021/5/18 1:01:51
[Press C to stop the test]
727     (RPS: 20)8)
---------------Finished!----------------
Finished at 2021/5/18 1:02:28 (took 00:00:36.4365988)
813     (RPS: 22.4)                     Status 303:    813

RPS: 25.7 (requests/second)
Max: 4249ms
Min: 2020ms
Avg: 3743.8ms

  50%   below 4076ms
  60%   below 4081ms
  70%   below 4093ms
  80%   below 4099ms
  90%   below 4117ms
  95%   below 4147ms
  98%   below 4182ms
  99%   below 4208ms
99.9%   below 4249ms
826     (RPS: 22.7)

### 并发量 200

PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 200 -N 30
Starting at 2021/5/18 1:03:30
[Press C to stop the test]
1435    (RPS: 39.5)
---------------Finished!----------------
Finished at 2021/5/18 1:04:07 (took 00:00:36.4281457)
1597    (RPS: 43.9)                     Status 303:    1597

RPS: 50.6 (requests/second)
Max: 4318ms
Min: 2009ms
Avg: 3803.4ms

  50%   below 4069ms
  60%   below 4077ms
  70%   below 4087ms
  80%   below 4095ms
  90%   below 4112ms
  95%   below 4127ms
  98%   below 4145ms
  99%   below 4157ms
99.9%   below 4271ms
1625    (RPS: 44.7)

### 并发量 500

PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 500 -N 30
Starting at 2021/5/18 1:05:04
[Press C to stop the test]
3556    (RPS: 97.6))
---------------Finished!----------------
Finished at 2021/5/18 1:05:40 (took 00:00:36.5045046)
3925    (RPS: 107.7)                    Status 303:    3934

RPS: 124.8 (requests/second)
Max: 4674ms
Min: 2014ms
Avg: 3867.7ms

  50%   below 4089ms
  60%   below 4103ms
  70%   below 4120ms
  80%   below 4146ms
  90%   below 4223ms
  95%   below 4309ms
  98%   below 4465ms
  99%   below 4511ms
99.9%   below 4626ms
4018    (RPS: 110.2)

### 并发量 1000

PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 1000 -N 30
Starting at 2021/5/18 1:07:02
[Press C to stop the test]
7031    (RPS: 185.5)
---------------Finished!----------------
Finished at 2021/5/18 1:07:40 (took 00:00:37.9520465)
7266    (RPS: 191.7)                    Status 303:    7336
7295    (RPS: 192.4)
7302    (RPS: 192.6)                    RPS: 223.8 (requests/second)
Max: 4928ms
Min: 2022ms
Avg: 4042.1ms
7342    (RPS: 193.7)
  50%   below 4204ms
  60%   below 4247ms
  70%   below 4304ms
  80%   below 4368ms
  90%   below 4520ms
  95%   below 4620ms
  98%   below 4687ms
  99%   below 4727ms
99.9%   below 4815ms
8021    (RPS: 211.6)
```



```markdown
### java -Xms4g -Xmx4g  -jar .\gateway-server-0.0.1-SNAPSHOT.jar

### 并发量 50

PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 50 -N 30
Starting at 2021/5/18 1:10:49
[Press C to stop the test]
379     (RPS: 10.4)
---------------Finished!----------------
Finished at 2021/5/18 1:12:01 (took 00:01:11.8699628)
Status 303:    379

RPS: 5.7 (requests/second)
Max: 4217ms
Min: 2004ms
Avg: 3583.2ms

  50%   below 4035ms
  60%   below 4042ms
  70%   below 4054ms
  80%   below 4097ms
  90%   below 4153ms
  95%   below 4182ms
  98%   below 4199ms
  99%   below 4210ms
99.9%   below 4217ms

### 并发量 100
PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 100 -N 30
Starting at 2021/5/18 1:12:35
[Press C to stop the test]
760     (RPS: 20.9)
---------------Finished!----------------
Finished at 2021/5/18 1:13:12 (took 00:00:36.5351209)
806     (RPS: 22.1)                     Status 303:    810

RPS: 25.6 (requests/second)
Max: 4227ms
Min: 2012ms
Avg: 3697.9ms

  50%   below 4060ms
  60%   below 4067ms
  70%   below 4077ms
  80%   below 4081ms
  90%   below 4090ms
  95%   below 4094ms
  98%   below 4107ms
  99%   below 4168ms
99.9%   below 4227ms
840     (RPS: 23)8)

### 并发量 200
PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 200 -N 30
Starting at 2021/5/18 1:14:10
[Press C to stop the test]
1620    (RPS: 44.1)
---------------Finished!----------------
Finished at 2021/5/18 1:14:46 (took 00:00:36.8282155)
1621    (RPS: 44.1)                     Status 303:    1621

RPS: 51.1 (requests/second)
Max: 4156ms
Min: 2006ms
Avg: 3569.5ms

  50%   below 4074ms
  60%   below 4082ms
  70%   below 4091ms
  80%   below 4099ms
  90%   below 4107ms
  95%   below 4112ms
  98%   below 4123ms
  99%   below 4134ms
99.9%   below 4152ms
1792    (RPS: 48.7)

### 并发量 500
PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 500 -N 30
Starting at 2021/5/18 1:15:16
[Press C to stop the test]
3551    (RPS: 97.2))
---------------Finished!----------------
3555    (RPS: 97.2)                     Finished at 2021/5/18 1:15:53 (took 00:00:36.6330356)
3862    (RPS: 105.5)                    Status 303:    3863

RPS: 121.7 (requests/second)
Max: 4354ms
Min: 2016ms
Avg: 3864.1ms

  50%   below 4089ms
  60%   below 4105ms
  70%   below 4130ms
  80%   below 4169ms
  90%   below 4219ms
  95%   below 4245ms
  98%   below 4269ms
  99%   below 4282ms
99.9%   below 4345ms
4019    (RPS: 109.8)

### 并发量 1000
PS C:\Users\root> sb -u http://localhost:8808/api/hello -c 1000 -N 30
Starting at 2021/5/18 1:16:55
[Press C to stop the test]
6601    (RPS: 182.3)
---------------Finished!----------------
6637    (RPS: 183.2)                    Finished at 2021/5/18 1:17:31 (took 00:00:36.3033680)
6974    (RPS: 192.5)                    Status 303:    6982
6988    (RPS: 192.9)
7002    (RPS: 193.2)                    RPS: 224 (requests/second)
Max: 5854ms
Min: 2004ms
Avg: 4219ms
7007    (RPS: 193.4)
6995    (RPS: 193)                        50%   below 4353ms
  60%   below 4443ms
  70%   below 4601ms
  80%   below 4815ms
  90%   below 5006ms
  95%   below 5151ms
  98%   below 5301ms
  99%   below 5380ms
99.9%   below 5653ms
7489    (RPS: 206.7)
```

