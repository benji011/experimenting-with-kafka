## Hello World Kafka demo

A small demo on running Kafka locally. WIP directory structure looks like below.

```bash
❯ tree -C com.github.benji011/src/main/java/com/github/benji011/kafka/helloworld
├── README.md
├── constants
│   └── Constants.java
├── consumers
│   ├── ConsumerDemo.java
│   └── README.md
└── producers
    ├── PRODUCER_WITH_KEYS.md
    ├── ProducerDemo.java
    ├── ProducerDemoWithCallback.java
    ├── ProducerDemoWithCallbackAndKeys.java
    └── README.md
```

### Usage

Run `consumers/ConsumerDemo.java` in one window

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
    # ...
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Setting offset for partition hello_world_topic_partitioned_3-2 to the committed offset FetchPosition{offset=83, offsetEpoch=Optional[0], currentLeader=LeaderAndEpoch{leader=Optional[localhost:9092 (id: 0 rack: null)], epoch=0}}
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-hello-world-group-1, groupId=hello-world-group] Setting offset for partition hello_world_topic_partitioned_3-1 to the committed offset FetchPosition{offset=82, offsetEpoch=Optional[0], currentLeader=LeaderAndEpoch{leader=Optional[localhost:9092 (id: 0 rack: null)], epoch=0}}
```

And in another run either producers from `com.github.benji011.kafka.helloworld.producers`

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
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1620697433963
[kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - [Producer clientId=producer-1] Cluster ID: GtjjG4gXSp6ABvtgsd5A5A
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.producers.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 0
Offset: 219
Timestamp: 1620697435573
Key: record_id_5
# ...
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.producers.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 86
Timestamp: 1620697435574
Key: record_id_8
[kafka-producer-network-thread | producer-1] INFO com.github.benji011.kafka.helloworld.producers.ProducerDemoWithCallbackAndKeys - Metadata received: 
Topic: hello_world_topic_partitioned_3
Partition: 1
Offset: 87
Timestamp: 1620697435574
Key: record_id_10
```