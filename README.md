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

# 执行测试
执行 ./run.sh
```
mvn clean install
java --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -jar ./dubbo-bug-server/target/dubbo-bug-server-1.0.0-SNAPSHOT.jar --server.port=9000 --dubbo.registry.address=127.0.0.1:2181 &
echo "waiting server start"
sleep 10
java --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -jar ./dubbo-bug-client/target/dubbo-bug-client-1.0.0-SNAPSHOT.jar --server.port=9001 --dubbo.registry.address=127.0.0.1:2181 &
echo "waiting client start"
sleep 10
echo "test"
curl "http://127.0.0.1:9001/test"
echo "clean"
jps  | grep dubbo-bug | awk '{print $1}' | xargs -I {}  kill -9 {}

```



