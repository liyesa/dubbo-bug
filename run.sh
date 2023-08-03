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
