package consumers;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import static constants.Constants.*;

public class ConsumerDemoAssignSeek {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ConsumerDemoAssignSeek.class.getName());

        // Consumer config
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

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
    }
}
