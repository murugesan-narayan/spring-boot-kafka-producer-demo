# Spring Boot Kafka Producer

    This application demonstrates kafka producer with spring boot.

### Kafka Commands

Download Kafka binaries from [Apache Kafka](https://kafka.apache.org/downloads)

1. Start Zookeeper
```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

2. Start Kafka Server
```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

3. Create Kafka Topic
```bash
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TestTopic
```

4. Verify Message in Kafka Topic
```bash
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TestTopic
```
5. SSL
   
   Ensure that correct port number and ssl keystore and truststore files are used.

### Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

### Test
    Post Url: http://localhost:8081/publish
    Post Data: {"title": "Thirukural", "isbn": "TN11111111"}
[Postman Test File](src/test/data/spring-boot-kafka-prouducer.postman_collection.json)

### Publishing with Partition Distribution
1. We can send message to partition directly.
2. We can send message with key to be used for partition determining
   so that we can maintain the order of the message for the particular key.
3. We can send just message alone, this will use default partition determiner.
