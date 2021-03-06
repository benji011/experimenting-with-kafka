## Mapping with keys

### The topic

| Name  | `hello_world_topic_partitioned_3`  |
|---|---|
| Partitions  | `3`  |


```bash
❯ kafka-topics --zookeeper 127.0.0.1:2181 --topic hello_world_topic_partitioned_3 --describe
Topic: hello_world_topic_partitioned_3	TopicId: temWo4vERc6z-yhmVS2zBA	PartitionCount: 3	ReplicationFactor: 1	Configs:
	Topic: hello_world_topic_partitioned_3	Partition: 0	Leader: 0	Replicas: 0	Isr: 0
	Topic: hello_world_topic_partitioned_3	Partition: 1	Leader: 0	Replicas: 0	Isr: 0
	Topic: hello_world_topic_partitioned_3	Partition: 2	Leader: 0	Replicas: 0	Isr: 0
```
Refactored the `ProducerRecord` to accept a key value which now maps a record sent to a different partition

```java
// ...
String topic = "hello_world_topic_partitioned_3";
String key = "record_id_" + Integer.toString(i);
String value = "hello world " + Integer.toString(i);
ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
```

### Output

From the consumer side

```bash
❯ kafka-console-consumer --bootstrap-server localhost:9092 --topic hello_world_topic_partitioned_3 --group my-first-application
hello world 5
hello world 7
hello world 9
hello world 0
hello world 1
hello world 2
hello world 3
hello world 4
hello world 6
hello world 8
hello world 10
```

Log from the producer:

```bash
[main] INFO org.apache.kafka.clients.producer.ProducerConfig - ProducerConfig values: 
	acks = 1
	batch.size = 16384
	bootstrap.servers = [127.0.0.1:9092]
	buffer.memory = 33554432
	client.dns.lookup = use_all_dns_ips
	client.id = producer-1
	compression.type = none
	connections.max.idle.ms = 540000
	delivery.timeout.ms = 120000
	enable.idempotence = false
	interceptor.classes = []
	internal.auto.downgrade.txn.commit = false
	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
	linger.ms = 0
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metadata.max.idle.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 2147483647
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	security.providers = null
	send.buffer.bytes = 131072
	socket.connection.setup.timeout.max.ms = 30000
	socket.connection.setup.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2]
	ssl.endpoint.identification.algorithm = https
	ssl.engine.factory.class = null
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.certificate.chain = null
	ssl.keystore.key = null
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLSv1.2
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.certificates = null
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.StringSerializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version: 2.8.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId: ebb1d6e21cc92130
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1620694959290
[kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - [Producer clientId=producer-1] Cluster ID: GtjjG4gXSp6ABvtgsd5A5A
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 0
Offset: 213
Timestamp: 1620694961208
Key: record_id_5
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 0
Offset: 214
Timestamp: 1620694961208
Key: record_id_7
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 0
Offset: 215
Timestamp: 1620694961209
Key: record_id_9
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 2
Offset: 79
Timestamp: 1620694961170
Key: record_id_0
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 2
Offset: 80
Timestamp: 1620694961207
Key: record_id_1
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 70
Timestamp: 1620694961207
Key: record_id_2
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 71
Timestamp: 1620694961208
Key: record_id_3
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 72
Timestamp: 1620694961208
Key: record_id_4
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 73
Timestamp: 1620694961208
Key: record_id_6
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 74
Timestamp: 1620694961209
Key: record_id_8
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 75
Timestamp: 1620694961209
Key: record_id_10

Process finished with exit code 0
```