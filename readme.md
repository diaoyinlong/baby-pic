# Baby Picture 简介

小宝宝的照片管理系统,支持根据年龄段上传并查询照片

![avatar](https://tva4.sinaimg.cn/large/005R6Otmgy1g6fdmc5xcmj31f50guaqp.jpg)
![avatar](https://ws3.sinaimg.cn/large/005R6Otmgy1g6fdme08zbj31f30h27ek.jpg)

## 技术栈
### 前端

```
iview+vue2.0+webpack
```

### 后端

```
springboot+mybatis+mysql
```

## 使用说明
- 将目录内的data.sql数据结构导入数据库

```
mysql  -uusername -ppassword database < data.sql
```

- 修改application.yaml的数据库和文件上传目录

```
src/main/resources/application.yaml
```


- 使用maven进行build

```
mvn clean install
```

- 启动项目

```
java -jar target/open-service-release.jar
```

- 浏览器访问

```
http://localhost:8080/qiqi
```