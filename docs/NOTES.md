## Starting Zookeeper

Make sure port `2181` is not being used

```bash
❯ zookeeper-server-start.sh config/zookeeper.properties
[2021-05-10 12:32:24,404] INFO Reading configuration from: config/zookeeper.properties (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
...
[2021-05-10 12:32:24,627] INFO Configuring NIO connection handler with 10s sessionless connection timeout, 1 selector thread(s), 8 worker threads, and 64 kB direct buffers. (org.apache.zookeeper.server.NIOServerCnxnFactory)
[2021-05-10 12:32:24,665] INFO binding to port 0.0.0.0/0.0.0.0:2181 (org.apache.zookeeper.server.NIOServerCnxnFactory)
[2021-05-10 12:32:24,704] INFO zookeeper.snapshotSizeFactor = 0.33 (org.apache.zookeeper.server.ZKDatabase)
[2021-05-10 12:32:24,716] INFO Snapshotting: 0x0 to /tmp/zookeeper/version-2/snapshot.0 (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2021-05-10 12:32:24,724] INFO Snapshotting: 0x0 to /tmp/zookeeper/version-2/snapshot.0 (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2021-05-10 12:32:24,751] INFO PrepRequestProcessor (sid:0) started, reconfigEnabled=false (org.apache.zookeeper.server.PrepRequestProcessor)
[2021-05-10 12:32:24,763] INFO Using checkIntervalMs=60000 maxPerMinute=10000 (org.apache.zookeeper.server.ContainerManager)
```

## Starting Kafka

```bash
❯ kafka-server-start config/server.properties
[2021-05-10 12:39:54,405] INFO Registered kafka:type=kafka.Log4jController MBean (kafka.utils.Log4jControllerRegistration$)
...
[2021-05-10 12:39:58,084] INFO Kafka version: 2.8.0 (org.apache.kafka.common.utils.AppInfoParser)
[2021-05-10 12:39:58,084] INFO Kafka commitId: ebb1d6e21cc92130 (org.apache.kafka.common.utils.AppInfoParser)
[2021-05-10 12:39:58,084] INFO Kafka startTimeMs: 1620617998055 (org.apache.kafka.common.utils.AppInfoParser)
[2021-05-10 12:39:58,097] INFO [KafkaServer id=0] started (kafka.server.KafkaServer)
[2021-05-10 12:39:58,120] INFO [broker-0-to-controller-send-thread]: Recorded new controller, from now on will use broker localhost:9092 (id: 0 rack: null) (kafka.server.BrokerToControllerRequestThread)
```

```bash
❯ tree -C data/
data/
├── kafka
│   ├── cleaner-offset-checkpoint
│   ├── log-start-offset-checkpoint
│   ├── meta.properties
│   ├── recovery-point-offset-checkpoint
│   └── replication-offset-checkpoint
└── zookeeper
    └── version-2
        ├── log.1
        └── snapshot.0
```

## Create

```bash
❯ kafka-topics --bootstrap-server localhost:9092 --topic first_topic --create --partitions 3 --replication-factor 1
WARNING: Due to limitations in metric names, topics with a period ('.') or underscore ('_') could collide. To avoid issues it is best to use either, but not both.
Created topic first_topic.
❯ kafka-topics --zookeeper 127.0.0.1:2181 --list
first_topic

# Leader zero means that broker ID = 0 (kafka service log)

[2021-05-10 13:09:20,928] INFO [Partition first_topic-2 broker=0] Log loaded for partition first_topic-2 with initial high watermark 0 (kafka.cluster.Partition)
[2021-05-10 13:09:20,935] INFO [Log partition=first_topic-1, dir=/Users/benji/kafka_2.13-2.8.0/data/kafka] Loading producer state till offset 0 with message format version 2 (kafka.log.Log)
[2021-05-10 13:09:20,937] INFO Created log for partition first_topic-1 in /Users/benji/kafka_2.13-2.8.0/data/kafka/first_topic-1 with properties {compression.type -> producer, min.insync.replicas -> 1, message.downconversion.enable -> true, segment.jitter.ms -> 0, cleanup.policy -> [delete], flush.ms -> 9223372036854775807, retention.ms -> 604800000, segment.bytes -> 1073741824, flush.messages -> 9223372036854775807, message.format.version -> 2.8-IV1, max.compaction.lag.ms -> 9223372036854775807, file.delete.delay.ms -> 60000, max.message.bytes -> 1048588, min.compaction.lag.ms -> 0, message.timestamp.type -> CreateTime, preallocate -> false, index.interval.bytes -> 4096, min.cleanable.dirty.ratio -> 0.5, unclean.leader.election.enable -> false, retention.bytes -> -1, delete.retention.ms -> 86400000, segment.ms -> 604800000, message.timestamp.difference.max.ms -> 9223372036854775807, segment.index.bytes -> 10485760}. (kafka.log.LogManager)
[2021-05-10 13:09:20,937] INFO [Partition first_topic-1 broker=0] Log loaded for partition first_topic-1 with initial high watermark 0 (kafka.cluster.Partition)
[2021-05-10 13:09:20,947] INFO [Log partition=first_topic-0, dir=/Users/benji/kafka_2.13-2.8.0/data/kafka] Loading producer state till offset 0 with message format version 2 (kafka.log.Log)
[2021-05-10 13:09:20,949] INFO Created log for partition first_topic-0 in /Users/benji/kafka_2.13-2.8.0/data/kafka/first_topic-0 with properties {compression.type -> producer, min.insync.replicas -> 1, message.downconversion.enable -> true, segment.jitter.ms -> 0, cleanup.policy -> [delete], flush.ms -> 9223372036854775807, retention.ms -> 604800000, segment.bytes -> 1073741824, flush.messages -> 9223372036854775807, message.format.version -> 2.8-IV1, max.compaction.lag.ms -> 9223372036854775807, file.delete.delay.ms -> 60000, max.message.bytes -> 1048588, min.compaction.lag.ms -> 0, message.timestamp.type -> CreateTime, preallocate -> false, index.interval.bytes -> 4096, min.cleanable.dirty.ratio -> 0.5, unclean.leader.election.enable -> false, retention.bytes -> -1, delete.retention.ms -> 86400000, segment.ms -> 604800000, message.timestamp.difference.max.ms -> 9223372036854775807, segment.index.bytes -> 10485760}. (kafka.log.LogManager)
[2021-05-10 13:09:20,953] INFO [Partition first_topic-0 broker=0] Log loaded for partition first_topic-0 with initial high watermark 0 (kafka.cluster.Partition)
[2021-05-10 13:09:33,951] INFO [Log partition=first_topic-0, dir=/Users/benji/kafka_2.13-2.8.0/data/kafka] Deleting segments as the log has been deleted: LogSegment(baseOffset=0, size=0, lastModifiedTime=1620619707125, largestRecordTimestamp=None) (kafka.log.Log)
[2021-05-10 13:09:33,953] INFO [Log partition=first_topic-0, dir=/Users/benji/kafka_2.13-2.8.0/data/kafka] Deleting segment files LogSegment(baseOffset=0, size=0, lastModifiedTime=1620619707125, largestRecordTimestamp=None) (kafka.log.Log)
```

## Creating a 2nd topic

```bash
❯ kafka-topics --zookeeper 127.0.0.1:2181 --topic second_topic --create --partitions 6 --replication-factor 1
WARNING: Due to limitations in metric names, topics with a period ('.') or underscore ('_') could collide. To avoid issues it is best to use either, but not both.
Created topic second_topic.
# ...
❯ kafka-topics --bootstrap-server localhost:9092 --delete --topic second_topic
❯ kafka-topics --zookeeper 127.0.0.1:2181 --topic second_topic --describe
Topic: second_topic	TopicId: 9B-klJBtRQySzjNf0MLZYw	PartitionCount: 6	ReplicationFactor: 1	Configs:
	Topic: second_topic	Partition: 0	Leader: 0	Replicas: 0	Isr: 0
	Topic: second_topic	Partition: 1	Leader: 0	Replicas: 0	Isr: 0
	Topic: second_topic	Partition: 2	Leader: 0	Replicas: 0	Isr: 0
	Topic: second_topic	Partition: 3	Leader: 0	Replicas: 0	Isr: 0
	Topic: second_topic	Partition: 4	Leader: 0	Replicas: 0	Isr: 0
	Topic: second_topic	Partition: 5	Leader: 0	Replicas: 0	Isr: 0
```

## Describe

```bash
❯ kafka-topics --bootstrap-server localhost:9092 --describe first_topic
Topic: first_topic	TopicId: L1sC_WzMRF6hJKreJQL4OQ	PartitionCount: 1	ReplicationFactor: 1	Configs: segment.bytes=1073741824
	Topic: first_topic	Partition: 0	Leader: 0	Replicas: 0	Isr: 0
# ...
❯ kafka-topics --zookeeper 127.0.0.1:2181 --topic first_topic --describe
Topic: first_topic	TopicId: hm2U55Y3R9ap5hAtXw6qJg	PartitionCount: 3	ReplicationFactor: 1	Configs:
	Topic: first_topic	Partition: 0	Leader: 0	Replicas: 0	Isr: 0
	Topic: first_topic	Partition: 1	Leader: 0	Replicas: 0	Isr: 0
	Topic: first_topic	Partition: 2	Leader: 0	Replicas: 0	Isr: 0
```

## Delete

```bash
❯ kafka-topics --bootstrap-server localhost:9092 --delete --topic first_topic
```
