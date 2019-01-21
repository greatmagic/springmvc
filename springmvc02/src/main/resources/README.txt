这个springmvc框架已经基本够用；
包含过滤器，监听器，定时任务，文件上传等功能
整个框架 mybatis,druid,
缺陷：对象封装不严格，前后端传参没有经过映射包装，handler也没有处理
jdk版本：jdk1.7
新增：1.jndi druid配置，在webapp/META-INF下配置context.xml
    2.mybatis别名配置文件