#dialog性能结果

##创建速度 
1s=1000ms=1_000_000微秒(us)=1_000_000_000纳秒(ns)

- 使用构造者模式 23_483_797ns（纳秒）
- 普通模式 6_361_999ns
| 构造 | 普通模式 |
| :---------: | :----------: |
| 23_483_797 | 6_361_999 |
| 9_528_907 | 6_826_823 |
| 13_932_400 | 15_802_398 |
| 22_274_060 | 18_713_852 |
| 26_516_611 | 9_817_291 |

##内存占用

- 0.01M 改造
- 0.04M 普通

##不存在内存泄露

##改进措施
edu.ptu.dialog.custom.DialogHeaderAdapter 做个简单的实现，如SimpleHeaderAdapter，可以传入简单的数据，标题，是否显示关闭对话框

##设计模式
想要把对话框进行拆分设计,保证只传入数据，数据与界面拆分开，可以在加入 **显示位置**，**进入退出动画**