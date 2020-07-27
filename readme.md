# 说明
1. 集成了JWT的用户登录认证
2. 集成SSO登录
3. 说明如何用OAuth2.0实现登录认证
4. 关于IAM系统的总体情况说明文档

# 如何运行本项目
1. 在 src/main/resources/sql下找到init.sql，运行，创建数据库及表
2. git clone 本项目
3. 在Idea运行本项目就可以了

# 目录结构介绍
```text
├─test
|  ├─java
|  |  ├─com
|  |  |  ├─lxh
|  |  |  |  ├─iam
|  |  |  |  |  ├─IamKeycloakApplicationTests.java   # 代码生成文件
|  |  |  |  |  ├─controller
|  |  |  |  |  |     └UserControllerTest.java #单元测试
├─main
|  ├─resources
|  |     ├─application.yml # 配置文件
|  |     ├─templates
|  |     ├─static
|  |     ├─sql
|  |     |  └init.sql # 初始化数据库的SQL
|  |     ├─mapper   # mapper文件，自动生成的
|  |     |   ├─RoleMapper.xml
|  |     |   ├─UserMapper.xml
|  |     |   ├─UserRoleMapper.xml
|  ├─java
|  |  ├─com
|  |  |  ├─lxh
|  |  |  |  ├─iam
|  |  |  |  |  ├─IamKeycloakApplication.java
|  |  |  |  |  ├─utils
|  |  |  |  |  |   ├─BaseEntity.java  # entity的基类
|  |  |  |  |  |   ├─CommonEnum.java # 枚举的基类
|  |  |  |  |  |   ├─ErrorController.java # 错误处理的controller 
|  |  |  |  |  |   ├─IBaseErrorInfo.java # 枚举基础类的基类
|  |  |  |  |  |   ├─JwtTokenUtil.java # jwt工具类
|  |  |  |  |  |   ├─ResultBody.java # 返回结果
|  |  |  |  |  |   └SecurityUserService.java # 用户登录的Service
|  |  |  |  |  ├─service
|  |  |  |  |  |    ├─IRoleService.java
|  |  |  |  |  |    ├─IUserRoleService.java
|  |  |  |  |  |    ├─IUserService.java
|  |  |  |  |  |    ├─impl
|  |  |  |  |  |    |  ├─RoleServiceImpl.java
|  |  |  |  |  |    |  ├─UserRoleServiceImpl.java
|  |  |  |  |  |    |  └UserServiceImpl.java
|  |  |  |  |  ├─mapper
|  |  |  |  |  |   ├─RoleMapper.java
|  |  |  |  |  |   ├─UserMapper.java
|  |  |  |  |  |   └UserRoleMapper.java
|  |  |  |  |  ├─filter
|  |  |  |  |  |   ├─ExceptionFilter.java # filter异常处理
|  |  |  |  |  |   └JwtTokenFilter.java # 用来处理登录认证
|  |  |  |  |  ├─exception
|  |  |  |  |  |     └BizException.java # 系统异常
|  |  |  |  |  ├─entity
|  |  |  |  |  |   ├─Role.java
|  |  |  |  |  |   ├─User.java
|  |  |  |  |  |   └UserRole.java
|  |  |  |  |  ├─dto
|  |  |  |  |  |  └UserDto.java # 实现了UserDetails接口，实现用户登录
|  |  |  |  |  ├─controller
|  |  |  |  |  |     ├─RoleController.java
|  |  |  |  |  |     ├─TestController.java
|  |  |  |  |  |     ├─UserController.java
|  |  |  |  |  |     └UserRoleController.java
|  |  |  |  |  ├─config
|  |  |  |  |  |   ├─MybatisPlusConfig.java # MybatisPlus的配置类
|  |  |  |  |  |   └WebSecurityConfig.java # web配置类
|  |  |  |  |  ├─comm
|  |  |  |  |  |  └Const.java
|  |  |  |  |  ├─advice
|  |  |  |  |  |   └ActionAdvice.java # controller advice
```