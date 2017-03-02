1\ api-common 常用类聚合
   配置项,错误码,共工方法,redis缓存,异常处理等)

TODO:请求上下行数据压缩处理,缓存处理

2.10版本功能点:
1\封号处理
2\消息中心

一、 挑战统计协议:
统计编码||设备(1 android 2 ios)||phead头消息(非必填)||用户Id||统计Id||业务Id
20001||1||device_no||imei||channel_name||lang||net||local||account_Id||统计Id||业务Id

               统计Id||业务Id
挑战详情页的展示  01||挑战Id
查看详情的点击    02||挑战Id
查看结果按钮非底  03||挑战Id
查看结果按钮底    04||挑战Id
日历上的挑战卡    05||挑战Id

社交-精选中每个 banner展示    06||位置Id
社交-精选中每个 banner点击    07||位置Id


精选中的合集封面展示    08||合集 id
精选中的合集封面点击    09||合集 id


统计服务器相关协议

统计编码||设备(1 android 2 ios)||phead头消息(非必填)|| eg: 0001||1||device_no||imei||channel_name||lang||net||local
统计编码: 分享302: 00001 官网下载: 00002 浙大活动: 00003

挑战统计协议: 统计编码||设备(1 android 2 ios)||phead头消息(非必填)||用户Id||统计Id||业务Id
20001||1||device_no||imei||channel_name||lang||net||local||account_Id||统计Id||业务Id