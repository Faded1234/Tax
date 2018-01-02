总结

1、搭建SSH；加载日志记录工具log4j(debug,info,warn,error,fatal)；分类源文件夹（src源代码，config配置文件，test测试源代码） 用户管理（entity,dao,service,action,conf）；日期选择工具Wdatepicker.js

2、POI导入导出Excel ① 操作工作簿 ② 操作工作表 ③ 操作行 ④ 操作单元格 样式是属于工作簿；运用于单元格。合并单元格对象（CellRangeAddress）运用于工作表。字体是属于工作簿，加载于样式，通过样式运用单元格

3、用户帐号唯一性校验（ajax ,async的值为false表示非异步请求）；定义全局异常映射（ServiceException,ActionException）,定义全局返回结果类型（需要继承StrutsResultSupport）

4、角色与权限的关系（多对多：一个角色可以有多个权限，一个权限可被多个角色使用）；用户与角色的关系（多对多：一个用户有多个角色，一个角色可被多个用户使用） checkboxlist(接受集合)

5、登录（根据用户帐号和密码查询用户，将用户信息设置到session中）； 登录过滤器：①判断当前请求是否是登录请求 ② 如果是非登录请求则判断session中是否存在用户信息如果存在则说明已经登录放行，否则跳转到登录页面；如果是登录请求直接放行 权限鉴定：前提条件：已经登录。根据访问系统的标识和用户信息；判断该用户是否包含有访问系统的权限。WebApplicationContextUtils

6、信息发布管理（ueditor，异步信息发布=更新信息状态）

7、hibernate逆向工程 ① 根据需求分析创建cdm/pdm ② 根据pdm里面的数据库建表语句创建数据库表 ③ 添加Hibernate能力，根据数据库表逆向生成实体及其映射文件

8、查询助手（QueryHelper） ① 查询hql语句（from子句+where子句+order by子句） ② 查询语句中对应的?对应的查询条件值集合

9、分页对象（PageResult） 总记录数，当前页号，页大小，总页数，记录列表

10、投诉受理（需求分析，edraw max画出流程图，利用power designer设计cdm/pdm，逆向工程） 我要投诉（根据部门查该部门下的用户列表：① 直接使用输出流输出Json格式字符串 ② 使用struts-json-plugin.jar自动将对象转为json格式字符串；root）

11、任务调度框架（Quartz） ① 制定任务详细信息（执行对象，对象中方法，是否可并发执行） ② 制定任务执行时机触发器（SimpleTrigger,CronTrigger） ③ 设置任务调度工厂

12、统计图表（Fusioncharts） 可以展示大部分的统计图（柱状图，饼图，线图...）

-------------------------------------------------------------------------工具列表 1、WDatepicker.js 日期选择组件 2、POI 操作Excel 3、ueditor 富文本编辑器 4、edraw Max 画流程图等图形 5、power designer 设计cdm/pdm... 6、IBM Rational Rose 对象设计工具（类图、用例图、时序图） 7、Hi Json 格式化Json字符串 8、quartz 定时任务调度 9、fusioncharts 统计图表工具组件 10、*** 11、***
