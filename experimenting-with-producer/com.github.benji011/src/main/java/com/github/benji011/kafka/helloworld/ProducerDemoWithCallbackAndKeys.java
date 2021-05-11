package com.github.benji011.kafka.helloworld;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoWithCallbackAndKeys {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallbackAndKeys.class);
        String bootstrapServers = "127.0.0.1:9092";

        // Create producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // Create producer record
        for (int i = 0; i <=10; i++) {
            String topic = "hello_world_topic_partitioned_3";
            String key = "record_id_" + Integer.toString(i);
            String value = "hello world " + Integer.toString(i);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);

            // Send data with callback to execute everytime a record is sent successfully
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        logger.error("Error while producing: ", e);
                    } else {
                        logger.info("Metadata received: \n"
                                + "Topic: " + recordMetadata.topic()  + "\n"
                                + "Partition: " + recordMetadata.partition() + "\n"
                                + "Offset: " + recordMetadata.offset() + "\n"
                                + "Timestamp: " + recordMetadata.timestamp() + "\n"
                                + "Key: " + key
                        );
                    }
                }
            });
        }

        // Flush & close
        producer.flush();
    }
}
