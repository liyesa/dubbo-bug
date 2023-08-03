# 测试代码说明
service result类，包含4个boolean属性，两个默认值为true
```
public class Foo implements Serializable {
    boolean success = true;
    boolean success1 = true;    
    boolean success2;
    boolean success3;
    String message;
    
    // getter,setter
    ...

```
DubboService将4个boolean属性全部设置为false，并返回
```
@DubboService
public class TestServiceImpl implements TestService {
    @Override
    public Foo foo() {
        Foo c = new Foo();
        c.setSuccess(false);
        c.setSuccess1(false);
        c.setSuccess2(false);
        c.setSuccess3(false);
        c.setMessage("success");
        return c;
    }
}
```
bug: 返回解决，默认值为true的属性，接口返回值为true，而不是service设置的false 
```
{"success":true,"success1":true,"success2":false,"success3":false,"message":"success"}
```

# 编译
mvn clean install
# 启动server
java --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -jar target/dubbo-bug-1.0.0-SNAPSHOT.jar --server.port=9000
# 作为client重新编译启动
# 先注释掉TestServiceImpl.java的@DubboService
# 编译
mvn clean install
# 启动client,http port 9001
java --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -jar target/dubbo-bug-1.0.0-SNAPSHOT.jar --server.port=9001
# 测试，重新bug
curl 0:9001/test
返回结果：其中success，success1应该为false
```
{"success":true,"success1":true,"success2":false,"success3":false,"message":"success"}%
```
# 补充
1. 使用dubbo admin和telnet调用，结果正确
2. 修改preferSerialization为hessian2，结果正确





