## Consumer demo

Run the [consumer file](ConsumerDemo.java) in one terminal and then execute the producer in another window.

### Producer output

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
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1620696620276
[kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - [Producer clientId=producer-1] Cluster ID: GtjjG4gXSp6ABvtgsd5A5A
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 0
Offset: 216
Timestamp: 1620696622688
Key: record_id_5
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 0
Offset: 217
Timestamp: 1620696622688
Key: record_id_7
# ...
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 81
Timestamp: 1620696622689
Key: record_id_10

Process finished with exit code 0
```

### Consumer output

```bash
[main] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values: 
	allow.auto.create.topics = true
	auto.commit.interval.ms = 5000
	auto.offset.reset = earliest
	bootstrap.servers = [127.0.0.1:9092]
	check.crcs = true
	client.dns.lookup = use_all_dns_ips
	client.id = consumer-hello-world-group-1
	client.rack = 
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = hello-world-group
	group.instance.id = null
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	internal.throw.on.fetch.stable.offset.unsupported = false
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 500
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
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
	session.timeout.ms = 10000
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
	value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version: 2.8.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId: ebb1d6e21cc92130
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1620696567510
[main] INFO org.apache.kafka.clients.consumer.KafkaConsumer - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Subscribed to topic(s): hello_world_topic_partitioned_3
[main] INFO org.apache.kafka.clients.Metadata - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Cluster ID: GtjjG4gXSp6ABvtgsd5A5A
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Discovered group coordinator localhost:9092 (id: 2147483647 rack: null)
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] (Re-)joining group
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] (Re-)joining group
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Successfully joined group with generation Generation{generationId=1, memberId='consumer-hello-world-group-1-fd21b231-caea-4a8b-97f7-87bacb746d85', protocol='range'}
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Finished assignment for group at generation 1: {consumer-hello-world-group-1-fd21b231-caea-4a8b-97f7-87bacb746d85=Assignment(partitions=[hello_world_topic_partitioned_3-0, hello_world_topic_partitioned_3-1, hello_world_topic_partitioned_3-2])}
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Successfully synced group in generation Generation{generationId=1, memberId='consumer-hello-world-group-1-fd21b231-caea-4a8b-97f7-87bacb746d85', protocol='range'}
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Notifying assignor about the new Assignment(partitions=[hello_world_topic_partitioned_3-0, hello_world_topic_partitioned_3-1, hello_world_topic_partitioned_3-2])
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Adding newly assigned partitions: hello_world_topic_partitioned_3-0, hello_world_topic_partitioned_3-2, hello_world_topic_partitioned_3-1
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Found no committed offset for partition hello_world_topic_partitioned_3-0
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Found no committed offset for partition hello_world_topic_partitioned_3-2
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Found no committed offset for partition hello_world_topic_partitioned_3-1
[main] INFO org.apache.kafka.clients.consumer.internals.SubscriptionState - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Resetting offset for partition hello_world_topic_partitioned_3-0 to position FetchPosition{offset=0, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[localhost:9092 (id: 0 rack: null)], epoch=0}}.
[main] INFO org.apache.kafka.clients.consumer.internals.SubscriptionState - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Resetting offset for partition hello_world_topic_partitioned_3-2 to position FetchPosition{offset=0, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[localhost:9092 (id: 0 rack: null)], epoch=0}}.
[main] INFO org.apache.kafka.clients.consumer.internals.SubscriptionState - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Resetting offset for partition hello_world_topic_partitioned_3-1 to position FetchPosition{offset=0, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[localhost:9092 (id: 0 rack: null)], epoch=0}}.
[main] INFO com.github.benji011.kafka.helloworld.ConsumerDemo - Key: null
Value: hello world 0
Partition: 0
Offset: 0

[main] INFO com.github.benji011.kafka.helloworld.ConsumerDemo - Key: null
Value: hello world 1
Partition: 0
Offset: 1

[main] INFO com.github.benji011.kafka.helloworld.ConsumerDemo - Key: null
Value: hello world 2
Partition: 0
Offset: 2

# ...

[main] INFO com.github.benji011.kafka.helloworld.ConsumerDemo - Key: record_id_6
Value: hello world from producer 6
Partition: 1
Offset: 79

[main] INFO com.github.benji011.kafka.helloworld.ConsumerDemo - Key: record_id_8
Value: hello world from producer 8
Partition: 1
Offset: 80

[main] INFO com.github.benji011.kafka.helloworld.ConsumerDemo - Key: record_id_10
Value: hello world from producer 10
Partition: 1
Offset: 81
```