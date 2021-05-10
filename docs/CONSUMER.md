## Consumer

In 1 terminal, launch the producer

```bash
❯ kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic
>This is where messages are being produced, and will be sent to the consumer
>
```

In another terminal, launch the consumer. Any messages sent from the producer will appear here

```bash
❯ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic
This is where messages are being produced, and will be sent to the consumer
```

## Consumer group

Sending messages to multiple consumers with a consumer group `my-first-application`

```bash
# Producer
❯ kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic
>Hello new consumer
>

# Consumer 1
❯ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application
# Consumer 2
❯ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application
# Consumer 3
❯ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application
```

<p align="center">
<img src="./img/1-producer-3-consumers.png">
</p>

## Messages consumed unordered

```bash
# Producer sends ..
>hmmm,
>well this is interesting
>last time this wasnt in order
>so what would happen now if i set --from-beginning?
>

# But consume recieves ..
❯ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-second-application --from-beginning
so what would happen now if i set --from-beginning?
well this is interesting
hmmm,
last time this wasnt in order
```

## Resetting offsets

```bash
❯ kafka-consumer-groups --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --to-earliest --execute --topic first_topic

GROUP                          TOPIC                          PARTITION  NEW-OFFSET
my-first-application           first_topic                    0          0
my-first-application           first_topic                    1          0
my-first-application           first_topic                    2          0
```

Resetting all offsets to the earliest:

```bash
❯ kafka-consumer-groups --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --to-earliest --execute --topic first_topic
```

Executing consumer `first_topic` topic with the group `my-first-application` results:

```bash
❯ kafka-console-consumer --bootstrap-server localhost:9092 --topic first_topic --group my-first-application
Learning Kafka
Set producer property acks=all
Hi how is it going?
plauy play play
test
yay
message 2
message a
yello
blue
test
test
4
5
6
5
6
7
a
b
c
m
n
r
s
t
w
x
1
2
3
45
1
2
3
1
2
3
4
5
side
these messages will be kept in kafka and wont appear until a consumer has started
so what would happen now if i set --from-beginning?
test
wewew
Hello Benji
YEYEYEYEYEYEYEYE
btw really cool
test
hi
This is where messages are being produced, and will be sent to the consumer
message 1
message b
message d
red
1
2
3
4
10
11
12
d
e
f
j
k
l
5
6
7
8
4
4
1
2
3
4
4
hello again
1
2
3
4
1.2.3
okay lets start from the beginning
well this is interesting
whut
test test test
Juist another message :)
This is a new message
yeyeyeyeyeyeyeyey
test
Hello new consumer
message 3
message c
1
2
3
8
9
13
g
h
i
o
p
q
u
v
y
z
5
6
5
from the other
hmmm,
last time this wasnt in order
```

## Shifting by 2 offsets

```bash
❯ kafka-consumer-groups --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --shift-by 2 --execute --topic first_topic
[2021-05-10 17:15:55,087] WARN New offset (47) is higher than latest offset for topic partition first_topic-0. Value will be set to 45 (kafka.admin.ConsumerGroupCommand$)
[2021-05-10 17:15:55,087] WARN New offset (45) is higher than latest offset for topic partition first_topic-1. Value will be set to 43 (kafka.admin.ConsumerGroupCommand$)
[2021-05-10 17:15:55,087] WARN New offset (33) is higher than latest offset for topic partition first_topic-2. Value will be set to 31 (kafka.admin.ConsumerGroupCommand$)

GROUP                          TOPIC                          PARTITION  NEW-OFFSET
my-first-application           first_topic                    0          45
my-first-application           first_topic                    1          43
my-first-application           first_topic                    2          31
```

Shift backwards instead:

```bash
❯ kafka-consumer-groups --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --shift-by -2 --execute --topic first_topic

GROUP                          TOPIC                          PARTITION  NEW-OFFSET
my-first-application           first_topic                    0          43
my-first-application           first_topic                    1          41
my-first-application           first_topic                    2          29
```
