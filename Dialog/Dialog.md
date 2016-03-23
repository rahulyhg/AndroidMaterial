#dialog性能结果

##创建速度 
1s=1000ms=1000000微秒(us)=1000000000纳秒(ns)

- 使用构造者模式 1ms
- 普通模式 1ms

##内存占用

- 0.01M 改造
- 0.04M 普通

##不存在内存泄露

##改进措施
edu.ptu.dialog.DialogHeaderAdapter 做个简单的实现，如SimpleHeaderAdapter，可以传入简单的数据，标题，是否显示关闭对话框