# struts2-spring-hibernate
struts整合spring和hibernate的模板
 - ide是eclipse
 - 使用JDK8
 - struts.version=2.5.20
 - spring.version=5.1.8.RELEASE
 - hibernate.version=5.4.3.Final
 - 使用mysql连接，当然可以在jdbc.properties修改使用Oracle驱动
 - 对于struts的配置在struts.xml文件中说明，按需修改
 - 只实现登录注册、登录拦截和上传功能，user表结构在\src\main\resources\sqlscript\user.sql
 - action类实现模型驱动ModelDriven，把参数封装到全局对象
 - 这是最简洁的框架模型，其他功能比如日志等需要自己添加
 - 下载解压后如果项目名称有-master结尾，去掉再导入

