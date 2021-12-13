# Native Crash

本文主要是记录一些Android 中的Native Crash的分析手段和排查方法

## Native Crash 分类

[ARM kernal](https://android.googlesource.com/kernel/msm/+/5ab48a77f046dfd88aaabf5a1cd5c3000e69d3e0/arch/arm/mm)

先了解一下分类

| 取值 | 名称 | 解释 |
|  ----  | ----  | ---- |
1 | SIGHUP | 挂起 |  
2 | SIGINT | 中断 |  
3 | SIGQUIT | 退出 |  
4 | SIGILL | 非法指令 |  
5 | SIGTRAP | 断点或陷阱指令 |  
6 | SIGABRT | abort发出的信号 |  
7 | SIGBUS | 非法内存访问 |  
8 | SIGFPE | 浮点异常 |  
9 | SIGKILL | kill信号 | 不能被忽略、处理和阻塞
10 | SIGUSR1 | 用户信号1 |  
11 | SIGSEGV | 无效内存访问 |  
12 | SIGUSR2 | 用户信号2 |  
13 | SIGPIPE | 管道破损，没有读端的管道写数据 |  
14 | SIGALRM | alarm发出的信号 |  
15 | SIGTERM | 终止信号 |  
16 | SIGSTKFLT | 栈溢出 |  
17 | SIGCHLD | 子进程退出 | 默认忽略
18 | SIGCONT | 进程继续 |  
19 | SIGSTOP | 进程停止 | 不能被忽略、处理和阻塞
20 | SIGTSTP | 进程停止 |  
21 | SIGTTIN | 进程停止，后台进程从终端读数据时 |  
22 | SIGTTOU | 进程停止，后台进程想终端写数据时 |  
23 | SIGURG | I/O有紧急数据到达当前进程 | 默认忽略
24 | SIGXCPU | 进程的CPU时间片到期 |  
25 | SIGXFSZ | 文件大小的超出上限 |  
26 | SIGVTALRM | 虚拟时钟超时 |  
27 | SIGPROF | profile时钟超时 |  
28 | SIGWINCH | 窗口大小改变 | 默认忽略
29 | SIGIO | I/O相关 |  
30 | SIGPWR | 关机 | 默认忽略
31 | SIGSYS | 系统调用异常 |  


## 上手！