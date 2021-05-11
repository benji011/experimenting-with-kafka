## Consumer demo for assign & seek

Assign and seek are mostly used to replay data or fetch a specific message.

### Modified consumer

```java
        // Create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Assign to a consumer a partition to read from
        TopicPartition partitionToReadFrom = new TopicPartition(TOPIC, 0);
        consumer.assign(Collections.singletonList(partitionToReadFrom));

        // Seek consumer
        long offsetToReadFrom = 20L;
        consumer.seek(partitionToReadFrom, offsetToReadFrom);

        // Poll in for new data
        int numberOfMessagesToRead = 5;
        int numberOfMessagesReadSoFar = 0;
        boolean keepOnReading = true;
        while(keepOnReading) {
            try {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record: records) {
                    logger.info("Key: " + record.key() + "\n"
                            + "Value: " + record.value() + "\n"
                            + "Partition: " + record.partition() + "\n"
                            + "Offset: " + record.offset() + "\n"
                    );
                    numberOfMessagesReadSoFar += 1;
                    // Break out of this while look if we went past the `numberOfMessagesToRead` threshold
                    if (numberOfMessagesReadSoFar >= numberOfMessagesToRead) {
                        keepOnReading = false;
                        break;
                    }
                }
            } catch(Exception e) {
                logger.error("An exception occurred: ", e);
            }
        }
        logger.info("Exiting the application");
```

### Output

```bash
[main] INFO org.apache.kafka.clients.consumer.KafkaConsumer - [Consumer clientId=consumer-null-1, groupId=null] Subscribed to partition(s): hello_world_topic_partitioned_3-0
[main] INFO org.apache.kafka.clients.consumer.KafkaConsumer - [Consumer clientId=consumer-null-1, groupId=null] Seeking to offset 20 for partition hello_world_topic_partitioned_3-0
[main] INFO org.apache.kafka.clients.Metadata - [Consumer clientId=consumer-null-1, groupId=null] Cluster ID: GtjjG4gXSp6ABvtgsd5A5A
[main] INFO consumers.ConsumerDemoAssignSeek - Key: null
Value: hello world 0
Partition: 0
Offset: 20

[main] INFO consumers.ConsumerDemoAssignSeek - Key: null
Value: hello world 1
Partition: 0
Offset: 21

[main] INFO consumers.ConsumerDemoAssignSeek - Key: null
Value: hello world 2
Partition: 0
Offset: 22

[main] INFO consumers.ConsumerDemoAssignSeek - Key: null
Value: hello world 3
Partition: 0
Offset: 23

[main] INFO consumers.ConsumerDemoAssignSeek - Key: null
Value: hello world 4
Partition: 0
Offset: 24

[main] INFO consumers.ConsumerDemoAssignSeek - Exiting the application

Process finished with exit code 0

```