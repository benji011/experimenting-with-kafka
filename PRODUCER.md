```bash
❯ kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic
>Hello Benji
>test test test
>Learning Kafka
>Juist another message :)
```

## New topic

Always create a new topic before hand

```bash
❯ kafka-console-producer -broker-list 127.0.0.1:9092 --topic new_topic
>Hey this topic doesnt exist
[2021-05-10 16:34:30,584] WARN [Producer clientId=console-producer] Error while fetching metadata with correlation id 3 : {new_topic=LEADER_NOT_AVAILABLE} (org.apache.kafka.clients.NetworkClient)
>Another message
>

#...

[2021-05-10 16:34:30,526] INFO Creating topic new_topic with configuration {} and initial partition assignment HashMap(0 -> ArrayBuffer(0)) (kafka.zk.AdminZkClient)
[2021-05-10 16:34:30,641] INFO [ReplicaFetcherManager on broker 0] Removed fetcher for partitions Set(new_topic-0) (kafka.server.ReplicaFetcherManager)
[2021-05-10 16:34:30,659] INFO [Log partition=new_topic-0, dir=/Users/benji/kafka_2.13-2.8.0/data/kafka] Loading producer state till offset 0 with message format version 2 (kafka.log.Log)
[2021-05-10 16:34:30,667] INFO Created log for partition new_topic-0 in /Users/benji/kafka_2.13-2.8.0/data/kafka/new_topic-0 with properties {compression.type -> producer, min.insync.replicas -> 1, message.downconversion.enable -> true, segment.jitter.ms -> 0, cleanup.policy -> [delete], flush.ms -> 9223372036854775807, retention.ms -> 604800000, segment.bytes -> 1073741824, flush.messages -> 9223372036854775807, message.format.version -> 2.8-IV1, max.compaction.lag.ms -> 9223372036854775807, file.delete.delay.ms -> 60000, max.message.bytes -> 1048588, min.compaction.lag.ms -> 0, message.timestamp.type -> CreateTime, preallocate -> false, index.interval.bytes -> 4096, min.cleanable.dirty.ratio -> 0.5, unclean.leader.election.enable -> false, retention.bytes -> -1, delete.retention.ms -> 86400000, segment.ms -> 604800000, message.timestamp.difference.max.ms -> 9223372036854775807, segment.index.bytes -> 10485760}. (kafka.log.LogManager)
[2021-05-10 16:34:30,668] INFO [Partition new_topic-0 broker=0] No checkpointed highwatermark is found for partition new_topic-0 (kafka.cluster.Partition)
[2021-05-10 16:34:30,669] INFO [Partition new_topic-0 broker=0] Log loaded for partition new_topic-0 with initial high watermark 0 (kafka.cluster.Partition)
```

## After setting `num.partitions=3`

```bash
❯ kafka-console-producer -broker-list 127.0.0.1:9092 --topic new_topic_2
>This is a new topic called new_topic_2
[2021-05-10 16:37:15,374] WARN [Producer clientId=console-producer] Error while fetching metadata with correlation id 3 : {new_topic_2=LEADER_NOT_AVAILABLE} (org.apache.kafka.clients.NetworkClient)
>Warning should go away now
>^C%
❯ kafka-topics --zookeeper 127.0.0.1:2181 --topic new_topic_2 --describe
Topic: new_topic_2	TopicId: W4_XvwQZRMWH9g9bSBY6bA	PartitionCount: 3	ReplicationFactor: 1	Configs:
	Topic: new_topic_2	Partition: 0	Leader: 0	Replicas: 0	Isr: 0
	Topic: new_topic_2	Partition: 1	Leader: 0	Replicas: 0	Isr: 0
	Topic: new_topic_2	Partition: 2	Leader: 0	Replicas: 0	Isr: 0
```
