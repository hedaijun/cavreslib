项目文件
一、src  
1、com.cavlib.beans：编写数据模型类    命名例子：User
2、com.cavlib.dao(接口)：数据模型操作接口    命名例子：UserMapper
3、com.cavlib.handler:处理url请求,控制器    命名例子：UserController
4、com.cavlib.service:业务逻辑    命名例子：UserService

每人在controller包下面建自己的业务包放自己的业务controller

统一用注解配置controller,使用@Controller("\XXX")标注自己的业务